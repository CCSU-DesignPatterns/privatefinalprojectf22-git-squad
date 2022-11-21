package entity.enemies;

import java.awt.Rectangle;
import entity.Entity;

/**
 * 
 * @author Pedro Arias, refactored by Ricardo Almeida
 *
 */
public abstract class Enemy extends Entity {
	/**
	 * @param health integer value that represents strength of an enemy
	 * @param spritePath graphical representation of an enemy
	 */
	public Enemy(int x, int y, String spritePath) {
		super(x, y, spritePath);
		this.setHealth(50);
		this.setStrength(20);
		this.setCollisionBox(new Rectangle(10,10));
	}
	
//	/**
//	 * Causes the enemy instance to take damage
//	 * @param damageAmount Integer representing amount of damage to the enemy instance
//	 */
//	public void takeDamage(int damageAmount) {
//		setHealth(this.health - damageAmount);
//	}
	
	/**
	 * Attacks a given entity
	 * @param target Entity to be attacked
	 */
	public void attack(Entity target) {
		target.takeDamage(getStrength());
	};
	
//	// Sets the strength of the enemy instance 
//	protected void setStrength(int strength) {
//		if(strength > 0)
//			this.strength = strength;
//	}

//	/**
//	 * Sets the health of the enemy instance
//	 * @param health The amount of health to set
//	 */
//	protected void setHealth(int health) {
//		if(health > 0)
//			this.health = health;
//		else
//			this.health = 0;
//	}

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
		output.append(String.format("Coordinates: x=%d  y=%d\n", x, y));
		output.append(String.format("Health: %d", this.getHealth()));

		return output.toString();
	}
}
