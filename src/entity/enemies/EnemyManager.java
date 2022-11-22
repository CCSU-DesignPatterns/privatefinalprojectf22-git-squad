package entity.enemies;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class EnemyManager implements IEnemy {

	ArrayList<IEnemy> children = new ArrayList<IEnemy>();
	
	@Override
	public IEnemy getComposite() {
		return this;
	}

	@Override
	public void update() {
		for(IEnemy e : children) {
			e.update();
		}
	}

	@Override
	public void draw(Graphics2D g2) {
		for(IEnemy e : children) {
			e.draw(g2);
		}
	}
	
	public void add(IEnemy e) { children.add(e); }
	
	public void remove(IEnemy e) { children.remove(e); }
	
	public IEnemy getChild(IEnemy target) {
		for(IEnemy e : children) {
			if(e.equals(target))
				return e;
		}
		return null;
	}

	public ArrayList<IEnemy> getChildren() { return children; }

	@Override
	public int getDistanceTravelled() { return 0; }

	@Override
	public int getX() { return 0; }

	@Override
	public int getY() { return 0; }
	
	@Override
	public void takeDamage(int damage) {};
}
