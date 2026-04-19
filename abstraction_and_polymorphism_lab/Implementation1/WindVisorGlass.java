// Implementation created by Mance, John Roque R.

package implementation1;

import abstraction.Glass;
import interfacePkg.Breakable;

public class WindVisorGlass extends Glass implements Breakable {
    public WindVisorGlass(String glassType, String glassTransparency) {
        super(glassType, glassTransparency);
    }

    // method overriding 
    @Override
    public void useGlass(){
        System.out.println("Pull the lever and lift visor to activate.");
    }

    @Override
    public void cleanGlass(){
        System.out.println("Clean the visor for better visibility.");
    }

    @Override
    public void breakGlass (){
        System.out.println("Your visor is broken. Need to buy a new visor");
    }

    @Override
    public String getGlassPurpose () {
        return "To block wind and protect eyes";
    }

    // Overloading
    public void breakScreen() {
        System.out.println("Visor is damaged");
    }

    public void breakScreen (int price){
        System.out.println("Needed " + price + " to replace the broken visor");
    }
}