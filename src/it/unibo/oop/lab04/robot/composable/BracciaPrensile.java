package it.unibo.oop.lab04.robot.composable;

public class BracciaPrensile extends AbstractRobotComponentWithCommands {

	protected static final double ENERGY_REQUIRED = 0.2;
	public static final String PICK_COMMAND_STRING = "Pick";
	public static final String DROP_COMMAND_STRING = "Drop";
	
	private final Command pickCommand;
	private final Command dropCommand;
	
	private boolean isGrabbing;
	
	public BracciaPrensile() {
		super("Braccia prensile", ENERGY_REQUIRED);
		this.pickCommand = new CommandImpl("Pick");
		this.dropCommand = new CommandImpl("Drop");
		this.setSupportedCommands(new Command[] { pickCommand, dropCommand });
	}
	
	public Command getCommandByName(String name) {
		if (name.equals(PICK_COMMAND_STRING)) {
			return pickCommand;
		}
		else if (name.equals(DROP_COMMAND_STRING)) {
			return dropCommand;
		}
		
		return null;
	}

	@Override
	protected boolean doAction(Command command) {
		if (command.equals(pickCommand)) {
			if (this.isGrabbing) {
				System.out.println(this + " has already another object");
				return false;
			}
			command.switchOn();
			dropCommand.switchOff();
			this.isGrabbing = true;
			return true;
		}
		
		if (command.equals(dropCommand)) {
			if (!this.isGrabbing) {
				System.out.println(this + " is not grabbing anything");
				return false;
			}
			command.switchOn();
			pickCommand.switchOff();
			this.isGrabbing = false;
			return true;
		}
		
		System.out.println("Invalid command " + command);
		return false;
	}

}
