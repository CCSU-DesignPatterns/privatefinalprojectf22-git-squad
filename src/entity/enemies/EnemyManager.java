package entity.enemies;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import levels.Level;

/**
 * Composite class for enemies. Keeps track of all living enemies and updates them every frame
 * @author Ricardo Almeida, Ryan Sharp
 *
 */
public class EnemyManager implements IEnemy {

	private List<IEnemy> children = new ArrayList<IEnemy>();
	private EnemyWaves waves;
	private List<IEnemy> removalQueue = new ArrayList<IEnemy>();
	
	/**
	 * Create new enemy manager for the given level and difficulty
	 * @param level - level being played
	 * @param d - difficulty being played
	 */
	public EnemyManager(Level level, Difficulty d) {
		waves = new EnemyWaves(level, d);
	}
	
	@Override
	public EnemyManager getComposite() {
		return this;
	}

	@Override
	public void update() {
		waves.update();
		for(IEnemy e : children) {
			e.update();
		}
		
		if(removalQueue.size() > 0) {
			
			//System.out.println("Destroying " + removalQueue.size() + " enemies...");
			
			for(IEnemy e : removalQueue) {
				children.remove(e);
			}
			
			removalQueue.clear();
		}
	}

	@Override
	public void draw(Graphics2D g2) {
		for(IEnemy e : children) {
			e.draw(g2);
		}
	}
	
	/**
	 * Add an enemy to the composite
	 * @param e - enemy to be added
	 */
	public void add(IEnemy e) { children.add(e); }
	
	/**
	 * remove an enemy from the composite
	 * @param e - enemy to be removed
	 */
	public void remove(IEnemy e) { removalQueue.add(e); }
	
	/**
	 * get an enemy from the composite
	 * @param target - enemy to be retrieved
	 * @return enemy if found, otherwise null
	 */
	public IEnemy getChild(IEnemy target) {
		for(IEnemy e : children) {
			if(e.equals(target))
				return e;
		}
		return null;
	}
	
	/**
	 * Get the enemy waves for the level
	 * @return
	 */
	public EnemyWaves getWaves() { return waves; }
	
	/**
	 * Get the list of enemies in the composite
	 * @return
	 */
	public List<IEnemy> getChildren() { return children; }

	@Override
	public int getDistanceTraveled() { return 0; }

	@Override
	public int getX() { return 0; }

	@Override
	public int getY() { return 0; }
	
	@Override
	public void takeDamage(int damage) {};
	
	public IEnemy clone() {
		// Not yet implemented
		return null;
	}

	@Override
	public int getHealth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getStrength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setHealth(int health) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStrength(int strength) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		removalQueue = children;
	}

	@Override
	public void setOriginalHealth(int health) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getOriginalHealth() {
		// TODO Auto-generated method stub
		return 0;
	}
}
