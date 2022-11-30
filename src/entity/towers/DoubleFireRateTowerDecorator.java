package entity.towers;

/**
 * Decorator to double the fire rate of a tower
 * @author Ryan Sharp
 *
 */
public class DoubleFireRateTowerDecorator extends TowerDecorator {
	
	/**
	 * Create decorator for given tower
	 * @param decoratedTower - tower to be decorated
	 */
	public DoubleFireRateTowerDecorator(Tower decoratedTower) {
		super(decoratedTower);
	}
	
	/**
	 * @return half the fire rate delay of the decorated tower
	 */
	@Override
	public double getFireRate() {
		return 0.5 * decoratedTower.getFireRate();
	}

}
