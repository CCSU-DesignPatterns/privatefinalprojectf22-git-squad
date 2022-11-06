package levels;

import java.awt.*;

/**
 * Levels interface
 */
public interface iLevel {
    // Not sure if this method should be part of the interface
    //void drawLevel();

    /**
     * Spawns a wave of enemies
     */
    //void spawnEnemies();

    /**
     * Draws the level
     */
    public void drawLevel(Graphics2D g2);
}
