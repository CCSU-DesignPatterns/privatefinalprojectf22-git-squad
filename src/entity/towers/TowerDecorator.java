package entity.towers;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Base class for tower decorations. Should not be applied directly do a tower, as it will not do anything.
 * @author Ryan Sharp
 *
 */
public class TowerDecorator implements ITower {
	
	// Tower or decorator being decorated. Following this to its root always ends in a tower of some kind.
	protected final ITower decoratedTower;
	
	/**
	 * Create a decorator for the given tower
	 * @param tower - Tower to be decorated
	 */
	public TowerDecorator(ITower tower) {
		decoratedTower = tower;
	}
	
	@Override
	public void update() {
		decoratedTower.update();
	}

	@Override
	public TowerManager getComposite() {
		return decoratedTower.getComposite();
	}

	@Override
	public void updateTarget() {
		decoratedTower.updateTarget();
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

	@Override
	public Rectangle getCollisionBox() {
		return decoratedTower.getCollisionBox();
	}

	@Override
	public void setCollisionBox(Rectangle box) {
		decoratedTower.setCollisionBox(box);
	}

	@Override
	public int getX() {
		return decoratedTower.getX();
	}

	@Override
	public int getY() {
		return decoratedTower.getY();
	}

	@Override
	public TowerType getType() {
		return decoratedTower.getType();
	}

}
