package levels;

import main.GamePanel;
import java.awt.Graphics2D;
import entity.Direction;

/**
 * @author RyiSnow, Ryan Sharp, Ricardo Almeida (refactoring)
 * Abstract Level class that serves as a template for other Levels
 * <p>
 * This class is responsible for loading and drawing the background tile map of the level.
 * Levels are designed by creating a space delimited text file containing the index of the
 * tile set to be drawn on each square of the map. The text file should have the same dimensions as
 * the screen, unless a world map and camera movement are being implemented.
 * <p>
 *
 */
public abstract class Level implements iLevel {
    // The panel to draw the level in
    protected GamePanel gp;

    /* This array contains references to each of the distinct tiles that can be drawn in the level.
     * Think of this as your "artist's palette" when drawing a level. */
    protected MapTile[] tileSet;

    /* This 2D array contains the index of the tile in tileSet that is to be drawn on each tile of the screen.
     * This is the actual layout of the level. */
    protected int levelMap[][];
    
    // length of the path in pixels
    protected int pathLength;
    
    // Coordinates for the start point of the path. Default is (0,0)
    int startX = 0;
    int startY = 0;
    
    // Starting direction. Default is RIGHT
    Direction startDir = Direction.RIGHT;

    /**
     * Default constructor
     */
    public Level() {
        gp = GamePanel.getInstance();
        tileSet = new MapTile[10];
        levelMap = new int[gp.MAX_SCREEN_COL][gp.MAX_SCREEN_ROW];
    }

    /**
     *  Loads the set of map tiles
     */
    protected abstract void loadTileSet();

    /**
     * Loads the map data
     */
    protected abstract void loadMap();

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
    
    /**
     * Get this level's map data
     * @return 2D array of integers representing the tileSet index of the tiles that make up the map
     */
    public int[][] getMap() { return levelMap; }
    
    /**
     * Get this level's tile set
     * @return Array of MapTile objects which compose the map
     */
    public MapTile[] getTileSet() { return tileSet; }

    /**
     * Get the length of the path on this level in pixels
     * @return int length of path
     */
    public int getPathLength() { return pathLength; }
    
    /**
     * Returns the starting X coordinate for enemies
     * @return <code>int</code> Starting X coordinate
     */
    public int getStartX() { return startX; }
    
    /**
     * Returns the starting Y coordinate for enemies
     * @return <code>int</code> Starting Y coordinate
     */
    public int getStartY() { return startY; }
    
    /**
     * Returns the start direction for the enemies
     * @return <code>Direction</code> The start direction
     */
    public Direction getStartDir() { return startDir; }
}
