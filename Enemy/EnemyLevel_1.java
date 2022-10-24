package enemy.wave;

public class EnemyLevel_1 extends Enemy {

	/**
	 * @param nextEnemy
	 * @param prevEnemy
	 * @param health, level one enemy has health of 1 in a scale of 1 to total different enemies.
	 * @param color, level one enemies are red.
	 */
	
	
	public EnemyLevel_1(Enemy nextEnemy, Enemy prevEnemy) {
		
		super(nextEnemy, prevEnemy, 1, "red");
		
	}

	@Override
	public void calcDamage(int damage) {
		// TODO Auto-generated method stub
		super.calcDamage(damage);
	}
	
}
