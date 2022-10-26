package entity;

enum TowerType {
	TURRET(1, 5.0, 50, 100, "turret", "/towers/test.png"),
	CANNON(10, 0.5, 25, 250, "cannon", "/towers/test.png"),
	SNIPER(5, 1.0, 1000, 200, "sniper", "/towers/test.png");
	
	private final int damage;
	private final double fireRate;
	private final int range;
	private final int cost;
	private final String type; 
	private final String defaultSpriteFilePath;
	
	private TowerType(int damage, double fireRate,
			int range, int cost, String type, String defaultSpriteFilePath){
		this.damage = damage;
		this.fireRate = fireRate;
		this.range = range;
		this.cost = cost;
		this.type = type;
		this.defaultSpriteFilePath = defaultSpriteFilePath;
	}
	
	int getDamage() { return damage; }
	double getFireRate() { return fireRate; }
	int getRange() { return range; }
	int getCost() { return cost; }
	String getType() { return type; }
	String getSprite() { return defaultSpriteFilePath; }
}
