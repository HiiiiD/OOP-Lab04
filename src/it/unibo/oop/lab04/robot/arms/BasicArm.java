package it.unibo.oop.lab04.robot.arms;

public class BasicArm {
	
	private static final double ENERGY_REQUIRED_TO_MOVE = 0.2;
    private static final double ENERGY_REQUIRED_TO_GRAB = 0.1;
	
	private String name;
	private boolean isGrabbing;
	
	public BasicArm(String name) {
		this.name = name;
	}
	
	public boolean isGrabbing() {
		return this.isGrabbing;
	}
	
	public void pickUp() {
		this.isGrabbing = true;
	}
	
	public void dropDown() {
		this.isGrabbing = false;
	}
	
	public double getConsumptionForPickUp() {
		return ENERGY_REQUIRED_TO_MOVE + ENERGY_REQUIRED_TO_GRAB;
	}
	
	public double getConsumptionForDropDown() {
		return ENERGY_REQUIRED_TO_MOVE;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
