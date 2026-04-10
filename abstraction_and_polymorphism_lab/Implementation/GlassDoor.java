/*
*Subclass created by Casapao, Abstraction and Interface Class created by Tismo
*Created with the help of AI
*/

package implementation;

import abstraction.Glass;
import interfacePkg.Breakable;


public class GlassDoor extends Glass implements Breakable {

    // Constructor
    public GlassDoor(String glassType, String glassTransparency) {
        super(glassType, glassTransparency);
    }

    // OVERRIDING abstract method from Glass
    @Override
    public void useGlass() {
        System.out.println("This glass is used as a door for entry and visibility.");
    }

    // OVERRIDING abstract method from Glass
    @Override
    public void cleanGlass() {
        System.out.println("Cleaning the glass door using glass cleaner and soft cloth.");
    }

    // OVERRIDING abstract method from Glass
    @Override
    public String getGlassPurpose() {
        return "Access and visibility as a door";
    }

    // IMPLEMENTING interface method from Breakable
    @Override
    public void breakGlass() {
        System.out.println("The glass door is broken. Handle replacement required.");
    }

    // METHOD OVERLOADING (required)
    public void openDoor() {
        System.out.println("The glass door is opened normally.");
    }

    public void openDoor(String direction) {
        System.out.println("The glass door is opened towards " + direction + ".");
    }

    public void openDoor(int forceLevel) {
        if (forceLevel > 5) {
            System.out.println("Opening force is too strong. Risk of damage!");
        } else {
            System.out.println("The glass door is opened carefully with force level " + forceLevel + ".");
        }
    }
}
