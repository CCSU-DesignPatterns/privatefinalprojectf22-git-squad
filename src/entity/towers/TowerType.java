package entity.towers;

/**
 * {@summary Holds default stats for the different types of towers at creation time.}
 * @author Ryan Sharp
 *
 */
public enum TowerType {
	TURRET(1, 0.2, 50, 100, "turret", "/towers/Turret.png"),
	CANNON(10, 2.0, 25, 250, "cannon", "/towers/Cannon.png"),
	SNIPER(5, 1.0, 1000, 200, "sniper", "/towers/Sniper.png"),
	HOME(0, 0, 0, 0, "home", "/towers/Home.png");
	
	private final int DAMAGE;
	private final double FIRE_RATE;
	private final int RANGE;
	private final int COST;
	private final String TYPE; 
	private final String DEFAULT_SPRITE_FILE_PATH;
	
	private TowerType(int DAMAGE, double FIRE_RATE,
			int RANGE, int COST, String TYPE, String DEFAULT_SPRITE_FILE_PATH){
		this.DAMAGE = DAMAGE;
		this.FIRE_RATE = FIRE_RATE;
		this.RANGE = RANGE;
		this.COST = COST;
		this.TYPE = TYPE;
		this.DEFAULT_SPRITE_FILE_PATH = DEFAULT_SPRITE_FILE_PATH;
	}
	
	public int getDamage() { return DAMAGE; }
	public double getFireRate() { return FIRE_RATE; }
	public int getRange() { return RANGE; }
	public int getCost() { return COST; }
	public String getType() { return TYPE; }
	public String getSpriteFilePath() { return DEFAULT_SPRITE_FILE_PATH; }
}
