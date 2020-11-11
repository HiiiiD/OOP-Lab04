package it.unibo.oop.lab04.robot.composable;

import java.util.Arrays;
import java.util.Objects;

import it.unibo.oop.lab04.robot.base.BaseRobot;

public class ComposableRobot extends BaseRobot {
	
	private static final int INITIAL_COMPONENTS_SIZE=4;
	
	private RobotComponent[] components = new RobotComponent[INITIAL_COMPONENTS_SIZE];
	private int componentsRealSize;
	
	public ComposableRobot(String robotName) {
		super(robotName);
	}
	
	public void makeAllComponentsWork() {
		for (int i = 0; i < this.componentsRealSize; i++) {
			RobotComponent component = this.components[i];
			if (component.isOn() && component.getAttachedRobot().equals(this)) {
					double componentConsumption = component.getConsumption();
					if (this.isBatteryEnough(componentConsumption) && component.doAction()) {
						this.consumeBattery(componentConsumption);
					}
				}
		}
	}
	
	public void addComponent(RobotComponent component) {
		Objects.requireNonNull(component);
		if (componentsRealSize == components.length) {
			//Expand by a factor of 2
			components = Arrays.copyOf(components, components.length * 2);
		}
		component.setAttachedRobot(this);
		this.components[this.componentsRealSize++] = component;
	}
	
	public void removeComponent(RobotComponent component) {
		Objects.requireNonNull(component);
		int index = indexOfComponent(component);
		if (index >= 0) {
			this.componentsRealSize--;
			for (int i = index; i < this.componentsRealSize; i++) {
				this.components[i] = this.components[i+1];
			}
			this.components[this.componentsRealSize] = null;
		}
	}
	
	private int indexOfComponent(RobotComponent component) {
		for (int i = 0; i < this.components.length; i++) {
			if (this.components[i].equals(component)) {
				return i;
			}
		}
		return -1;
	}

}
