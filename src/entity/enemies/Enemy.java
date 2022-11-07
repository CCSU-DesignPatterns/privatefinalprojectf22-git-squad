package entity.enemies;

import common.Coordinates;
import entity.Entity;
import java.util.Objects;

public abstract class Enemy extends Entity implements iEnemy {
	// Health level. Default is 10
	private int health = 10;
//	private String color;

	/**
	 * @param health integer value that represents strength of an enemy
	 * @param spritePath graphical representation of an enemy
	 */
	public Enemy(Coordinates coordinates, String spritePath, int health, String color) {
		super(coordinates, spritePath);
		this.health = health;
//		this.color = color;
	}
	
//	/**
//	 * Calculates the damage to the enemy entity
//	 * @param damage Damage to take
//	 * */
//	public void calcDamage(int damage) {
//
//		if(health > damage && damage > 0) {
//			health -= damage;
//			if (health > 0)
//				downGradeToLevel(health);
//			else
//				removeFromChain();
//		}
//		else {
//					damage -= health;
//					Enemy temp = nextEnemy;
//					removeFromChain();
//					if(temp != null && damage > 0)
//						temp.calcDamage(damage);
//
//			}
//
//	}

//	/**
//	 *
//	 * @param healthPoints The amount of health to subtract
//	 */
//	private void downGradeToLevel(int healthPoints) {
//		if(healthPoints > health) {
//			health -= healthPoints;
//		}
//		else {
//			health = 0;
//		}
//	}
	
//	/**
//	 * @return the nextEnemy
//	 */
//	public Enemy getNextEnemy() {
//		return nextEnemy;
//	}
//
//	/**
//	 * @param nextEnemy the nextEnemy to set
//	 */
//	public void setNextEnemy(Enemy nextEnemy) {
//		this.nextEnemy = nextEnemy;
//	}
//
//	/**
//	 * @return the prevEnemy
//	 */
//	public Enemy getPrevEnemy() {
//		return prevEnemy;
//	}
//
//	/**
//	 * @param prevEnemy the prevEnemy to set
//	 */
//	public void setPrevEnemy(Enemy prevEnemy) {
//		this.prevEnemy = prevEnemy;
//	}

	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @param health The health to set
	 */
	public void setHealth(int health) {
		this.health = health;
	}

//	/**
//	 * @return the color
//	 */
//	public String getColor() {
//		return color;
//	}

//	/**
//	 * @param color the color to set
//	 */
//	public void setColor(String color) {
//		this.color = color;
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
		output.append(String.format("Coordinates: x=%d  y=%d\n", this.getCurPos().getXPos(), this.getCurPos().getYPos()));
		output.append(String.format("Health: %d", this.getHealth()));

		return output.toString();
	}
}
