package entity.enemies;

import java.awt.Rectangle;
import common.*;
import entity.Entity;

/**
 * 
 * @author Pedro Arias, refactored by Ricardo Almeida
 *
 */
public abstract class Enemy extends Entity implements iEnemy {
	/**
	 * Constructor that takes a coordinates object and a String representing
	 * a path to a sprite image for this enemy.
	 * @param health Integer value that represents strength of an enemy
	 * @param spritePath Path to a graphical representation of an enemy
	 */
	public Enemy(Coordinates coordinates, EnemyType type) {
		super(coordinates, type.getSpritePath());
		this.setHealth(type.getHealth());
		this.setStrength(type.getStrength());
		this.setCollisionBox(new Rectangle(10,10));
	}
		
	/**
	 * Attacks a given entity
	 * @param target Entity to be attacked
	 */
	public void attack(Entity target) {
		target.takeDamage(this.getStrength());
	};
	
	/**
	 * Updates this enemy's position
	 * @param newPos Coordinates representing the new position
	 */
	public void update(Coordinates newPos) {
		this.setPos(newPos);
		//this.draw(null);
	}
	
	/**
	 * @return Hashcode for the current instance of Enemy
	 */
	@Override
	public int hashCode() {
		return this.hashCode();
	}

	/**
	 *
	 * @param obj The object to compare against
	 * @return boolean True or False
	 */
	@Override
	public boolean equals(Object obj) {
		if(this.equals(obj))
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
		output.append(String.format("Class type: %s", this.getClass().toString()));
		output.append(String.format("Coordinates: x=%d  y=%d\n", this.getCurPos().getXPos(), this.getCurPos().getYPos()));
		output.append(String.format("Health: %d", this.getHealth()));
		output.append(String.format("Strength: %d", this.getStrength()));

		return output.toString();
	}
}
