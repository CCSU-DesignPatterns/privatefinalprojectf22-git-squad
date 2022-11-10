package common;

/**
 * Generic coordinates class.
 * Stores positional data to be used with various objects or entities
 *
 * @author Ricardo Almeida
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
        updateCoordinates(x, y);
    }

    /**
     * Returns an instance of Coordinates
     * @return Coordinates
     */
    public Coordinates getCoordinates() { return this; }

    /**
     * Updates the coordinates
     */
    public void updateCoordinates(int x, int y) {
        if(x > 0)
            xPos = x;
        if(y > 0)
            yPos = y;
    }

    /**
     * Returns the x coordinate
     * @return integer
     */
    public int getXPos() {
        return xPos;
    }

    /**
     * Returns the y coordinate
     * @return integer
     */
    public int getYPos() {
        return yPos;
    }

    /**
     * equals override
     * @param obj Object to compare against
     * @return boolean True or False
     */
    @Override
    public boolean equals(Object obj) {
        if(this.getClass().equals(obj.getClass())) {
            return true;
        }
        else if(xPos == ((Coordinates)obj).getXPos() && yPos == ((Coordinates)obj).getYPos()) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * hashCode override
     * @return integer representing the hashcode
     */
    @Override
    public int hashCode() {
        int output = xPos + yPos;
        return (xPos*2 + 2) + (yPos*3 + 5);
    }

    /**
     * toString override
     * @return String representation of Coordinates instance
     */
    @Override
    public String toString() {
        String output = String.format("Coordinates: x=%d, y=%d", xPos, yPos);
        return output;
    }
}
