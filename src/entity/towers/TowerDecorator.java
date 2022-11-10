package entity.towers;

import java.awt.Graphics2D;

public class TowerDecorator implements ITower {
	
	protected final ITower decoratedTower;
	
	public TowerDecorator(ITower tower) {
		decoratedTower = tower;
	}
	
	@Override
	public void update() {
		decoratedTower.update();
	}

	@Override
	public Tower getComposite() {
		return decoratedTower.getComposite();
	}

	@Override
	public void updateTargets() {
		decoratedTower.updateTargets();
	}
	
	@Override
	public double getFireRate() {
		return decoratedTower.getFireRate();
	}

	@Override
	public void attack() {
		decoratedTower.attack();
	}

	@Override
	public void draw(Graphics2D g2) {
		decoratedTower.draw(g2);
	}

}
