package enemy;

public class EnemyLevel_3 extends Enemy{
	/**
	 * @param nextEnemy
	 * @param prevEnemy
	 * @param health, level three enemy has health of 3 in a scale of 1 to total different enemies.
	 * @param color, level three enemies are yellow.
	 */
	
	
	public EnemyLevel_3() {
		
		super(3, "enemy/assets/yellow.png");
		
	}

	@Override
	public void calcDamage(int damage) {
		// TODO Auto-generated method stub
		super.calcDamage(damage);
	}
}
