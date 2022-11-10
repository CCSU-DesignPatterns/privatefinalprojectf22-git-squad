package levels;

import common.Coordinates;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import entity.SpriteNotFoundException;

/**
 * Defines a graphics tile for use in drawing a level
 */
public class MapTile {
/*    private Coordinates position;
    private int size;   // Not sure if this is needed
    private int length = 1;
    private int width = 1;

    public MapTile(Coordinates pos, int l, int w) {
        if(l > 1)
            length = l;
        if(w > 1)
            width = w;

        if(pos != null)
            position = pos;
    }

    public Coordinates getPosition() { return position; }*/

    public BufferedImage sprite;
    public boolean collision = false;

    public MapTile(String path) throws SpriteNotFoundException {
        try {
            setSprite(path);
        }
        catch (SpriteNotFoundException e) {
            // Needs to be set to a "default" sprite
            setSprite("/tiles/Grass.png");
        }
    }

    void setSprite(String path) throws SpriteNotFoundException {
        try {
            sprite = ImageIO.read(getClass().getResourceAsStream(path));
        }
        catch(IOException e) {
            throw new SpriteNotFoundException(path);
        }
    }
}
