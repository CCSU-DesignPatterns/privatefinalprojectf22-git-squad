package enemy;

import java.awt.Graphics2D;

public class EnemyLevel_3 extends Enemy{
	/**
	 * @param nextEnemy
	 * @param prevEnemy
	 * @param health, level three enemy has health of 3 in a scale of 1 to total different enemies.
	 * @param color, level three enemies are yellow.
	 */
	
	
	public EnemyLevel_3() {
		
		super(0, 0, "enemy/assets/yellow.png", 3, "yellow");
		
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
