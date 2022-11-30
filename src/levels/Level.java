package levels;

import main.GamePanel;
import java.awt.Graphics2D;

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
    GamePanel gp;

    /* This array contains references to each of the distinct tiles that can be drawn in the level.
     * Think of this as your "artist's palette" when drawing a level. */
    MapTile[] tileSet;

    /* This 2D array contains the index of the tile in tileSet that is to be drawn on each tile of the screen.
     * This is the actual layout of the level. */
    int levelMap[][];

    /**
     * Default constructor
     */
    public Level() {
        gp = GamePanel.getInstance();
        tileSet = new MapTile[10];
        levelMap = new int[gp.MAX_SCREEN_COL][gp.MAX_SCREEN_ROW];
        loadTileSet();
        loadMap();
    }

    /**
     * Spawns a wave of enemies
     */
/*    public void spawnEnemies() {
        //Not yet implemented. This is for testing only
        System.out.println("Enemies spawned");
    }*/

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

}
