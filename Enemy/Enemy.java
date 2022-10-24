package enemy.wave;

import java.util.Objects;

public abstract class Enemy {
	
	private Enemy nextEnemy;
	private Enemy prevEnemy;
	private int health;
	private String color;
	/**
	 * @param nextEnemy
	 * @param prevEnemy
	 * @param health
	 * @param color
	 */
	public Enemy(Enemy nextEnemy, Enemy prevEnemy, int health, String color) {
		this.nextEnemy = nextEnemy;
		this.prevEnemy = prevEnemy;
		this.health = health;
		this.color = color;
	}
	
	/**
	 * @param calculate damage to wave
	 * */
	
	public void calcDamage(int damage) {
		
		if(health > damage && damage > 0) {
			health -= damage;
			if (health > 0)
				downGradeToLevel(health);
			else
				removeFromChain();
		}
		else {
					damage -= health;
					Enemy temp = nextEnemy;
					removeFromChain();
					if(temp != null && damage > 0)
						temp.calcDamage(damage);
					
			}
			
	} 
		
	private void removeFromChain() {}
	private void downGradeToLevel(int health) {}
	
	/**
	 * @return the nextEnemy
	 */
	public Enemy getNextEnemy() {
		return nextEnemy;
	}
	/**
	 * @param nextEnemy the nextEnemy to set
	 */
	public void setNextEnemy(Enemy nextEnemy) {
		this.nextEnemy = nextEnemy;
	}
	/**
	 * @return the prevEnemy
	 */
	public Enemy getPrevEnemy() {
		return prevEnemy;
	}
	/**
	 * @param prevEnemy the prevEnemy to set
	 */
	public void setPrevEnemy(Enemy prevEnemy) {
		this.prevEnemy = prevEnemy;
	}
	/**
	 * @return the health
	 */
	public double getHealth() {
		return health;
	}
	/**
	 * @param health the health to set
	 */
	public void setHealth(int health) {
		this.health = health;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public int hashCode() {
		return Objects.hash(color, health, nextEnemy, prevEnemy);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enemy other = (Enemy) obj;
		return Objects.equals(color, other.color)
				&& Double.doubleToLongBits(health) == Double.doubleToLongBits(other.health)
				&& Objects.equals(nextEnemy, other.nextEnemy) && Objects.equals(prevEnemy, other.prevEnemy);
	}
	@Override
	public String toString() {
		return "Enemy [nextEnemy=" + nextEnemy + ", prevEnemy=" + prevEnemy + ", health=" + health + ", color=" + color
				+ "]";
	}
	
	
	
}
