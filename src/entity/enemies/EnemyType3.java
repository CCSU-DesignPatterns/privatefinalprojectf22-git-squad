package entity.enemies;

import java.awt.Graphics2D;
import common.*;
import entity.Entity;

public class EnemyType3 extends Enemy{
		
	public EnemyType3(Coordinates location) {
		super(location, "enemy.assets/yellow.png");
		setStrength(35);
		setHealth(90);
	}

	@Override
	protected void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void draw(Graphics2D g2) {
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

	@Override
	public void attack(Entity target) {
		// TODO Auto-generated method stub
		
	}
}
