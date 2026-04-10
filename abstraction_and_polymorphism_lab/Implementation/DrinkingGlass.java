/*
*Subclass created by Casapao, Abstraction and Interface Class created by Tismo
*Created with the help of AI
*/

package implementation;

import abstraction.Glass;
import interfacePkg.Breakable;


public class DrinkingGlass extends Glass implements Breakable {

    // Constructor
    public DrinkingGlass(String type, String transparency) {
        super(type, transparency);
    }

    // OVERRIDING abstract methods
    @Override
    public void useGlass() {
        System.out.println("This glass is used for drinking beverages.");
    }

    @Override
    public void cleanGlass() {
        System.out.println("Wash the drinkware glass with mild soap.");
    }

    @Override
    public String getGlassPurpose() {
        return "Drinking";
    }

    // OVERRIDING interface method
    @Override
    public void breakGlass() {
        System.out.println("The drinkware glass shattered into pieces!");
    }

    // METHOD OVERLOADING
    public void fillGlass() {
        System.out.println("Filling the glass with water.");
    }

    public void fillGlass(String drink) {
        System.out.println("Filling the glass with " + drink);
    }
}
