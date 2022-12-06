package entity.enemies;

import java.awt.Graphics2D;

import main.GamePanel;

/**
 * Enemy upgrades Decorator base class
 * Implements the IEnemy interface
 * Used to upgrade existing enemies
 * @author Ricardo Almeida
 *
 */
public abstract class UpgradedEnemy implements IEnemy {
	
	protected IEnemy baseEnemy;
	
	/**
	 * Basic constructor
	 * @param <code>enemy</code> Enemy object to wrap
	 */
	public UpgradedEnemy(Enemy enemy) {
		baseEnemy = enemy;
	}
	
	/**
	 * Returns the composite object
	 */
	public EnemyManager getComposite() {
		return null;
	}
	
	/**
	 * Updates the base enemy object
	 */
	public void update() {
		baseEnemy.update();
	}
	
	/**
	 * Draws the base enemy object
	 */
	public void draw(Graphics2D g2) {
		baseEnemy.draw(g2);
	}
	
	/**
	 * Returns the total distance traveled by the base enemy object
	 */
	public int getDistanceTraveled() {
		return baseEnemy.getDistanceTraveled();
	}
	
	/**
	 * Abstract method for implementing damage to enemies
	 */
	public abstract void takeDamage(int damage);
	
	/**
	 * Abstract method to return the overall health of the upgraded enemy 
	 */
	public abstract int getHealth();
	
	/**
	 * Abstract method to return the overall strength of the upgraded enemy 
	 */
	public abstract int getStrength();
	
	/**
	 * Abstract method to set the overall health of the upgraded enemy
	 */
	public abstract void setHealth(int health);
	
	/**
	 * Abstract method to set the overall strength of the upgraded enemy
	 */
	public abstract void setStrength(int strength);
	
	/**
	 * Returns the base enemy object's X coordinate value
	 */
	public int getX() {
		return baseEnemy.getX();
	}
	
	/**
	 * Returns the base enemy object's Y coordinate value
	 */
	public int getY() {
		return baseEnemy.getY();
	}
	
	/**
	 * Default implementation of the clone method.
	 * Returns a clone of the base enemy object.
	 */
	public IEnemy clone() {
		return baseEnemy.clone();
	}
	
	public void destroy() {
		GamePanel.getInstance().getState().getEnemyManager().remove(this);
	}
}