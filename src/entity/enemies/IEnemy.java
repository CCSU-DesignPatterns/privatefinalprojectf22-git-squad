package entity.enemies;

import java.awt.Graphics2D;

/**
 * Interface for Enemy types
 * @author Ricardo Almeida, Ryan Sharp
 *
 */
public interface IEnemy extends Cloneable {
	/**
	 * Get the EnemyManager composite
	 * @return itself if this is the enemy manager, otherwise null
	 */
	public EnemyManager getComposite();	
	
	/**
	 * update the state of this IEnemy
	 */
	public void update();	
	
	/**
	 * redraw this IEnemy
	 * @param g2
	 */
	public void draw(Graphics2D g2);
	
	/**
	 * Get the distance this IEnemy has travelled
	 * @return
	 */
	public int getDistanceTraveled();	
	
	/**
	 * Take the given amount of damage
	 * @param damage
	 */
	public void takeDamage(int damage);
	
	/**
	 * Get the x component of this enemy's position
	 * @return
	 */
	public int getX();	
	
	/**
	 * get the y component of this enemy's position
	 * @return
	 */
	public int getY();	
	
	/**
	 * get the health of this enemy
	 * @return
	 */
	public int getHealth();
	
	/**
	 * get the strength of this enemy
	 * @return
	 */
	public int getStrength();
	
	/**
	 * set the health of this enemy
	 * @param health
	 */
	public void setHealth(int health);
	
	/**
	 * set the strength of this enemy
	 * @param strength
	 */
	public void setStrength(int strength);
	
	/**
	 * destroy this enemy
	 */
	public void destroy();
	
	/**
	 * clone this enemy
	 * @return cloned enemy
	 */
	public IEnemy clone();
	
	/**
	 * set the original health of the enemy for future reference
	 * @param health
	 */
	public void setOriginalHealth(int health);
	
	/**
	 * get the original health of the enemy for reference
	 * @return original amount of health
	 */
	public int getOriginalHealth();
}
