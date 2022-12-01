package entity.towers;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

import entity.Entity;
import entity.enemies.IEnemy;

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
	protected TowerType type;
	protected long lastTime;
	protected long currentTime;
	protected double delta;
	protected IEnemy target;
	private double angle;
	
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
		this.type = type;
		this.lastTime = System.nanoTime();
		this.angle = 0;
	}
	
	/**
	 * Used to check if the given tower is a composite or leaf. TowerManager returns itself, all others return null;
	 * @return TowerManager or null
	 */
	public TowerManager getComposite() { return null; }
	
	/**
	 * Get the TowerType enum for what type of tower this is
	 * @return {@link TowerType}
	 */
	public TowerType getType() { return type; }
	
	/**
	 * Default update routine for towers. Updates list of targets (enemies in range) and attacks if ready.
	 */
	public void update() {
		updateTarget();
		updateDelta();
		if(delta > getFireRate() && target != null) {
			attack();
			delta = 0;
		}
	}
	
	/**
	 * Updates which enemy the tower is targeting.
	 */
	public abstract void updateTarget();
	
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
	
	/**
	 * Called periodically to deal damage to the tower's current target.
	 */
	public abstract void attack();
	
	/**
	 * Towers always rotate toward their target
	 */
	@Override
	public void draw(Graphics2D g2) {
		if(target != null)
			angle = Math.toRadians(Math.atan2(target.getX() - x,  target.getY() - y));
		AffineTransform original = g2.getTransform();
		AffineTransform tx = AffineTransform.getRotateInstance(angle, x + (gp.TILE_SIZE / 2), y + (gp.TILE_SIZE / 2));
		g2.setTransform(tx);
		g2.drawImage(sprite, x, y, gp.TILE_SIZE, gp.TILE_SIZE, null);
		g2.setTransform(original);
	}

}