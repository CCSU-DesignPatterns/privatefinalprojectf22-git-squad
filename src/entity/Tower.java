package entity;

/**
 * {@summary Base functionality of towers which defend the path from enemies.}
 * @author Wizen
 *
 */
public abstract class Tower extends Entity{
	protected int damage;
	protected double fireRate;
	protected int range;
	protected int cost;
	protected String type;
	
	/**
	 * {@summary Handles initial position and stats of tower being created.}
	 * @param x Initial x coordinate
	 * @param y Initial y coordinate
	 * @param type Enum for the type of tower. Contains default stats of that type.
	 */
	public Tower(int x, int y, TowerType type) {
		super(x, y, type.getSpriteFilePath());
		this.damage = type.getDamage();
		this.fireRate = type.getFireRate();
		this.range = type.getRange();
		this.cost = type.getCost();
		this.type = type.getType();
	}
	
	
}
