package it.unibo.oop.lab04.robot.composable;

public interface RobotComponentWithCommands extends RobotComponent {
	Command[] getSupportedCommands();
	void selectCommand(Command command);
}
