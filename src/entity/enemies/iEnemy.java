package entity.enemies;

import entity.*;

/**
 * Interface for enemy entities
 * @author Ricardo Almeida
 */
public interface iEnemy {
	public void attack(Entity target);
	public void update();
}
