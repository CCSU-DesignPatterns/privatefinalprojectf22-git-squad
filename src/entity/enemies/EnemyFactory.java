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
     * Creates base enemy entities of various types
     * @param x <code>int</code> x coordinate
     * @param y <code>int</code> y coordinate
     * @param type <code>EnemyType</code> Type of enemy to create
     * @return IEnemy entity
     */
    public IEnemy createEnemy(int x, int y, EnemyType type) {
        switch(type) {
	        case EnemyType1:
	        	return new Enemy(x, y, EnemyType.EnemyType1);
	        case EnemyType2:
	        	return new Enemy(x, y, EnemyType.EnemyType2);
	        case EnemyType3:
	        	return new Enemy(x, y, EnemyType.EnemyType3);
	        default:
	        	return null;
        }    	
    }
    
    /**
     * Creates a decorated enemy from a base enemy object
     * decoratorType is either 1 (health bonus) or 2 (strength bonus)
     * @param baseEnemy The base enemy to decorate
     * @param decoratorType The type of bonus to give the base enemy. 1 = health bonus, 2 = strength bonus
     * @return
     */
    public IEnemy createDecoratedEnemy(Enemy baseEnemy, int decoratorType) {
    	if(decoratorType == 1)
    		return new UpgradedEnemy30H(baseEnemy);
    	else if(decoratorType == 2) {
    		return new UpgradedEnemy20S(baseEnemy);
    	}
    	else {
    		return null;
    	}
    }
}