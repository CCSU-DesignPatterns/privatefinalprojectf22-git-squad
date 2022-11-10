package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import entity.SpriteNotFoundException;
import main.GamePanel;

/**
 * 
 * @author RyiSnow, Ryan Sharp
 * 
 * <p>
 * TileManager is responsible for loading and drawing the background tile map of the level.
 * Levels are designed by creating a space delimited text file containing the index of the 
 * tile set to be drawn on each square of the map. The text file should have the same dimensions as
 * the screen, unless a world map and camera movement are being implemented.
 * <p>
 *
 */
public class TileManager {
	GamePanel gp;
	
	/* This array contains references to each of the distinct tiles that can be drawn in the level. 
	 * Think of this as your "artist's palette" when drawing a level. */
	Tile[] tileSet;
	
	/* This 2D array contains the index of the tile in tileSet that is to be drawn on each tile of the screen.
	 * This is the actual layout of the level. */
	int levelMap[][];
	
	public TileManager() {
		gp = GamePanel.getInstance();
		tileSet = new Tile[10];
		levelMap = new int[gp.MAX_SCREEN_COL][gp.MAX_SCREEN_ROW];
		loadTileSet();
		loadMap();
	}
	
	/**
	 * This method prepares the tileSet by loading each individual tile that can be drawn.
	 */
	public void loadTileSet() {
		try {
			tileSet[0] = new Tile();
			tileSet[0].setSprite("/tiles/Grass.png");
			tileSet[0].collision = true;
			
			tileSet[1] = new Tile();
			tileSet[1].setSprite("/tiles/Path.png");
		}
		catch(SpriteNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * This method loads the map of the level from a text file. The text file contains space delimited integers of the same dimensions
	 * as the level itself. Each integer represents the index in tileSet of the tile to be drawn in the corresponding square on the map.
	 */
	void loadMap() {
		try {
			InputStream is = getClass().getResourceAsStream("/levels/level01.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			for(int row = 0; row < gp.MAX_SCREEN_ROW; row++) {
				String line = br.readLine();
				String numbers[] = line.split(" ");
				
				for(int col = 0; col < gp.MAX_SCREEN_COL; col++) {
					int num = Integer.parseInt(numbers[col]);
					levelMap[col][row] = num;
				}
			}
			
			br.close();
		}
		catch(Exception e) {
			
		}
	}
	
	/**
	 * Draws each tile of the level as dictated by levelMap.
	 * 
	 * @param g2 The Graphics2D object drawing the scene.
	 */
	public void draw(Graphics2D g2) {
		int x = 0, y = 0;
		
		for(int row = 0; row < gp.MAX_SCREEN_ROW; row++) {
			for(int col = 0; col < gp.MAX_SCREEN_COL; col++) {
				int tileNum = levelMap[col][row];
				
				g2.drawImage(tileSet[tileNum].sprite, x, y, gp.TILE_SIZE, gp.TILE_SIZE, null);
				x += gp.TILE_SIZE;
			}
			
			x = 0;
			y += gp.TILE_SIZE;
		}
	}
}
