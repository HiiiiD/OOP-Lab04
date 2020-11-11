package it.unibo.oop.lab04.robot.composable;

public class AtomicBattery extends AbstractRobotComponent {

	public AtomicBattery() {
		super("Atomic battery", 0);
	}
	
	@Override
	public boolean doAction() {
		if (this.canExecuteAction()) {
			this.getAttachedRobot().recharge();
			return true;
		}
		return false;
	}
}
