package main;

import entity.Entity;
import levels.Level;
import levels.MapTile;

public class CollisionChecker {
	
	GamePanel gp;
	
	public CollisionChecker() {
		this.gp = GamePanel.getInstance();
	}
	
	public static void check(Entity entity) {
		GamePanel gp = GamePanel.getInstance();
		
		if(entity.getX() >= 0 && entity.getX() <= gp.SCREEN_WIDTH && entity.getY() >= 0 && entity.getY() <= gp.SCREEN_HEIGHT) {
			int entityLeft = entity.getX() + entity.getCollisionBox().x;
			int entityRight = entity.getX() + entity.getCollisionBox().x + entity.getCollisionBox().width;
			int entityTop = entity.getY() + entity.getCollisionBox().y;
			int entityBottom = entity.getY() + entity.getCollisionBox().y + entity.getCollisionBox().height;
			
			int entityLeftCol = entityLeft / gp.TILE_SIZE;
			int entityRightCol = entityRight / gp.TILE_SIZE;
			int entityTopRow = entityTop / gp.TILE_SIZE;
			int entityBottomRow = entityBottom / gp.TILE_SIZE;
			
			Level currentLevel = gp.getState().getLevel();
			int currentMap[][] = currentLevel.getMap();
			MapTile currentTileSet[] = currentLevel.getTileSet();
			
			MapTile tile1 = currentTileSet[currentMap[entityLeftCol][entityTopRow]];
			MapTile tile2 = currentTileSet[currentMap[entityLeftCol][entityBottomRow]];
			MapTile tile3 = currentTileSet[currentMap[entityRightCol][entityTopRow]];
			MapTile tile4 = currentTileSet[currentMap[entityRightCol][entityBottomRow]];
			
			if(tile1.getCollision() || tile2.getCollision() || tile3.getCollision() || tile4.getCollision()) {
				entity.setCollision(true);
			}
			else {
				entity.setCollision(false);
			}
		}
	}
}
