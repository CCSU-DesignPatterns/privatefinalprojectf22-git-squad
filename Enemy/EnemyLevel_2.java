package enemy.wave;

public class EnemyLevel_2 extends Enemy{
	/**
	 * @param nextEnemy
	 * @param prevEnemy
	 * @param health, level two enemy has health of 2 in a scale of 1 to total different enemies.
	 * @param color, level two enemies are blue.
	 */
	
	
	public EnemyLevel_2(Enemy nextEnemy, Enemy prevEnemy) {
		
		super(nextEnemy, prevEnemy, 2, "blue");
		
	}

	@Override
	public void calcDamage(int damage) {
		// TODO Auto-generated method stub
		super.calcDamage(damage);
	}
}
