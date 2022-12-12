package levels;

/**
 * Creates levels
 * @author Ricardo Almeida
 */
public class LevelFactory implements iLevelFactory{
    /**
     * Constructor that takes a level number
     * @param levelNum Integer representing a level number
     */
    public LevelFactory(int levelNum) { createLevel(levelNum); }

    /**
     * Creates a new level
     * @param levelNum The level number
     * @return A new level
     */
    @Override
    public iLevel createLevel(int levelNum) {
        switch (levelNum) {
            case '1':
                return new Level1();
            case '2':
                return new Level2();
            case '3':
                return new Level3();
            default:
                return null;
        }
    }
}
