package entity.enemies;

import java.awt.Rectangle;

import entity.Direction;
import entity.Entity;

/**
 * 
 * @author Pedro Arias, refactored by Ricardo Almeida
 *
 */
public class Enemy extends Entity implements IEnemy {
	// Attributes
	protected int speed = 2;	// Pixels per update. Default is 2
	protected int distTraveled = 0;	// The distance traveled in pixels
	private EnemyType currentType;	// This is currently needed to keep track of the type of enemy it is
	
	/**
	 * Constructor that takes a coordinates object and a String representing
	 * a path to a sprite image for this enemy.
	 * @param health Integer value that represents strength of an enemy
	 * @param spritePath Path to a graphical representation of an enemy
	 */
	public Enemy(int x, int y, EnemyType type) {
		super(x, y, type.getSpritePath());
		this.setHealth(type.getHealth());
		this.setStrength(type.getStrength());
		this.setCollisionBox(new Rectangle(10,10));	// This might have to be updated
		
		// Store the enemy type
		currentType = type;
	}
	
	/**
	 * Updates the enemy's position
	 * @param newPos
	 */
	protected void move() {
		updateDirection();
		
		switch(currentDirection) {
		case UP:
			y -= speed;
			break;
		case DOWN:
			y += speed;
			break;
		case LEFT:
			x -= speed;
			break;
		case RIGHT:
			x += speed;
			break;
		}
		
		// Add to the distance traveled
		addDistance();
	}
	
	private void updateDirection() {
		switch (this.currentDirection) {
		case UP:
			if(y % gp.TILE_SIZE == 0) {
				int row = y / gp.TILE_SIZE;
				int col = x / gp.TILE_SIZE;
				if(row != 0) { // if not on top of screen
					int nextTile = gp.getState().getLevel().getMap()[col][row - 1];
					if(nextTile == 0) { // if tile above is not path
						if(col != 0 && gp.getState().getLevel().getMap()[col - 1][row] == 1) { // if tile left is path
							this.setDirection(Direction.LEFT);
						}
						else if(col != gp.MAX_SCREEN_COL && gp.getState().getLevel().getMap()[col + 1][row] == 1) { // if tile right is path
							this.setDirection(Direction.RIGHT);
						}
					}
				}
			}
			break;
		case DOWN:
			if(y % gp.TILE_SIZE == 0) {
				int row = y / gp.TILE_SIZE;
				int col = x / gp.TILE_SIZE;
				if(row != gp.MAX_SCREEN_ROW) { // if not on bottom of screen
					int nextTile = gp.getState().getLevel().getMap()[col][row + 1];
					if(nextTile == 0) { // if tile below is not path
						if(col != 0 && gp.getState().getLevel().getMap()[col - 1][row] == 1) { // if tile left is path
							this.setDirection(Direction.LEFT);
						}
						else if(col != gp.MAX_SCREEN_COL && gp.getState().getLevel().getMap()[col + 1][row] == 1) { // if tile right is path
							this.setDirection(Direction.RIGHT);
						}
					}
				}
			}
			break;
		case RIGHT:
			if(x % gp.TILE_SIZE == 0) {
				int row = y / gp.TILE_SIZE;
				int col = x / gp.TILE_SIZE;
				if(col != gp.MAX_SCREEN_COL) { // if not on right of screen
					int nextTile = gp.getState().getLevel().getMap()[col + 1][row];
					if(nextTile == 0) { // if tile right is not path
						if(row != 0 && gp.getState().getLevel().getMap()[col][row - 1] == 1) { // if tile up is path
							this.setDirection(Direction.UP);
						}
						else if(row != gp.MAX_SCREEN_ROW && gp.getState().getLevel().getMap()[col][row + 1] == 1) { // if tile bottom is path
							this.setDirection(Direction.DOWN);
						}
					}
				}
			}
			break;
		case LEFT:
			if(x % gp.TILE_SIZE == 0) {
				int row = y / gp.TILE_SIZE;
				int col = x / gp.TILE_SIZE;
				if(col != 0) { // if not on right of screen
					int nextTile = gp.getState().getLevel().getMap()[col - 1][row];
					if(nextTile == 0) { // if tile left is not path
						if(row != 0 && gp.getState().getLevel().getMap()[col][row - 1] == 1) { // if tile up is path
							this.setDirection(Direction.UP);
						}
						else if(row != gp.MAX_SCREEN_ROW && gp.getState().getLevel().getMap()[col][row + 1] == 1) { // if tile bottom is path
							this.setDirection(Direction.DOWN);
						}
					}
				}
			}
			break;				
		}
	}
	
	/**
	 * Adds to the distance traveled by the Enemy entity
	 */
	protected void addDistance() {
		distTraveled += speed;
	}
	
	/**
	 * Returns the current speed of the enemy
	 * @return speed Integer representing the speed of the enemy object
	 */
	public int getSpeed() { return speed; }
	
	/**
	 * Sets the speed of the enemy instance
	 * @param speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
		
	/**
	 * Overrides the default update method 
	 */
	@Override
	public void update() {
		// Move this enemy to the new position
		this.move();
		
		// TODO Other related update operations if needed
	}
	
	/**
	 * Returns a clone of the current Enemy instance
	 */
	public Enemy clone() {
		Enemy clone = new Enemy(x, y, currentType);
		clone.setHealth(this.getHealth());
		clone.setStrength(this.getStrength());
		clone.setCollisionBox(this.getCollisionBox());
		clone.x = this.x;
		clone.y = this.y;
		clone.gp = this.gp;
		clone.collision = this.collision;
		clone.currentDirection = this.currentDirection;
		return clone;
	}
	
	/**
	 * TODO Needs implementation
	 */
	public IEnemy getComposite() {
		return null;
	}

	/**
	 * Returns the distance traveled by the enemy instance
	 */
	public int getDistanceTraveled() {
		return distTraveled;
	}
	
	/**
	 * Superclass override for Interface implementation
	 */
	@Override
	public void setHealth(int health) {
		super.setHealth(health);
	}
	
	/**
	 * Superclass override for Interface implementation
	 */
	@Override
	public void setStrength(int strength) {
		super.setStrength(strength);
	}
	
	/**
	 * @return Hashcode for the current instance of Enemy
	 */
	@Override
	public int hashCode() {
		return super.hashCode() + speed;
	}

	/**
	 *
	 * @param obj The object to compare against
	 * @return boolean True or False
	 */
	@Override
	public boolean equals(Object obj) {
		if(super.equals((Enemy)obj) && speed == ((Enemy)obj).speed)
			return true;
		return false;
	}

	/**
	 * Returns a string representation of the object
	 * @return Instance information
	 */
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append(String.format("%s", super.toString()));		
		output.append(String.format("Speed: %d", speed));

		return output.toString();
	}
}
