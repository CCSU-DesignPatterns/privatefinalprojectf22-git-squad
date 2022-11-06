package tile;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import entity.SpriteNotFoundException;

public class Tile {
	public BufferedImage sprite;
	public boolean collision = false;
	
	void setSprite(String path) throws SpriteNotFoundException {
		try {
			sprite = ImageIO.read(getClass().getResourceAsStream(path));
		}
		catch(IOException e) {
			throw new SpriteNotFoundException(path);
		}
	}
}
