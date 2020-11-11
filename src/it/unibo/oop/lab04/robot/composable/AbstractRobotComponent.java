package it.unibo.oop.lab04.robot.composable;

public abstract class AbstractRobotComponent implements RobotComponent {
	
	private ComposableRobot attachedRobot; 
	private boolean isOn;
	private double consumption;
	private String name;
	
	protected AbstractRobotComponent(String name, double consumption) {
		this.name = name;
		this.consumption = consumption;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public void switchOn() {
		this.isOn = true;
	}
	
	@Override
	public void switchOff() {
		this.isOn = false;
	}
	
	@Override
	public boolean isOn() {
		return this.isOn;
	}

	@Override
	public ComposableRobot getAttachedRobot() {
		return this.attachedRobot;
	}

	@Override
	public void setAttachedRobot(ComposableRobot robot) {
		this.attachedRobot = robot;
		//Switch the component off
		switchOff();
	}

	@Override
	public double getConsumption() {
		return this.consumption;
	}
	
	@Override
	public boolean hasAttachedRobot() {
		return this.attachedRobot != null;
	}
	
	@Override
	public abstract boolean doAction();
	/**
	 * Check if it can execute the {@link #doAction()} method
	 * @return true if it can execute it, false otherwise
	 */
	protected boolean canExecuteAction() {
		return this.isOn() && this.hasAttachedRobot();
	}

	
}
