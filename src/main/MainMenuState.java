package main;

import java.awt.Graphics2D;

import entity.SpriteNotFoundException;
import entity.enemies.EnemyManager;
import entity.towers.TowerManager;
import levels.Level;
import ui.MainMenuUI;

/**
 * Game state used when the player is on the main menu of the game
 * @author Ryan Sharp
 *
 */
public class MainMenuState implements GameState{

	private MainMenuUI ui;
	
	/**
	 * Create new gameplay state using the given tile, enemy, and tower managers.
	 * @param tileM
	 * @param towerM
	 * @param enemyM
	 */
	public MainMenuState() {
		try {
			ui = new MainMenuUI();
		}
		catch(SpriteNotFoundException e) {
			System.out.println("Error: MainMenuUI could not find necessary images.");
		}
		
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endState() {
		ui.remove();
	}

	@Override
	public StateType getType() {
		return StateType.MENU;
	}

	@Override
	public Level getLevel() {
		return null;
	}

	@Override
	public TowerManager getTowerManager() {
		return null;
	}

	@Override
	public EnemyManager getEnemyManager() {
		return null;
	}

	@Override
	public Player getPlayer() {
		return null;
	}

}
