package entity.towers;

public class TowerDecorator extends Tower {
	
	protected final Tower decoratedTower;
	
	public TowerDecorator(Tower decoratedTower) {
		super(-100, -100, null);
		this.decoratedTower = decoratedTower;
	}

	@Override
	public void update() {
		decoratedTower.update();
	}

	@Override
	public Tower getComposite() {
		return decoratedTower.getComposite();
	}

	@Override
	public void updateTargets() {
		decoratedTower.updateTargets();
	}
	
	@Override
	public double getFireRate() {
		return decoratedTower.getFireRate();
	}

	@Override
	public void attack() {
		decoratedTower.attack();
	}
}
