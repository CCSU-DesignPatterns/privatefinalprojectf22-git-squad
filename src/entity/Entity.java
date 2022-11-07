package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import common.Coordinates;
import main.GamePanel;

/**
 * {@summary Parent of all entities in the game. Handles basic properties of all entities like position and sprite.}
 * @author Ryan Sharp
 *
 */
public abstract class Entity implements iEntity {
	private Coordinates curPos;
//	protected int x, y;
	protected BufferedImage sprite;
	protected GamePanel gp;
	protected int health = 10;	// Default health is 10

	/**
	 *
	 * @param position Coordinates instance representing the
	 * @param spritePath Path to the sprite resource
	 */
	public Entity(Coordinates position, String spritePath) {
		this.curPos = position;
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
	 * Returns the coordinates of the current Entity object
	 * @return Coordinates object
	 */
	public Coordinates getCurPos() { return curPos; }

	/**
	 * Sets the entity's current position
	 * @param curPos Instance of a Coordinates object
	 */
	public void setPos(Coordinates curPos) {
		this.curPos = curPos;
	}

	public void takeDamage(int damageAmount) {
		if(health >= damageAmount) {
			health -= damageAmount;
		}
		else {
			health = 0;
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

	/**
	 * Equals override
	 * @return boolean True or False
	 */
	@Override
	public boolean equals(Object obj) {
		if(!this.getClass().equals(obj.getClass())) {
			return false;
		}
		else if(this.curPos.equals(((Entity)obj).getCurPos()) &&
				this.gp.equals(((Entity)obj).gp) &&
				this.sprite.equals(((Entity)obj).sprite)) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * hashCode override
	 * @return integer representing the hashcode for the current instance
	 */
	@Override
	public int hashCode() {
		int output = super.hashCode();
		output += curPos.hashCode() + sprite.hashCode() + gp.hashCode();

		return output;
	}

	/**
	 * toString override
	 * @return String representation of the current instance
	 */
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append(String.format("Type: %s\n", this.getClass().toString()));
		output.append(String.format("Coordinates: x=%d, y=%d\n", this.getCurPos().getXPos(), this.getCurPos().getYPos()));
		output.append(String.format("Sprite: %s", sprite.toString()));

		return output.toString();
	}
}