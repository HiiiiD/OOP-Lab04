package it.unibo.oop.lab04.robot.composable;

public class CommandImpl implements Command {
	
	private boolean isOn;
	private String name;
	
	public CommandImpl() {
		
	}
	
	public CommandImpl(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public boolean isOn() {
		return this.isOn;
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
	public String toString() {
		return this.name;
	}
	
	
}
