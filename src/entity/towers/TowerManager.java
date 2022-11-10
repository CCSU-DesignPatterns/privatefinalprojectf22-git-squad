package entity.towers;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * This class acts as a composite, allowing GamePanel to update and draw all the player's towers at once rather
 * than having to loop through each one.
 * 
 * @author Ryan Sharp
 *
 */
public class TowerManager extends Tower {
	
	/**
	 * Constructor is only included here because it is required. 
	 * The TowerManager is not a tangible tower in the game, so it should not be seen or displayed on screen.
	 */
	public TowerManager() {
		super(-100, -100, null);
	}

	ArrayList<Tower> children = new ArrayList<Tower>();
	
	/**
	 * Calls the update function on all towers individually.
	 */
	@Override
	public void update() {
		for(Tower t : children) {
			t.update();
		}
	}
	
	/**
	 * Calls the draw function on all towers individually.
	 */
	@Override
	public void draw(Graphics2D g2) {
		for(Tower t : children) {
			t.draw(g2);
		}
	}
	
	/**
	 * Add a tower to the TowerManager's children.
	 * @param t Tower to be added
	 */
	public void add(Tower t) { children.add(t); }

	/**
	 * Remove a tower from the TowerManager's children.
	 * @param t Tower to be removed
	 */
	public void remove(Tower t) { children.remove(t); }
	
	/**
	 * Find and return a specific child from TowerManager
	 * @param target Tower being searched for
	 * @return Tower if found, otherwise null
	 */
	public Tower getChild(Tower target) {
		for(Tower t : children) {
			if(t.equals(target))
				return t;
		}
		return null;
	}
	
	@Override
	public Tower getComposite() { return this; }

	@Override
	public void updateTargets() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}
}
