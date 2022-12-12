package entity.enemies;

import java.util.*;

import entity.Direction;
import levels.Level;

import java.io.*;
import main.*;

/**
 * Handles the preparation and creation of enemy waves as well as spawning enemies
 * @author Ricardo Almeida, minor changes by Ryan Sharp
 *
 */
public class EnemyWaves {
	protected GamePanel gp;					// The main game panel
	protected List<IEnemy> enemySet;		// List of enemies to be spawned (cloned)
	protected int enemyWaves[][];	// Array that stores the data imported from the enemy waves file
	private int spawnRate = 12;				// Enemy spawn rate. Default is 1
	private int frameCount = 0;				// Spawn enemies every n frames. Default is 12
	private EnemyFactory enemyFactory = new EnemyFactory();
	private int currentWave = -1;
	private int currentIndex = 0;
	private boolean running;
	private int spawnX, spawnY;
	private Direction startDir;
	
	/**
	 * Default constructor
	 */
	public EnemyWaves(Level level, Difficulty d) { 
		this.gp = GamePanel.getInstance();
		setSpawnInfo(level.getStartX(), level.getStartY(), level.getStartDir());
		enemySet = new ArrayList<IEnemy>();
		loadEnemySet();
		loadEnemyWaves(d.getPath());
	}
	
	private void setSpawnInfo(int x, int y, Direction dir) {
		spawnX = x;
		spawnY = y;
		startDir = dir;
		
		System.out.println("Start x: " + spawnX + ", start Y: " + spawnY + ", Start dir: " + startDir.toString());
	}
	
	/**
	 * Loads the set of enemies to be used in the currently active level
	 */
	public void loadEnemySet() {
		// Create only base enemies for now
		// Note that the starting position is set to default values
		// Further development is needed to define the correct starting point
		enemySet.add(enemyFactory.createEnemy(spawnX, spawnY, EnemyType.EnemyType1, startDir));
		enemySet.add(enemyFactory.createEnemy(spawnX, spawnY, EnemyType.EnemyType2, startDir));
		enemySet.add(enemyFactory.createEnemy(spawnX, spawnY, EnemyType.EnemyType3, startDir));
	}
	
	private void createJaggedArray(String filePath) {
		InputStream is = getClass().getResourceAsStream(filePath);
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(is));
        
        int numLines = 0;
        try {
        	while(fileReader.readLine() != null)
        		numLines++;
        }
        catch(IOException e) {
        	System.out.println("Something went wrong while reading the level waves file!");
        	e.printStackTrace();
        }
        
        //System.out.println(numLines + " lines found");
        enemyWaves = new int[numLines][];
	}
	
	/**
	 * Loads the enemy wave array data
	 */
	public void loadEnemyWaves(String filePath) { 
		createJaggedArray(filePath);
		BufferedReader fileReader;
		
		try {
            InputStream is = getClass().getResourceAsStream(filePath);
            fileReader = new BufferedReader(new InputStreamReader(is));
			
			String line[] = new String[1];
			int lineIndex = 0;
			
			while(lineIndex < enemyWaves.length) {
				line = fileReader.readLine().split(" ");
				enemyWaves[lineIndex] = new int[line.length];
				//System.out.println("Line " + lineIndex + " has " + line.length + " numbers");
				for(int i = 0; i < line.length; i++) {
					int digit = Integer.parseInt(line[i]);
					enemyWaves[lineIndex][i] = digit;
					//System.out.print(digit + " ");
				}
				
				//System.out.println();
				
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
			if(running && currentIndex < enemyWaves[currentWave].length) {
				spawnNext();
			}
			else {
				running = false;
			}
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
		running = true;
		currentIndex = 0;
		currentWave++;
	}
	
	/**
	 * Check whether the curret wave is still spawning enemies
	 * @return true if spawning, false if done
	 */
	public boolean getRunning() { return running; }
}
