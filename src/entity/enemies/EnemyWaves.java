package entity.enemies;

import java.util.*;
import java.io.*;
import main.*;

public class EnemyWaves {
	protected GamePanel gp;					// The main game panel
	protected List<IEnemy> enemySet;		// List of enemies to be spawned (cloned)
	protected int enemyWaves[][] = new int[10][25];	// Array that stores the data imported from the enemy waves file
	private int spawnRate = 12;				// Enemy spawn rate. Default is 1
	private int frameCount = 0;				// Spawn enemies every n frames. Default is 12
	private EnemyFactory enemyFactory = new EnemyFactory();
	private int currentWave = 0;
	private int currentIndex = 0;
	
	/**
	 * Default constructor
	 */
	public EnemyWaves() { 
		this.gp = GamePanel.getInstance();
		enemySet = new ArrayList<IEnemy>();
		loadEnemySet();
		loadEnemyWaves("/difficulties/Easy-Difficulty.txt");
	}
	
	/**
	 * Loads the set of enemies to be used in the currently active level
	 */
	public void loadEnemySet() {
		// Create only base enemies for now
		// Note that the starting position is set to default values
		// Further development is needed to define the correct starting point
		enemySet.add(enemyFactory.createEnemy(1, 1, EnemyType.EnemyType1));
		enemySet.add(enemyFactory.createEnemy(1, 1, EnemyType.EnemyType2));
		enemySet.add(enemyFactory.createEnemy(1, 1, EnemyType.EnemyType3));
	}
	
	/**
	 * Loads the enemy wave array data
	 */
	public void loadEnemyWaves(String filePath) { 
		BufferedReader fileReader;
		
		try {
            InputStream is = getClass().getResourceAsStream(filePath);
            fileReader = new BufferedReader(new InputStreamReader(is));
			
			String line[] = new String[1];
			int lineIndex = 0;
			
			while(lineIndex < enemyWaves.length) {
				line = fileReader.readLine().split(" ");
				
				for(int i = 0; i < line.length; i++) {
					int digit = Integer.parseInt(line[i]);
					enemyWaves[lineIndex][i] = digit;
					System.out.print(digit + " ");
				}
				
				System.out.println();
				
				lineIndex++;
			}
			
			// Close the reader
			fileReader.close();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Updates all enemies/screen data/etc.
	 */
	public void update() { 
		frameCount++;
		
		if(frameCount > spawnRate) {
			spawnNext();
			frameCount = 0;
		}
	}
	
	/**
	 * Spawns a new enemy and adds it to the EnemyManager
	 * @param index The ArrayList index of the enemy to spawn
	 */
	public void spawnNext() {
		int index = enemyWaves[currentWave][currentIndex] - 1;
		if(index >= 0) {
			gp.getState().getEnemyManager().add(enemySet.get(index).clone());	
		}
		currentIndex++;
	}
	
	/**
	 * Spawns the next wave of enemies
	 */
	public void nextWave() {
//		for(int i = 0; i < enemyWaves[currentWave].length; i++) {
//			spawnEnemy(enemyWaves[currentWave][i] - 1);
//		}
		currentIndex = 0;
		currentWave++;
	}
}
