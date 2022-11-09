package entity.towers;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class TowerManager extends Tower {
	
	public TowerManager() {
		super(-100, -100, null);
	}

	ArrayList<Tower> children = new ArrayList<Tower>();
	
	@Override
	public void update() {
		for(Tower t : children) {
			t.update();
		}
	}

	@Override
	public void draw(Graphics2D g2) {
		for(Tower t : children) {
			t.draw(g2);
		}
	}
	
	public void add(Tower t) { children.add(t); }

	public void remove(Tower t) { children.remove(t); }
	
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
