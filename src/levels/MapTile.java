package levels;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import entity.SpriteNotFoundException;

/**
 * Defines a graphics tile for use in drawing a level
 */
public class MapTile {

    protected BufferedImage sprite;
    protected boolean collision = false;

    public MapTile(String path) throws SpriteNotFoundException {
        try {
            setSprite(path);
        }
        catch (SpriteNotFoundException e) {
        	System.out.println("Could not find sprite at " + path);
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
    
    /**
     * Check whether the tile has collision
     * @return True if has collision, otherwise false
     */
    public boolean getCollision() { return collision; }
}
