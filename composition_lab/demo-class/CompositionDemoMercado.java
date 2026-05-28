package composition_lab;
/*
HAS-A Relationships:
Robot HAS-A Brain
Robot HAS-A Engine
Robot HAS-A Battery

Reused Classes:
Brain, Battery

How composition reduces coupling:
The Robot class depends on objects rather than specific implementations.
We can replace the Battery object without modifying the Robot class.

High cohesion:
Each class has a single responsibility:
Brain handles thinking and stress,
Battery handles energy,
Engine handles movement,
Robot coordinates all components.

Why inheritance is not appropriate:
A Robot is not a type of Brain, Engine, or Battery.
They are independent components, so composition is the correct design.
*/
public class CompositionDemoMercado {
    public static void main(String[] args) {

        Brain brain = new Brain (20, 120, 8);
        Battery battery = new Battery(5000, "Duracell");
        Engine engine = new Engine(200, "V8");

        Robot robot = new Robot(brain, engine, battery);

        robot.startRobot();
        robot.panic();
        robot.shutdownRobot();

        Battery newBattery = new Battery(6000, "Energizer");
        robot = new Robot(brain, engine, newBattery);

        robot.startRobot();
    }
}
