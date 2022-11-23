package entity.enemies;

import java.awt.Graphics2D;

/**
 * Enemy upgrades Decorator base class
 * Implements the IEnemy interface
 * Used to upgrade existing enemies
 * @author Ricardo Almeida
 *
 */
public abstract class UpgradedEnemy implements IEnemy {
	
	protected final Enemy baseEnemy;
	
	/**
	 * Basic constructor
	 * @param <code>enemy</code> Enemy entity to wrap
	 */
	public UpgradedEnemy(Enemy enemy) {
		baseEnemy = enemy;
	}
	
	/**
	 * Returns the composite
	 */
	public IEnemy getComposite() {
		// Not yet implemented
		return null;
	}
	
	/**
	 * Update method implementation...
	 */
	public void update() {
		baseEnemy.update();
	}
	
	public void draw(Graphics2D g2) {
		baseEnemy.draw(g2);
	}
	
	public int getDistanceTraveled() {
		return baseEnemy.getDistanceTraveled();
	}
	
	public void takeDamage(int damage) {
		baseEnemy.takeDamage(damage);
	}
	
	public abstract int getHealth();
	public abstract int getStrength();
	
	public void setHealth(int health) {
		baseEnemy.setHealth(health);
	}
	
	public void setStrength(int strength) {
		baseEnemy.setStrength(strength);
	}
	
	public int getX() {
		return baseEnemy.getX();
	}
	
	public int getY() {
		return baseEnemy.getY();
	}
	
	public IEnemy clone() {
		return baseEnemy.clone();
	}
}