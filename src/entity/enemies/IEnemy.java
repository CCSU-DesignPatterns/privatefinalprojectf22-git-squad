package entity.enemies;

import java.awt.Graphics2D;

public interface IEnemy extends Cloneable {
	public IEnemy getComposite();
	
	public void update();
	
	public void draw(Graphics2D g2);
	
	public int getDistanceTraveled();
	
	public void takeDamage(int damage);
	
	public int getX();
	
	public int getY();
	
	public IEnemy clone();
}
