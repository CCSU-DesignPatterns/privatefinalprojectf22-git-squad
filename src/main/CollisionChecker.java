package main;

import entity.Entity;

public class CollisionChecker {
	
	GamePanel gp;
	
	public CollisionChecker() {
		this.gp = GamePanel.getInstance();
	}
	
	public void checkTile(Entity entity) {
		int entityLeft = entity.getX() + entity.getCollider().x;
		int entityRight = entity.getX() + entity.getCollider().x + entity.getCollider().width;
		int entityTop = entity.getY() + entity.getCollider().y;
		int entityBottom = entity.getY() + entity.getCollider().y + entity.getCollider().height;
		
		int entityLeftCol = entityLeft / gp.TILE_SIZE;
		int entityRightCol = entityRight / gp.TILE_SIZE;
		int entityTopRow = entityBottom / gp.TILE_SIZE;
		int entityBottomRow = entityBottom / gp.TILE_SIZE;
	}
}
