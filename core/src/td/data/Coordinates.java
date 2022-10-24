package td.data;

/**
 * Generic coordinates class.
 * Stores positional data to be used with various objects
 */
public class Coordinates {
    private int xPos = 0;
    private int yPos = 0;

    /**
     * Default constructor
     * @param x Integer representing an x coordinate
     * @param y Integer representing an y coordinate
     */
    public Coordinates(int x, int y) {
        if(x > 0)
            xPos = x;
        if(y > 0)
            yPos = y;
    }

    /**
     * Returns an instance of Coordinates
     * @return Coordinates
     */
    public Coordinates getCoordinates() { return this; }
}
