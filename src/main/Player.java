package main;

/**
 * This class holds the player's stats and info during the game.
 * Referenced by UI classes to display accurate information as the game progresses.
 * @author Ryan
 *
 */
public class Player {
	private int health, money;
	private GamePanel gp;
	
	/**
	 * Create a player with the given amount of health and money
	 * @param health
	 * @param money
	 */
	public Player(int health, int money) {
		this.health = health;
		this.money = money;
		this.gp = GamePanel.getInstance();
	}
	
	/**
	 * @return Player's current health
	 */
	public int getHealth() { return health; }
	
	/**
	 * @return Player's current money
	 */
	public int getMoney() { return money; }
	
	/**
	 * Add health to player's current amount
	 * @param amt
	 */
	public void addHealth(int amt) { health += amt; }
	
	/**
	 * Remove health from player's current amount.
	 * End the level if the player dies.
	 * @param amt
	 */
	public void removeHealth(int amt) { 
		health -= amt; 
		if (health <= 0) {
			// switch to game over state
		}
	}
	
	/**
	 * Add money to player's current amount.
	 * @param amt
	 */
	public void addMoney(int amt) { money += amt; }
	
	/**
	 * Remove money from player's current amount, if able.
	 * Throw exception if unable.
	 * @param amt
	 */
	public void removeMoney(int amt) throws InsufficientFundsException { 
		if(money >= amt)
			money -= amt; 
		else
			throw new InsufficientFundsException("Player does not have " + amt + " money!");
	}
}
