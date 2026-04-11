/*
* Implementation created by Silva, Abstraction and Interface Class created by Tismo
*Created with the help of AI
*/

package implementation;

import abstraction.Glass;
import interfacePkg.Breakable;

public class DrinkingGlass extends Glass implements Breakable {
    public DrinkingGlass(String glassType, String glassTransparency) {
        super(glassType, glassTransparency);
    }

    // method overriding 
    @Override
    public void useGlass(){
        System.out.println("Drinking water from the glass");
    }

    @Override
    public void cleanGlass(){
        System.out.println("Clean this glass after using it.");
    }
    @Override
    public void breakGlass (){
        System.out.println("Slips in your hands while cleaning it and falls to the ground");
    }

    @Override
    public String getGlassPurpose () {
        return "Drinking";
    }

    // Overloading
    public void useGlass(String softdrinks) {
        System.out.println("Use this glass to drink " + softdrinks);
    }

    public void useGlass (int amount){
        System.out.println("This softdrinks are priced as " + amount);
    }

}