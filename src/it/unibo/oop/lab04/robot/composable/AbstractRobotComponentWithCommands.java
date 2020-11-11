package it.unibo.oop.lab04.robot.composable;

import java.util.Arrays;

public abstract class AbstractRobotComponentWithCommands extends AbstractRobotComponent implements RobotComponentWithCommands {
	
	protected Command[] supportedCommands;
	
	protected static final Command NULL_COMMAND = new CommandImpl();
	
	private Command selectedCommand = NULL_COMMAND;
	
	public AbstractRobotComponentWithCommands(String name, double consumption, Command... commands) {
		super(name, consumption);
		this.supportedCommands = Arrays.copyOf(commands, commands.length);
	}
	
	protected final void setSupportedCommands(Command... commands) {
		this.supportedCommands = Arrays.copyOf(commands, commands.length);
	}
	
	@Override
	public Command[] getSupportedCommands() {
		return this.supportedCommands;
	}
	
	@Override
	public boolean doAction() {
		if (canExecuteAction()) {
			return doAction(selectedCommand);
		}
		return false;
	}
	
	@Override
	protected boolean canExecuteAction() {
		return this.hasAttachedRobot() && this.isOn() && !selectedCommand.equals(NULL_COMMAND);
	}
	
	protected abstract boolean doAction(Command command);

	public void selectCommand(Command command) {
		this.selectedCommand = command;
	}

}
