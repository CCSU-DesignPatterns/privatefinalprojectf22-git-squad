package entity.enemies;

import java.awt.Graphics2D;

public interface IEnemy {
	public IEnemy getComposite();
	
	public void update();
	
	public void draw(Graphics2D g2);
}
