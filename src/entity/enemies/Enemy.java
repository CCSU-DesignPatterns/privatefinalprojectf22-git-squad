package entity.enemies;

import java.awt.Rectangle;
import entity.Entity;

/**
 * 
 * @author Pedro Arias, refactored by Ricardo Almeida
 *
 */
public class Enemy extends Entity implements IEnemy {
	// Attributes
	protected int speed = 2;	// Pixels per update. Default is 2
	protected int distTraveled = 0;	// The distance traveled in pixels
	/**
	 * Constructor that takes a coordinates object and a String representing
	 * a path to a sprite image for this enemy.
	 * @param health Integer value that represents strength of an enemy
	 * @param spritePath Path to a graphical representation of an enemy
	 */
	public Enemy(int x, int y, EnemyType type) {
		super(x, y, type.getSpritePath());
		this.setHealth(type.getHealth());
		this.setStrength(type.getStrength());
		this.setCollisionBox(new Rectangle(10,10));	// This might have to be updated
	}
	
	/**
	 * Updates the enemy's position
	 * @param newPos
	 */
	protected void move() {
		switch (this.currentDirection) {
			case UP:
				y -= speed;
				break;
			case DOWN:
				y += speed;
				break;
			case RIGHT:
				x += speed;
				break;
			case LEFT:
				x -= speed;
				break;				
		}
		
		// Add to the distance traveled
		addDistance();
	};
	
	/**
	 * Adds to the distance traveled by the Enemy entity
	 */
	protected void addDistance() {
		distTraveled += speed;
	}
	
	/**
	 * Returns the current speed of the enemy
	 * @return speed Integer representing the speed of the enemy object
	 */
	public int getSpeed() { return speed; }
	
	/**
	 * Sets the speed of the enemy instance
	 * @param speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
		
	/**
	 * Overrides the default update method 
	 */
	@Override
	public void update() {
		// Move this enemy to the new position
		this.move();
		
		// TODO Other related update operations if needed
	}
	
	/**
	 * Returns a clone of an instance of Enemy
	 */
	public IEnemy clone() {
		//TODO Implement object cloning
		return null;
	}
	
	/**
	 * TODO Needs implementation
	 */
	public IEnemy getComposite() {
		return null;
	}

	/**
	 * Returns the distance traveled by the enemy instance
	 */
	public int getDistanceTraveled() {
		return distTraveled;
	}
	
	/**
	 * Superclass override for Interface implementation
	 */
	@Override
	public void setHealth(int health) {
		super.setHealth(health);
	}
	
	/**
	 * Superclass override for Interface implementation
	 */
	@Override
	public void setStrength(int strength) {
		super.setStrength(strength);
	}
	
	/**
	 * @return Hashcode for the current instance of Enemy
	 */
	@Override
	public int hashCode() {
		return super.hashCode() + speed;
	}

	/**
	 *
	 * @param obj The object to compare against
	 * @return boolean True or False
	 */
	@Override
	public boolean equals(Object obj) {
		if(super.equals((Enemy)obj) && speed == ((Enemy)obj).speed)
			return true;
		return false;
	}

	/**
	 * Returns a string representation of the object
	 * @return Instance information
	 */
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append(String.format("%s", super.toString()));		
		output.append(String.format("Speed: %d", speed));

		return output.toString();
	}
}
