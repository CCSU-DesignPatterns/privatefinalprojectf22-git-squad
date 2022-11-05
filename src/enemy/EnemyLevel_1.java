package enemy;

import java.awt.Graphics2D;

public class EnemyLevel_1 extends Enemy {

	/**
	 * @param nextEnemy
	 * @param prevEnemy
	 * @param health, level one enemy has health of 1 in a scale of 1 to total different enemies.
	 * @param color, level one enemies are orange.
	 */
	
	
	public EnemyLevel_1() {
		
		super(0, 0, "enemy/assets/orange.png", 1, "orange");
		
	}

	@Override
	public void calcDamage(int damage) {
		// TODO Auto-generated method stub
		super.calcDamage(damage);
	}

	@Override
	protected void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		
	}
	
}
