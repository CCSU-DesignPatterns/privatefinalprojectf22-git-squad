package entity.enemies;

/**
 * Holds the attributes for the different types of enemies
 * @author Ricardo Almeida
 *
 */
enum EnemyType {
	EnemyType1(1, 5, "EnemyType1", "/enemies/EnemyRed.png"),
	EnemyType2(2, 10, "EnemyType2", "/enemies/EnemyBlue.png"),
	EnemyType3(4, 15, "EnemyType3", "/enemies/EnemyGreen.png");
	
	private final int STRENGTH;
	private final int HEALTH;
	private final String ENEMY_TYPE;
	private final String SPRITE_PATH;
		
	private EnemyType(int STRENGTH, int HEALTH, String ENEMY_TYPE, String SPRITE_PATH) {
		this.STRENGTH = STRENGTH;
		this.HEALTH = HEALTH;
		this.ENEMY_TYPE = ENEMY_TYPE;
		this.SPRITE_PATH = SPRITE_PATH;
	}
	
	int getStrength() { return STRENGTH; }
	int getHealth() { return HEALTH; }
	String getType() { return ENEMY_TYPE; }
	String getSpritePath() { return SPRITE_PATH; }
}
