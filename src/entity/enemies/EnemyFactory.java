package entity.enemies;

import common.*;

/**
 * Enemy factory that creates enemy entities
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
        	return new EnemyType2(location);
        case 3:
        	return new EnemyType3(location);
        default:
        	return new EnemyType1(location);
        }    	
    }
}