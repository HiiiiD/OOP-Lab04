package it.unibo.oop.lab04.robot.composable;

import it.unibo.oop.lab04.robot.base.BaseRobot;

public class NavigatoreDiConfine extends AbstractRobotComponent {

	private static final int NORTH = 0;
    private static final int EAST = 1;
    private static final int SOUTH = 2;
    private static final int WEST = 3;
    private static final int[] DIRECTIONS = new int[] { NORTH, EAST, SOUTH, WEST };
	
    
    private int currentDirection;
	
    public NavigatoreDiConfine() {
    	super("Navigatore di confine", BaseRobot.MOVEMENT_DELTA_CONSUMPTION);
    }
    
    /**
     * Tries to move
     * @return true if it can move, false otherwise
     */
    private boolean tryMove() {
    	switch (this.currentDirection % DIRECTIONS.length) {
	        case NORTH:
	            return this.getAttachedRobot().moveUp();
	        case EAST:
	            return this.getAttachedRobot().moveRight();
	        case SOUTH:
	            return this.getAttachedRobot().moveDown();
	        case WEST:
	            return this.getAttachedRobot().moveLeft();
	        default:
	            System.out.println("It shouldn't reach it, fail...");
	            return false;
        }
    }
    
    @Override
    public boolean doAction() {
    	if (this.canExecuteAction()) {
            while (!tryMove()) {
            	//Get to the next direction
            	currentDirection++;
            	if (currentDirection > DIRECTIONS.length) {
                    currentDirection = 0;
                }
            }
            return true;
        }
        return false;
    }


}
