package entity.towers;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import entity.enemies.IEnemy;

/**
 * Cannon tower, able to fire explosive rounds with splash damage at a slow rate and short range.
 * @author Ryan Sharp
 *
 */
public class CannonTower extends Tower {
	
	// radius of the cannonball's explosion, in pixels.
	private int explosionRadius = 20;
	
	// accuracy of the cannonball, in pixels. Cannonball will fire within this many pixels of the target.
	private int accuracy = 10;
	
	// random object used to randomize the cannonball's position when fired.
	private Random r = new Random();
	
	/**
	 * Create cannon tower at given x and y pixels
	 * @param x
	 * @param y
	 */
	public CannonTower(int x, int y) {
		super(x, y, TowerType.CANNON);
		this.setCollisionBox(new Rectangle(TowerType.CANNON.getCollisionInfo()[0] * gp.SCALE,
				TowerType.CANNON.getCollisionInfo()[1] * gp.SCALE,
				TowerType.CANNON.getCollisionInfo()[2] * gp.SCALE,
				TowerType.CANNON.getCollisionInfo()[3] * gp.SCALE));
	}

	@Override
	public void attack() {
		if(target != null) {
			int explosionOffsetX = r.nextInt(accuracy*2) - accuracy;
			int explosionOffsetY = r.nextInt(accuracy*2) - accuracy;
			for(IEnemy e : gp.getState().getEnemyManager().getChildren()) {
				if(Math.sqrt((Math.pow((e.getX() - (target.getX() - explosionOffsetX)), 2) 
						+ Math.pow(e.getY() - (target.getY() - explosionOffsetY), 2))) <= explosionRadius) { // for each enemy in radius of the explosion
					e.takeDamage(damage);
				}
			}
			if(target.getHealth() <= 0) {
				gp.getState().getPlayer().addMoney(damage + target.getHealth()); 
				target = null;
			}
			else {
				gp.getState().getPlayer().addMoney(damage);
			}
		}
	}

	@Override
	public void updateTarget() {
		if(target != null && Math.hypot(target.getX() - x, target.getY() - y) > range)
			target = null;
		for(IEnemy e : gp.getState().getEnemyManager().getChildren()) {
			if(Math.hypot(e.getX() - x, e.getY() - y) <= range && // if enemy is within range
					(target ==  null || e.getDistanceTraveled() > target.getDistanceTraveled())) { // and if enemy is at the front of those within range
				target = e;
				setAngle((Math.atan2(x - e.getX(), y - e.getY()) * -1) + Math.PI);
			}
		}
	}
}
