/*
* Implementation created by Casapao, Abstraction and Interface Class created by Tismo
*Created with the help of AI
*/

package implementation;

import abstraction.Glass;
import interfacePkg.Breakable;


public class WindowGlass extends Glass implements Breakable {

    public WindowGlass(String type, String transparency) {
        super(type, transparency);
    }

    // OVERRIDING abstract methods
    @Override
    public void useGlass() {
        System.out.println("This glass is used for windows.");
    }

    @Override
    public void cleanGlass() {
        System.out.println("Cleaning window glass using glass cleaner.");
    }

    @Override
    public String getGlassPurpose() {
        return "Ventilation and Protection";
    }

    // OVERRIDING interface method
    @Override
    public void breakGlass() {
        System.out.println("The window glass cracked!");
    }

    // METHOD OVERLOADING
    public void openWindow() {
        System.out.println("Opening the window.");
    }

    public void openWindow(int width) {
        System.out.println("Opening window by " + width + " cm.");
    }
}
