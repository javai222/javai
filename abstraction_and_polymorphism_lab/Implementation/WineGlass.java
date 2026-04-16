/*
* Implementation created by Mance, John Roque R.
*Created with the help of AI
*/

package implementation;

import abstraction.Glass;
import interfacePkg.Breakable;

public class WineGlass extends Glass implements Breakable {
    public WineGlass(String glassType, String glassTransparency) {
        super(glassType, glassTransparency);
    }

    // Method overriding
    @Override
    public void useGlass() {
        System.out.println("Glass use to drink wine.");
    }

    @Override
    public void cleanGlass() {
        System.out.println("Wash and clean wine glass after use to remove bacteria");
    }

    @Override
    public void breakGlass() {
        System.out.println("Wine glass is broken. Need a new one.");
    }

    @Override
    public String getGlassPurpose() {
        return "For elegance and proper glass type.";
    }

    // METHOD OVERLOADING (required)
    public void useGlass(String WineType) {
        System.out.println("Use this glass to drink " + WineType);
    }

    public void useGlass (int amount){
        System.out.println("This softdrinks are priced as " + amount);
    }
}