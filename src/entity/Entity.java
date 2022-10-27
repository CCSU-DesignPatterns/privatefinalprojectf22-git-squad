package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

/**
 * {@summary Parent of all entities in the game. Handles basic properties of all entities like position and sprite.}
 * @author Ryan Sharp
 *
 */
public abstract class Entity {
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
	
	/**
	 * {@summary Used to update the position/state of this individual entity. Will be called once per frame.}
	 */
	protected abstract void update();
	
	/**
	 * {@summary Used to repaint this individual entity after update(). Will be called once per frame.}
	 * @param g2 Graphics element responsible for drawing on the screen.
	 */
	protected abstract void draw(Graphics2D g2);
}
