package entity;

public abstract class Tower extends Entity{
	protected int damage;
	protected double fireRate;
	protected int range;
	protected int cost;
	protected String type;
	
	public Tower(int x, int y, TowerType type) {
		super(x, y, type.getSprite());
		this.damage = type.getDamage();
		this.fireRate = type.getFireRate();
		this.range = type.getRange();
		this.cost = type.getCost();
		this.type = type.getType();
	}
	
	
}
