package entity.enemies;

import java.awt.Graphics2D;

/**
 * Interface for Enemy types
 * @author Ricardo Almeida, Ryan Sharp
 *
 */
public interface IEnemy extends Cloneable {
	public IEnemy getComposite();	
	public void update();	
	public void draw(Graphics2D g2);	
	public int getDistanceTraveled();	
	public void takeDamage(int damage);	
	public int getX();	
	public int getY();	
	public int getHealth();
	public int getStrength();
	public void setHealth(int health);
	public void setStrength(int strength);
	public void destroy();
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
