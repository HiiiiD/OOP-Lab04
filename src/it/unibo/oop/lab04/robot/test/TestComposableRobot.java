package it.unibo.oop.lab04.robot.test;

import it.unibo.oop.lab04.robot.base.BaseRobot;
import it.unibo.oop.lab04.robot.composable.AtomicBattery;
import it.unibo.oop.lab04.robot.composable.BracciaPrensile;
import it.unibo.oop.lab04.robot.composable.ComposableRobot;
import it.unibo.oop.lab04.robot.composable.NavigatoreDiConfine;
import it.unibo.oop.lab04.robot.composable.RobotComponent;
import it.unibo.oop.lab04.robot.composable.RobotComponentWithCommands;

/**
 * Utility class for testing composable robots
 * 
 */
public final class TestComposableRobot {

    private static final int CYCLES = 200;

    private TestComposableRobot() {
    }

    public static void main(final String[] args) {

        /*
         * Write your own test.
         * 
         * You will need a robot with an atomic battery, two arms, and a
         * navigator system. Turn on the battery only when the level is below
         * 50%.
         */

    	final ComposableRobot r0 = new ComposableRobot("Evangelion Unit 01");
        final RobotComponent navi = new NavigatoreDiConfine();
        final RobotComponent battery = new AtomicBattery();
        final RobotComponentWithCommands arm1 = new BracciaPrensile();
        final RobotComponentWithCommands arm2 = new BracciaPrensile();
        /*
         * Component connection
         */
        r0.addComponent(navi);
        r0.addComponent(battery);
        r0.addComponent(arm1);
        r0.addComponent(arm2);
        /*
         * Turn on components
         */
        navi.switchOn();
        arm1.switchOn();
        arm2.switchOn();
        /*
         * Run some cycles
         */
        
        
        for (int i = 0; i < CYCLES; i++) {
            if (r0.getBatteryLevel() < BaseRobot.BATTERY_FULL / 2) {
                battery.switchOn();
            } else {
                battery.switchOff();
            }
            arm1.selectCommand(arm1.getSupportedCommands()[i % arm1.getSupportedCommands().length]);
            arm2.selectCommand(arm2.getSupportedCommands()[i % arm2.getSupportedCommands().length]);
            r0.makeAllComponentsWork();
        }
        /*
         * Detach components
         */
        r0.removeComponent(arm1);
        r0.removeComponent(arm2);
        /*
         * Test if it runs anyway
         */
        r0.makeAllComponentsWork();
        r0.makeAllComponentsWork();
    }
}
