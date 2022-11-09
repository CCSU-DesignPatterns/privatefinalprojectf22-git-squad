package entity.enemies;

import common.*;
import entity.Entity;

public abstract class Enemy extends Entity {
	private int health = 50;	// Health level. Default is 50
	private int strength = 20;	// Strength. Default is 20
	private Rectangle collisionBox = new Rectangle(1, 1);

	/**
	 * @param health integer value that represents strength of an enemy
	 * @param spritePath graphical representation of an enemy
	 */
	public Enemy(Coordinates coordinates, String spritePath) {
		super(coordinates, spritePath);
	}
	
	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * Causes the enemy instance to take damage
	 * @param damageAmount Integer representing amount of damage to the enemy instance
	 */
	public void takeDamage(int damageAmount) {
		setHealth(this.health - damageAmount);
	}
	
	// Sets the strength of the enemy instance 
	protected void setStrength(int strength) {
		if(strength > 0)
			this.strength = strength;
	}

	// Sets the health of the enemy instance
	protected void setHealth(int health) {
		if(health > 0)
			this.health = health;
		else
			this.health = 0;
	}
	
	/**
	 * @return Hashcode for the current instance of Enemy
	 */
	@Override
	public int hashCode() {
		// Not yet implemented
		return 1;
	}

	/**
	 *
	 * @param obj The object to compare against
	 * @return boolean True or False
	 */
	@Override
	public boolean equals(Object obj) {
		// Not yet implemented
		return false;
	}

	/**
	 * Returns a string representation of the object
	 * @return Instance information
	 */
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append(String.format("Class type: %s", this.getClass().toString()));
		output.append(String.format("Coordinates: x=%d  y=%d\n", this.getCurPos().getXPos(), this.getCurPos().getYPos()));
		output.append(String.format("Health: %d", this.getHealth()));

		return output.toString();
	}
}
