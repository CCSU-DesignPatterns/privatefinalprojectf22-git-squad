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
	
	/**
	 * Get the default damage of a tower type
	 * @return damage
	 */
	public int getDamage() { return DAMAGE; }
	
	/**
	 * Get the default fire rate delay of a tower type
	 * @return fire rate
	 */
	public double getFireRate() { return FIRE_RATE; }
	
	/**
	 * Get the default range of a tower type
	 * @return range
	 */
	public int getRange() { return RANGE; }
	
	/**
	 * Get the default cost of a tower type
	 * @return cost
	 */
	public int getCost() { return COST; }
	
	/**
	 * Get the type of a tower in string form
	 * @return type
	 */
	public String getType() { return TYPE; }
	
	/**
	 * Get the default sprite file path of a tower type
	 * @return file path
	 */
	public String getSpriteFilePath() { return DEFAULT_SPRITE_FILE_PATH; }
}
