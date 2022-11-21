package entity.enemies;

import java.awt.Graphics2D;

public class EnemyType1 extends Enemy {
	/**
	 * Constructor that takes a Coordinates object as an argument
	 * @param location Coordinates representing the location of this enemy instance
	 */
	public EnemyType1(int x, int y) {		
		super(x, y, "enemy.assets/orange.png");
		setStrength(25);
		setHealth(75);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Equals override
	 * @return boolean True or False
	 */
	@Override
	public boolean equals(Object obj) {
		// Not yet implemented
		return false;
	}
	
	/**
	 * toString override
	 * @return String representation of the current instance
	 */
	@Override
	public String toString() {
		// Not yet implemented
		return null;
	}
	
	/**
	 * hashCode override
	 * @return integer representing the hashcode for the current instance
	 */
	@Override
	public int hashCode() {
		// Not yet implemented
		return 0;
	}
}
