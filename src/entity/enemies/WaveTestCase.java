package entity.enemies;
/**
	 * Test case: test that wave class and its componet work as they are supposed to.
	 * 
	 **/
public class WaveTestCase {

	public static void main(String[] args) {
		EnemyWave wave = new EnemyWave(1);
		
		Enemy enemies = wave.enemies;
		
		while(enemies.getNextEnemy() != null) {
			System.out.println(enemies.toString());
		}

	}

}
