package entity.enemies;

import entity.*;
import common.*;

/**
 * Concrete implementation for entity factory that creates enemies
 *
 * @author Ricardo Almeida
 */
public class EnemyFactory {

    /**
     * Default constructor
     */
    public EnemyFactory() { }

    /**
     * Creates an entity of type Enemy
     * @param type Integer value representing the type of enemy
     * @return An iEnemy object instance
     */
    public Enemy createEntity(int type, Coordinates location) {
        switch(type) {
        case 1:
        	return new EnemyType1(location);
        case 2:
        	return null;
        case 3:
        	return null;
        default:
        	return new EnemyType1(location);
        }
    	
    }
}