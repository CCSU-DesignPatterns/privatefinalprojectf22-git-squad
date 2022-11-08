package entity.enemies;

import java.awt.Graphics2D;
import common.*;

public class EnemyType1 extends Enemy {
	
	public EnemyType1(Coordinates location) {		
		super(location, "enemy.assets/orange.png");
	}

	@Override
	public void calcDamage(int damage) {
		// TODO Auto-generated method stub
		super.calcDamage(damage);
	}

	@Override
	protected void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attack() {
		
	}

	@Override
	public void takeDamage(int damageAmount) {

	}
}
