package entity;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Entity {
	protected int x, y;	
	protected BufferedImage sprite;
	protected GamePanel gp;
	
	protected Entity(int x, int y, String spritePath) {
		this.x = x;
		this.y = y;
		this.gp = GamePanel.getInstance();
		try {
			setSpriteImage(spritePath);
		}
		catch(SpriteNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	protected void setSpriteImage(String spritePath) throws SpriteNotFoundException {
		try {
			this.sprite = ImageIO.read(getClass().getResourceAsStream(spritePath));
		}
		catch (IOException e) {
			throw new SpriteNotFoundException(spritePath);
		}
	}
}
