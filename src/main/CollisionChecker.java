package main;

import entity.Entity;
import entity.towers.ITower;
import levels.Level;
import levels.MapTile;

/**
 * Used to check the collision status of various entities as they update each frame
 * @author Ryan Sharp, RyiSnow
 *
 */
public class CollisionChecker {
	
	/**
	 * Check whether the given entity has collided with anything
	 * @param entity - entity being checked
	 */
	public static void check(Entity entity) {
		GamePanel gp = GamePanel.getInstance();
		
		if(entity.getX() >= 0 && entity.getX() <= gp.SCREEN_WIDTH - gp.TILE_SIZE && entity.getY() >= 0 && entity.getY() <= gp.SCREEN_HEIGHT - gp.TILE_SIZE) {
			int entityLeft = entity.getCollisionBox().x;
			int entityRight = entity.getCollisionBox().x + entity.getCollisionBox().width;
			int entityTop = entity.getCollisionBox().y;
			int entityBottom = entity.getCollisionBox().y + entity.getCollisionBox().height;
			
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
			
			boolean collision = false;
			
			if(tile1.getCollision() || tile2.getCollision() || tile3.getCollision() || tile4.getCollision()) {
				collision = true;
			}
			
			for(ITower e : gp.getState().getTowerManager().getChildren()) {
				if(entity.getCollisionBox().intersects(e.getCollisionBox())) {
					collision = true;
				}
			}
			
			entity.setCollision(collision);
		}
	}
}
