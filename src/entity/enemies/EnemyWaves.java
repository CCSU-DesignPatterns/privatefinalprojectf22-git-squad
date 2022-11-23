package entity.enemies;

import java.util.*;
import main.*;

public class EnemyWaves {
	protected GamePanel gp;					// The main game panel
	protected List<IEnemy> enemySet;		// List of enemies to be spawned (cloned)
	protected int enemyWaves[][];			// Array that stores the data imported from the enemy waves file
	private int spawnRate = 1;				// Enemy spawn rate. Default is 1
	private int frameCount = 12;			// Spawn enemies every n frames. Default is 12
	private EnemyFactory enemyFactory = new EnemyFactory();
	
	/**
	 * Default constructor
	 */
	public EnemyWaves(GamePanel gp) { 
		this.gp = gp;
		enemySet = new ArrayList<IEnemy>();
	}
	
	/**
	 * Loads the set of enemies to be used in the currently active level
	 */
	public void loadEnemySet() {
		// Create only base enemies for now
		// Note that the starting position is set to default values
		// Further development is needed to define the correct starting point
		enemyFactory.createEnemy(1, 1, EnemyType.EnemyType1);
		enemyFactory.createEnemy(1, 1, EnemyType.EnemyType2);
		enemyFactory.createEnemy(1, 1, EnemyType.EnemyType3);
	}
	
	/**
	 * Loads the enemy wave array data
	 */
	public void loadEnemyWaves() { 
		// TODO Implement logic to load the array data
	}
	
	/**
	 * Updates all enemies/screen data/etc.
	 */
	public void update() { 
		// TODO Implement logic to update all enemies, screen, etc. 
	}
	
	/**
	 * Spawns a new enemy and adds it to the EnemyManager
	 * @param index The ArrayList index of the enemy to spawn
	 */
	public void spawnEnemy(int index) { 
		gp.enemyM.add(enemySet.get(index).clone());
	}
	
	/**
	 * Moves to the next 
	 */
	public void nextWave() { }
}
