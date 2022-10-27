package enemy;
/**
	 * Test case: test that wave class and its componet work as they are supposed to.
	 * 
	 **/
public class WaveTestCase {

	public static void main(String[] args) {
		Wave wave = new Wave(1);
		
		Enemy enemies = wave.enemies;
		
		while(enemies.getNextEnemy() != null) {
			System.out.println(enemies.toString());
		}

	}

}
