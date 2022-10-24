package td.data;

import com.badlogic.gdx.graphics.Pixmap;

public class MapSquare {
    private Coordinates position;
    private int size;   // Not sure if this is needed
    private int length = 1;
    private int width = 1;

    public MapSquare(Coordinates pos, int l, int w) {
        if(l > 1)
            length = l;
        if(w > 1)
            width = w;

        if(pos != null)
            position = pos;
    }

    public Coordinates getPosition() { return position; }
}
