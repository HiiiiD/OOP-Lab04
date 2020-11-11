package it.unibo.oop.lab04.robot.arms;

import it.unibo.oop.lab04.robot.base.BaseRobot;

public class RobotWithTwoArms extends BaseRobot implements RobotWithArms {
	
	public static final double MOVE_OBJECT_CONSUMPTION = 0.1;

	private BasicArm leftArm = new BasicArm("Left");
	private BasicArm rightArm = new BasicArm("Right");
	
	private int itemsCarried;
	
	public RobotWithTwoArms(String robotName) {
		super(robotName);
	}
	
	protected double getBatteryRequirementForMovement() {
        return super.getBatteryRequirementForMovement() + getItemsCarried() * MOVE_OBJECT_CONSUMPTION;
    }

    private void executePickUp(final BasicArm arm) {
        if (this.isBatteryEnough(arm.getConsumptionForPickUp())) {
        	if (!arm.isGrabbing()) {
        		arm.pickUp();
                this.consumeBattery(arm.getConsumptionForPickUp());
        	}
        	else {
        		this.log("The arm is grabbing another item");
        	}
        } else {
            this.log("Can not grab, battery is not enough for the pick up. Battery level = " + this.getBatteryLevel());
        }
    }

    private void executeDropDown(final BasicArm arm) {
        if (this.isBatteryEnough(arm.getConsumptionForDropDown()) && arm.isGrabbing()) {
        	if (arm.isGrabbing()) {
                arm.dropDown();
                this.consumeBattery(arm.getConsumptionForDropDown());
        	}
        	else {
        		this.log("The arm is not grabbing anything");
        	}
        } else {
            this.log("Cannot drop the item, battery is not enough for the pick up. Battery level = " + this.getBatteryLevel());
        }
    }

    public boolean dropDown() {
    	BasicArm armToUse = null;
		if (leftArm.isGrabbing()) {
			armToUse = leftArm;
		}
		else if (rightArm.isGrabbing()) {
			armToUse = rightArm;
		}
		
		if (armToUse != null) {
			executeDropDown(armToUse);
			return true;
		}
		
		return false;
    }

    public boolean pickUp() {
    	BasicArm armToUse = null;
		if (!leftArm.isGrabbing()) {
			armToUse = leftArm;
		}
		else if (!rightArm.isGrabbing()) {
			armToUse = rightArm;
		}
		
		if (armToUse != null) {
			executePickUp(armToUse);
			return true;
		}
		
		return false;
    }
	

	@Override
	public int getItemsCarried() {
		return (leftArm.isGrabbing() ? 1 : 0) + (rightArm.isGrabbing() ? 1 : 0);
	}

}
