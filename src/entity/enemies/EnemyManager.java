package entity.enemies;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import levels.Level;

public class EnemyManager implements IEnemy {

	List<IEnemy> children = new ArrayList<IEnemy>();
	private EnemyWaves waves;
	private List<IEnemy> removalQueue = new ArrayList<IEnemy>();
	
	public EnemyManager(Level level) {
		waves = new EnemyWaves(level);
		
	}
	
	@Override
	public IEnemy getComposite() {
		return this;
	}

	@Override
	public void update() {
		waves.update();
		for(IEnemy e : children) {
			e.update();
		}
		
		if(removalQueue.size() > 0) {
			
			System.out.println("Destroying " + removalQueue.size() + " enemies...");
			
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
	
	public void add(IEnemy e) { children.add(e); }
	
	public void remove(IEnemy e) { removalQueue.add(e); }
	
	public IEnemy getChild(IEnemy target) {
		for(IEnemy e : children) {
			if(e.equals(target))
				return e;
		}
		return null;
	}
	
	public EnemyWaves getWaves() { return waves; }

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
}
