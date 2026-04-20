package composition_lab;

import composition_lab.Battery;
import composition_lab.Brain;
import composition_lab.Engine;
public class Robot {

    private Brain brain;      // HAS-A Brain
    private Engine engine;    // HAS-A Engine
    private Battery battery;  // HAS-A Battery

    public Robot(Brain brain , Engine engine, Battery battery) {
        this.brain = brain;
        this.engine = engine;
        this.battery = battery;
    }

    public void startRobot() {
        if (battery.getChargeLevel() > 0) {
            engine.startEngine();
            brain.think();
            battery.drain(10);
            System.out.println("Robot is now active.");
        } else {
            System.out.println("Battery is dead. Please recharge.");
        }
    }

    public void panic() {
        brain.panicMode();
        battery.drain(20);
        System.out.println("Robot is panicking!");
    }

    public void shutdownRobot() {
        engine.stopEngine();
        System.out.println("Robot is shutting down.");
    }

}