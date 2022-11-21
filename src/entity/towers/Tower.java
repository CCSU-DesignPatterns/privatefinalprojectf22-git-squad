package entity.towers;

import entity.Entity;

/**
 * {@summary Base functionality of towers which defend the path from enemies.}
 * @author Ryan Sharp
 *
 */
public abstract class Tower extends Entity implements ITower {
	protected int damage;
	protected double fireRate;
	protected int range;
	protected int cost;
	protected String type;
	protected long lastTime;
	protected long currentTime;
	protected double delta;
	
	//IMPLEMENT TOWER INTERFACE FOR DECORATORS AND THIS TO IMPLEMENT
	
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
		this.lastTime = System.nanoTime();
	}
	
	/**
	 * Used to check if the given tower is a composite or leaf. TowerManager returns itself, all others return null;
	 * @return TowerManager or null
	 */
	public ITower getComposite() { return null; }
	
	/**
	 * Default update routine for towers. Updates list of targets (enemies in range) and attacks if ready.
	 */
	public void update() {
		updateTargets();
		updateDelta();
		if(delta > getFireRate()) {
			attack();
			delta = 0;
		}
	}
	
	public abstract void updateTargets();
	
	/**
	 * Updates delta every frame to ensure proper fireRate.
	 */
	public void updateDelta() {
		currentTime = System.nanoTime();
		delta += (currentTime - lastTime) / fireRate;
	}
	
	/**
	 * Getter method used by decorators in case of modification.
	 * @return Appropriate fire rate based on decorators.
	 */
	public double getFireRate() { return  fireRate; }
	
	public abstract void attack();

}