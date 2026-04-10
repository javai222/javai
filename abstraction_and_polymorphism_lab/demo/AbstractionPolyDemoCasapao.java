/*
*Subclass created by Casapao, Abstraction and Interface Class created by Tismo
*/

package demo;

import implementation.GlassDoor;
import implementation.WindowGlass;

public class AbstractionPolyDemo_Casapao {

    public static void main(String[] args) {

        // Dynamic Binding: Glass reference pointing to WindowGlass object
        Glass window = new WindowGlass("Tempered", "Transparent");

        // Dynamic Binding: Glass reference pointing to GlassDoor object
        Glass door = new GlassDoor("Laminated", "Frosted");

        // Interface reference (Breakable)
        Breakable breakableWindow = new WindowGlass("Tempered", "Clear");
        Breakable breakableDoor = new GlassDoor("Laminated", "Tinted");

       
        window.useGlass();       // WindowGlass version runs
        window.cleanGlass();     // WindowGlass version runs

        door.useGlass();         // GlassDoor version runs
        door.cleanGlass();       // GlassDoor version runs

        // Interface dynamic binding
        breakableWindow.breakGlass();
        breakableDoor.breakGlass();


        GlassDoor gd = new GlassDoor("Laminated", "Frosted");

        gd.openDoor();
        gd.openDoor("left side");
        gd.openDoor(3);
        gd.openDoor(8);

        WindowGlass wg = new WindowGlass("Tempered", "Clear");

        wg.openWindow();
        wg.openWindow(25);

        System.out.println("\nGlass Purpose (Door): " + door.getGlassPurpose());
        System.out.println("Glass Purpose (Window): " + window.getGlassPurpose());
    }
}

/**
* What abstract class did you create?
* I created Glass, which is a base class for all glass types.
* 
* What interface did you create?
* I created Breakable, which is used for things that can break.
* 
* What methods did you override?
* I changed the methods useGlass(), cleanGlass(), getGlassPurpose(), and breakGlass() in the child classes.
* 
* What methods did you overload?
* I overloaded openDoor() in GlassDoor and openWindow() in WindowGlass by using different inputs.
* 
* Where does dynamic binding occur in your code?
* It happens when a Glass or Breakable variable runs methods from GlassDoor or WindowGlass during the program.

* Which part shows polymorphism?
* It is shown when one Glass type variable works with different objects like doors and windows but gives different results.
* 
* How does your design achieve low coupling?
* It is low coupling because the classes use abstract classes and interfaces instead of depending directly on each other.
* 
* How does your design achieve high cohesion?
* It is high cohesion because each class only handles its own job, like window actions or door actions.
/**
