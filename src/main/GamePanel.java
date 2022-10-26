package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;

/**
 * 
 * @author RyiSnow, Ryan Sharp
 *
 */
public class GamePanel extends JPanel implements Runnable{
	
	private static GamePanel instance;
	
	// Game Screen Settings
	private final int ORIGINAL_TILE_SIZE = 16; // Original art will be 16x16 pixels
	private final int SCALE = 3; // Art will be scaled up 3x due to larger screen resolution
	public final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE;
	
	private final int MAX_SCREEN_COL = 20; // Screen width will fit 16 tiles
	private final int MAX_SCREEN_ROW = 15; // Screen height will fit 12 tiles
	private final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COL;
	private final int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREEN_ROW;
	
	private final int FPS = 60;
	
	KeyHandler keyH = new KeyHandler();
	MouseHandler mouseH = new MouseHandler();
	Thread gameThread;
//	Player player = new Player(this, keyH);
	
	private GamePanel() {
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.green);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.addMouseListener(mouseH);
		this.setFocusable(true);
	}
	
	public static GamePanel getInstance() {
		if(instance == null)
			instance = new GamePanel();
		return instance;
	}
	
	void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

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
				System.out.println("FPS: " + drawCount);
				drawCount = 0;
				timer = 0;
			}
		}
	}
	
	private void update() {
//		player.update();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
//		player.draw(g2);
		g2.dispose();
	}
}
