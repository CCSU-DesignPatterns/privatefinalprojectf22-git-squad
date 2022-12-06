package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.UtilityCenter;

/**
 * {@summary Parent of all entities in the game. Handles basic properties of all entities like position and sprite.}
 * @author Ryan Sharp, refactored by Ricardo Almeida
 *
 */
public abstract class Entity {
	protected int x;
	protected int y;
	protected int health = 1;	// Default health is 1
	protected int strength = 1;	// Default strength is 1
	protected Rectangle collisionBox = new Rectangle(1, 1);
	protected BufferedImage sprite;
	protected double angle = 0;
	protected GamePanel gp;
	protected boolean collision = false;
	protected Direction currentDirection = Direction.RIGHT;	// Default direction is RIGHT
	
	/**
	 *
	 * @param position Coordinates instance representing the
	 * @param spritePath Path to the sprite resource
	 */
	public Entity(int x, int y, String spritePath) {
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
	
	/**
	 * Set the sprite of an entity
	 * @param spritePath
	 * @throws SpriteNotFoundException
	 */
	protected void setSpriteImage(String spritePath) throws SpriteNotFoundException {
		try {
			this.sprite = ImageIO.read(getClass().getResourceAsStream(spritePath));
			this.sprite = UtilityCenter.scaleImage(sprite, gp.TILE_SIZE, gp.TILE_SIZE);
		}
		catch (IOException e) {
			throw new SpriteNotFoundException(spritePath);
		}
	}
	
	/**
	 * Returns the entity's x value
	 * @return <code>int</code> x value 
	 */
	public int getX() { return x; }
	
	/**
	 * Returns the entity's y value
	 * @return <code>int</code> y value 
	 */
	public int getY() { return y; }
	
	/**
	 * Set the position of an entity to the given x and y pixel coordinates
	 * @param x
	 * @param y
	 */
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Check whether an entity has collided with an object
	 * @return true if collided, otherwise false
	 */
	public boolean getCollision() { return collision; }		

	/**
	 * Set whether an entity has collided with an object
	 * @param col - true if collided, otherwise false
	 */
	public void setCollision(boolean col) { collision = col; }
	
	/**
	 * @return Entity instance health
	 */
	public int getHealth() {
		return health;
	}
	
	/**
	 * @return Entity instance strength
	 */
	public int getStrength() {
		return strength;
	}
	
	/**
	 * @return The collision box
	 */
	public Rectangle getCollisionBox() {
		return collisionBox;
	}
	
	/**
	 * Returns the current entity direction
	 * @return Direction The current entity direction
	 */
	public Direction getDirection() { return currentDirection; }
	
	/**
	 * Sets the health of the entity instance
	 * @param health The amount of health to set
	 */
	protected void setHealth(int health) {
		if(health > 0)
			this.health = health;
		else
			this.health = 0;
	}
	
	/**
	 * Sets the strength of the entity instance 
	 * @param strength Strength to set
	 */
	protected void setStrength(int strength) {
		if(strength > 0)
			this.strength = strength;
	}

	/**
	 * Sets the collision box for this instance
	 * @param box Rectangle object
	 */
	public void setCollisionBox(Rectangle box) {
		this.collisionBox = box;
	}
	
	/**
	 * Sets a new direction for the entity
	 * @param newDirection The new direction to set
	 */
	public void setDirection(Direction newDirection) {
		currentDirection = newDirection;
	}
	
	/**
	 * Set the angle at which to draw the entity
	 * @param angle in radians
	 */
	protected void setAngle(double angle) { this.angle = angle; }
	
	/**
	 * Causes the entity to take damage
	 * @param damageAmount Integer representing amount of damage to the entity
	 */
	public void takeDamage(int damageAmount) {
		setHealth(this.health - damageAmount);
	}
		
	/**
	 * {@summary Used to update the position/state of this individual entity. Will be called once per frame.}
	 */
	public abstract void update();
	
	/**
	 * {@summary Used to repaint this individual entity after update(). Will be called once per frame.}
	 * @param g2 Graphics element responsible for drawing on the screen.
	 */
	public void draw(Graphics2D g2) {
		AffineTransform original = g2.getTransform();
		AffineTransform tx = AffineTransform.getRotateInstance(angle, x + (gp.TILE_SIZE / 2), y + (gp.TILE_SIZE / 2));
		g2.setTransform(tx);
		g2.drawImage(sprite, x, y, null);
		g2.setTransform(original);	
	}

	
	/**
	 * Equals override
	 * @return boolean True or False
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj != null && (x == ((Entity)obj).x) && (y == ((Entity)obj).y) &&
				health == ((Entity)obj).health &&
				strength == ((Entity)obj).strength &&
				collisionBox.equals(((Entity)obj).collisionBox) &&
				sprite.equals(((Entity)obj).sprite) &&
				gp.equals(((Entity)obj).gp) &&
				sprite.equals(((Entity)obj).sprite) &&
				collision == ((Entity)obj).collision &&
				currentDirection == ((Entity)obj).currentDirection) {
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
		output += ((Integer)x).hashCode() + ((Integer)y).hashCode() + sprite.hashCode() + gp.hashCode();
		output += x + y + health + strength + collisionBox.hashCode() + sprite.hashCode() + gp.hashCode() + currentDirection.hashCode();

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
		output.append(String.format("Coordinates: x=%d, y=%d\n", x, y));
		output.append(String.format("Health: %d\n", health));
		output.append(String.format("Strength: %d\n", strength));
		output.append(String.format("Sprite: %s", sprite.toString()));
		output.append(String.format("Direction: %s\n", currentDirection.toString()));

		return output.toString();
	}
}
