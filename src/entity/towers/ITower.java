package entity.towers;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Interface defining basic functionality that any tower or tower substitute needs to be able to fulfill
 * @author Ryan Sharp
 *
 */
public interface ITower {
	/**
	 * Check whether the given ITower is the composite TowerManager
	 * @return Itself if it is the TowerManager, null otherwise.
	 */
	public TowerManager getComposite();
	
	/**
	 * Get this tower's collision box
	 * @return {@link Rectangle} collision box
	 */
	public Rectangle getCollisionBox();
	
	/**
	 * Sets the collision box for this instance
	 * @param box Rectangle object
	 */
	public void setCollisionBox(Rectangle box);
	
	/**
	 * Returns the ITower's x value
	 * @return <code>int</code> x value 
	 */
	public int getX();
	
	/**
	 * Returns the ITower's y value
	 * @return <code>int</code> y value 
	 */
	public int getY();
	
	/**
	 * Perform any updates needed between frames
	 */
	public void update();
	
	/**
	 * Update the tower's current target if needed
	 */
	public void updateTarget();
	
	/**
	 * Get the tower's fire rate delay
	 * @return fire rate
	 */
	public double getFireRate();
	
	/**
	 * Called periodically to attack the tower's current target.
	 */
	public void attack();
	
	/**
	 * Redraw the tower every frame
	 * @param g2 - {@link Graphics2D} used to draw components
	 */
	public void draw(Graphics2D g2);
}
