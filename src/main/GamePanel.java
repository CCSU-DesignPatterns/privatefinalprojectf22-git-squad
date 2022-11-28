package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.enemies.EnemyManager;
import entity.towers.TowerManager;
import tile.TileManager;

//import entity.Player;

/**
 * {@summary This class is responsible for rendering the graphics of the game as well as holding the game thread,
 * which is what allows the game to run continuously without constant user input.}
 * @author Ryan Sharp, RyiSnow (https://www.youtube.com/c/RyiSnow)
 *
 */
public class GamePanel extends JPanel implements Runnable{
	
	private static GamePanel instance;
	
	// Game Screen Settings
	private final int ORIGINAL_TILE_SIZE = 16; // Original art will be 16x16 pixels
	private final int SCALE = 3; // Art will be scaled up 3x due to larger screen resolution
	public final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE; // Needs to be public for entities to draw the correct size tiles
	
	public final int MAX_SCREEN_COL = 20; // Screen width will fit 16 tiles
	public final int MAX_SCREEN_ROW = 15; // Screen height will fit 12 tiles
	public final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COL;
	public final int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREEN_ROW;
	
	private final int FPS = 60;
	
	// Game Object Management
	private TileManager tileM;
	private TowerManager towerM;
	public final EnemyManager ENEMY_MANAGER;
	
	// Input Handling
	private KeyHandler keyH;
	private MouseHandler mouseH;
	
	// Game Variables
	private GameState state;
	private StateType stateType;
	private Thread gameThread;
	
	private GamePanel() {
		instance = this;
		
		this.tileM = new TileManager();
		this.towerM = new TowerManager();
		this.ENEMY_MANAGER = new EnemyManager();
		this.keyH = new KeyHandler();
		this.mouseH = new MouseHandler();
		this.state = new PlayingState(tileM, towerM, ENEMY_MANAGER);
		stateType = StateType.PLAY;
		
		this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.addMouseListener(mouseH);
		this.setFocusable(true);
	}
	
	/**
	 * {@summary Used to create/get singleton instance of GamePanel. Only one instance should ever exist at a given time.}
	 * @author Ryan Sharp
	 */
	public static GamePanel getInstance() {
		if(instance == null)
			instance = new GamePanel();
		return instance;
	}
	
	/**
	 * {@summary Used by Main.java to start the game once the JFrame is set up.}
	 * @author RyiSnow
	 */
	void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	/**
	 * {@summary Called automatically by the game thread upon start. Does not need any outside influence, but must be public due to inheritance.}
	 * @author RyiSnow
	 */
	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		
		while(gameThread != null) {
			
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if(delta > 1) {
				update();
				repaint();
				drawCount++;
				delta--;
			}
			
			if(timer >= 1000000000) {
//				System.out.println("FPS: " + drawCount);
				drawCount = 0;
				timer = 0;
			}
		}
	}
	
	/**
	 * {@summary Responsible for updating the position/state of every graphical component of the game.}
	 */
	private void update() {
		state.update();
	}
	
	/**
	 * {@summary Responsible for redrawing every graphical component of the game once all updates have occurred.}
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		state.draw(g2);
	}
	
	public StateType getStateType() { return stateType; }
	
	public void updateState(StateType type) {
		switch(type) {
		case PLAY:
			state = new PlayingState(tileM, towerM, ENEMY_MANAGER);
			stateType = StateType.PLAY;
			break;
		case PAUSE:
			state = new PausedState(tileM, towerM, ENEMY_MANAGER);
			stateType = StateType.PAUSE;
			break;
		}
	}
}
