package it.unibo.oop.lab04.robot.arms;

import it.unibo.oop.lab04.robot.base.Robot;

public interface RobotWithArms extends Robot {
	/**
	 * Pick up an object with one of the arms, if they're free
	 * @return true if an arm picked it up, false otherwise
	 */
	boolean pickUp();
	/**
	 * Drop down an object from one of the arms, if any
	 * @return true if an arm dropped it down, false otherwise
	 */
	boolean dropDown();
	/**
	 * Get the number of items carried
	 * @return the number of carried items
	 */
	int getItemsCarried();
}
