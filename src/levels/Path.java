package levels;

import java.util.LinkedList;

/**
 * Draws a path for enemies
 */
public class Path {
    private LinkedList<MapSquare> pathElements;
    private int pathLength = 1; // This may not be necessary

    public Path() {
        drawPath();
    }

    private void drawPath() {
        //Not yet implemented. This is for testing only
        System.out.println("Path drawn");
    }

    /**
     * Returns the path elements
     * @return LinkedList of path elements
     */
    public LinkedList getPath() {
        return pathElements;
    }
}
