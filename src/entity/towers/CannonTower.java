package entity.towers;

import java.awt.Graphics2D;
import java.util.Random;

import entity.enemies.IEnemy;

public class CannonTower extends Tower {
	
	int explosionRadius = 20;
	int accuracy = 10;
	private Random r = new Random();
	
	public CannonTower(int x, int y) {
		super(x, y, TowerType.CANNON);
	}

	@Override
	public void attack() {
		int explosionOffsetX = r.nextInt(accuracy*2) - accuracy;
		int explosionOffsetY = r.nextInt(accuracy*2) - accuracy;
		for(IEnemy e : gp.enemyM.getChildren()) {
			if(Math.sqrt((Math.pow((e.getX() - (target.getX() - explosionOffsetX)), 2) 
					+ Math.pow(e.getY() - (target.getY() - explosionOffsetY), 2))) <= explosionRadius) { // for each enemy in radius of the explosion
				e.takeDamage(damage);
			}
		}
	}

	@Override
	public void updateTarget() {
		for(IEnemy e : gp.enemyM.getChildren()) {
			if(Math.sqrt((Math.pow((e.getX() - x), 2) + Math.pow(e.getY() - y, 2))) <= range && // if enemy is within range
					e.getDistanceTravelled() > target.getDistanceTravelled()) { // and if enemy is at the front of those within range
				target = e;
			}
		}
	}
}
