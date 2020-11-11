package it.unibo.oop.lab04.robot.composable;

public interface RobotComponent extends Switchable {
	ComposableRobot getAttachedRobot();
	void setAttachedRobot(ComposableRobot robot);
	double getConsumption();
	String getName();
	boolean hasAttachedRobot();
	boolean doAction();
}
