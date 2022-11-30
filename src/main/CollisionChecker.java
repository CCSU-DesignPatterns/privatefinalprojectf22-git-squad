package main;

import entity.Entity;

public class CollisionChecker {
	
	GamePanel gp;
	
	public CollisionChecker() {
		this.gp = GamePanel.getInstance();
	}
	
	public void checkTile(Entity entity) {
		int entityLeft = entity.getX() + entity.getCollisionBox().x;
		int entityRight = entity.getX() + entity.getCollisionBox().x + entity.getCollisionBox().width;
		int entityTop = entity.getY() + entity.getCollisionBox().y;
		int entityBottom = entity.getY() + entity.getCollisionBox().y + entity.getCollisionBox().height;
		
		int entityLeftCol = entityLeft / gp.TILE_SIZE;
		int entityRightCol = entityRight / gp.TILE_SIZE;
		int entityTopRow = entityTop / gp.TILE_SIZE;
		int entityBottomRow = entityBottom / gp.TILE_SIZE;
		
		int tile1 = gp.getState().getLevel().hashCode();
	}
}
