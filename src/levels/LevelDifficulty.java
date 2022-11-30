package levels;

/**
 * Enum to hold difficulty-based stats
 * @author Ryan Sharp
 *
 */
public enum LevelDifficulty {
	EASY(500, 300, 1.0, 0.9),
	MEDIUM(450, 250, 1.25, 0.8),
	HARD(350, 200, 1.5, 0.75);
	
	private final int STARTING_MONEY, STARTING_HEALTH;
	private final double COST_MULTIPLIER, SALE_MULTIPLIER;
	
	private LevelDifficulty(int money, int health, double cost, double sale) {
		this.STARTING_MONEY = money;
		this.STARTING_HEALTH = health;
		this.COST_MULTIPLIER = cost;
		this.SALE_MULTIPLIER = sale;
	}
	
	/**
	 * Get the amount of money the player should start with on the corresponding difficulty
	 * @return int amount of money
	 */
	public int getStartingMoney() { return STARTING_MONEY; }
	
	/**
	 * Get the amount of health the player should start with on the corresponding difficulty
	 * @return int amount of health
	 */
	public int getStartingHealth() { return STARTING_HEALTH; }
	
	/**
	 * Get the cost multiplier for purchased items on the corresponding difficulty
	 * @return double cost multiplier
	 */
	public double getCostMultiplier() { return COST_MULTIPLIER; }
	
	/**
	 * Get the sale multiplier for selling items on the corresponding difficulty
	 * @return double sale multiplier
	 */
	public double getSaleMultiplier() { return SALE_MULTIPLIER; }
}
