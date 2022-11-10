package entity.towers;

import java.awt.Graphics2D;

public interface ITower {
	public ITower getComposite();
	
	public void update();
	
	public void updateTargets();
	
	public double getFireRate();
	
	public void attack();
	
	public void draw(Graphics2D g2);
}
