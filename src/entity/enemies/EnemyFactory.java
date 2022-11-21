package entity.enemies;


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
    public Enemy createEntity(int type, int x, int y) {
        switch(type) {
        case 1:
        	return new EnemyType1(x, y);
        case 2:
        	return new EnemyType2(x, y);
        case 3:
        	return new EnemyType3(x, y);
        default:
        	return new EnemyType1(x, y);
        }    	
    }
}