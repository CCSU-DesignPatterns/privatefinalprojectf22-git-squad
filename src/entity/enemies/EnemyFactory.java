package entity.enemies;

import entity.*;

/**
 * Concrete implementation for entity factory that creates enemies
 *
 * @author Ricardo Almeida
 */
public class EnemyFactory implements iEntityFactory {

    /**
     * Default constructor
     */
    public EnemyFactory() { }

    /**
     * Creates an entity of type Enemy
     * @param type Integer value representing the type of enemy
     * @return An iEnemy object instance
     */
    public iEnemy createEntity(int type) {
        // Not yet implemented
        return null;
    }
}