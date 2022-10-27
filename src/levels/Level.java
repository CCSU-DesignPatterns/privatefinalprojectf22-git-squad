package levels;

/**
 * Abstract Level class that serves as a template for other Levels
 */
public abstract class Level implements iLevel {
    private Path path;
    private int mapSize = 0;
    //private Wave curWave;  (Not yet implemented)

    /**
     * Default constructor
     */
    public Level(int size) {
        // Not yet fully implemented
        if(size > 0)
            mapSize = size;

        drawLevel();
    }

    /**
     * Spawns a wave of enemies
     */
    public void spawnEnemies() {
        //Not yet implemented. This is for testing only
        System.out.println("Enemies spawned");
    }

    /**
     * Draws the level on the screen
     */
    private void drawLevel() {
        //Not yet implemented. This is for testing only
        System.out.println("New level drawn");
    }
}
