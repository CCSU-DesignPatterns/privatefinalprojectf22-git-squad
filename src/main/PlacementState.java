package main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import entity.enemies.EnemyManager;
import entity.towers.Tower;
import entity.towers.TowerManager;
import levels.Level;

public class PlacementState implements GameState {

	// Input handling and game thread
	private Level level;
	private TowerManager towerM;
	private EnemyManager enemyM;
	private Player player;
	private Tower tower;
	private GamePanel gp;
	private Composite transparent, opaque;
	private JLabel instructions;
	
	public PlacementState(Level level, TowerManager towerM, EnemyManager enemyM, Player player, Tower tower) {
		this.level = level;
		this.towerM = towerM;
		this.enemyM = enemyM;
		this.player = player;
		this.tower = tower;
		this.gp = GamePanel.getInstance();
		transparent = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.75f);
		opaque = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f);
		
		instructions = new JLabel();
		instructions.setFont(new Font("arial", Font.PLAIN, 40));
		instructions.setText("Click to place tower. Press esc to cancel.");
		instructions.setForeground(Color.white);
		instructions.setHorizontalAlignment(JLabel.CENTER);
		instructions.setVerticalAlignment(JLabel.CENTER);
		instructions.setBounds((int)((gp.SCREEN_WIDTH / 2) - (instructions.getPreferredSize().getWidth() / 2)), gp.TILE_SIZE, (int)instructions.getPreferredSize().getWidth(), (int)instructions.getPreferredSize().getHeight());
		Main.getPane().add(instructions, Integer.valueOf(1));
	}
	
	@Override
	public void update() {
		Point p = MouseInfo.getPointerInfo().getLocation();
		SwingUtilities.convertPointFromScreen(p, gp);
		
		towerM.update();
		enemyM.update();
		tower.setPos(p.x - (gp.TILE_SIZE / 2), p.y - (gp.TILE_SIZE / 2));
		tower.getCollisionBox().setLocation(p.x - ((tower.getType().getCollisionInfo()[2] * gp.SCALE) / 2), p.y - ((tower.getType().getCollisionInfo()[3] * gp.SCALE) / 2));
		CollisionChecker.check(tower);
	}

	@Override
	public void draw(Graphics2D g2) {
		level.draw(g2);
		enemyM.draw(g2);
		towerM.draw(g2);
		if(tower.getCollision()) {
			g2.setComposite(transparent);
			tower.draw(g2);
			g2.setComposite(opaque);
		}
		else {
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
			g2.setColor(Color.white);
			g2.fillOval(tower.getX() - tower.getRange() + (gp.TILE_SIZE / 2), tower.getY() - tower.getRange() + (gp.TILE_SIZE / 2), tower.getRange() * 2, tower.getRange()  * 2);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
			tower.draw(g2);
			g2.dispose();
		}
		
	}

	@Override
	public StateType getType() {
		return StateType.PLACEMENT;
	}

	@Override
	public void endState() {
		Main.getPane().remove(instructions);
	}
	
	/**
	 * Get the tower that is being placed
	 * @return {@link Tower} being placed
	 */
	public Tower getTower() { return tower; }
	
	/**
	 * Get this state's tile manager
	 * @return Current {@link TileManager}
	 */
	public Level getLevel() { return level; }
	
	/**
	 * Get this state's tower manager
	 * @return Current {@link TowerManager}
	 */
	public TowerManager getTowerManager() { return towerM; }
	
	/**
	 * Get this state's enemy manager
	 * @return Current {@link EnemyManager}
	 */
	public EnemyManager getEnemyManager() { return enemyM; }
	
	/**
	 * Get this state's player
	 * @return Current {@link Player}
	 */
	public Player getPlayer() { return player; }
	
}
