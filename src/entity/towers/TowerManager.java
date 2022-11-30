package entity.towers;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

/**
 * This class acts as a composite, allowing GamePanel to update and draw all the player's towers at once rather
 * than having to loop through each one.
 * 
 * @author Ryan Sharp
 *
 */
public class TowerManager implements ITower {

	protected List<ITower> children = new ArrayList<ITower>();
	
	/**
	 * Calls the update function on all towers individually.
	 */
	@Override
	public void update() {
		for(ITower t : children) {
			t.update();
		}
	}
	
	/**
	 * Calls the draw function on all towers individually.
	 */
	@Override
	public void draw(Graphics2D g2) {
		for(ITower t : children) {
			t.draw(g2);
		}
	}
	
	/**
	 * Add a tower to the TowerManager's children.
	 * @param t Tower to be added
	 */
	public void add(ITower t) { children.add(t); }

	/**
	 * Remove a tower from the TowerManager's children.
	 * @param t Tower to be removed
	 */
	public void remove(ITower t) { children.remove(t); }
	
	/**
	 * Find and return a specific child from TowerManager
	 * @param target Tower being searched for
	 * @return Tower if found, otherwise null
	 */
	public ITower getChild(ITower target) {
		for(ITower t : children) {
			if(t.equals(target))
				return t;
		}
		return null;
	}
	
	@Override
	public TowerManager getComposite() { return this; }

	@Override
	public void updateTarget() {}

	@Override
	public void attack() {}

	@Override
	public double getFireRate() { return 0; }
}
