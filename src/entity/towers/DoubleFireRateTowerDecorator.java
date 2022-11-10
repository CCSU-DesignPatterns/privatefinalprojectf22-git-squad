package entity.towers;

public class DoubleFireRateTowerDecorator extends TowerDecorator {

	public DoubleFireRateTowerDecorator(Tower decoratedTower) {
		super(decoratedTower);
	}
	
	@Override
	public double getFireRate() {
		return 0.5 * decoratedTower.getFireRate();
	}

}
