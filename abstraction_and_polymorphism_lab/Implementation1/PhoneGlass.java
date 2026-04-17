/*
* Implementation created by Silva, Abstraction and Interface Class created by Tismo
*Created with the help of AI
*/

package Implementation1;

import abstraction.Glass;
import interfacePkg.Breakable;

public class PhoneGlass extends Glass implements Breakable {
    public PhoneGlass(String glassType, String glassTransparency) {
        super(glassType, glassTransparency);
    }

    // method overriding 
    @Override
    public void useGlass(){
        System.out.println("Swipe the phone in order to navigate");
    }

    @Override
    public void cleanGlass(){
        System.out.println("Clean the screen to maintain neatness.");
    }
    @Override
    public void breakGlass (){
        System.out.println("Your screen is broken. Need to buy a screen protector");
    }

    @Override
    public String getGlassPurpose () {
        return "To use the phone properly";
    }

    // Overloading
    public void breakScreen() {
        System.out.println("Phone screen is broken");
    }

    public void breakScreen (int price){
        System.out.println("Needed " + price + " to replace the broken screen");
    }

}