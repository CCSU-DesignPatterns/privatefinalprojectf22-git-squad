package entity.enemies;

import java.awt.Graphics2D;

public class EnemyType2 extends Enemy{
	/**
	 * @param nextEnemy
	 * @param prevEnemy
	 * @param health, level two enemy has health of 2 in a scale of 1 to total different enemies.
	 * @param color, level two enemies are blue.
	 */
	
	
	public EnemyType2() {
		
		super(0, 0, "enemy/assets/blue.png", 2, "blue");
		
	}

	@Override
	public void calcDamage(int damage) {
		// TODO Auto-generated method stub
		super.calcDamage(damage);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		
	}
}
