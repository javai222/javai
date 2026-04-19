/*
* Implementation created by Dolormente, Henry II S. | Abstraction and Interface Class created by De Leon, Lord Ulrick A.
*/

package Implementation1;

import abstraction.Lego;
import interfacePkg.LegoActions;

public class CityLegoSet extends Lego implements LegoActions {

    public CityLegoSet(String legoSetName, int legoPiecesQuantity, double legoSetPrice) {
        super(legoSetName, legoPiecesQuantity, legoSetPrice);
    }

    // Method overriding
    @Override
    public void buildLegoSet() {
        System.out.println("Building a detailed city lego set.");
    }

    @Override
    public void playWithLego() {
        System.out.println("Playing with the city lego set.");
    }

    // Overloading
    public void playWithLego(String scenario) {
        System.out.println("Playing lego with scenario: " + scenario);
    }

    public void playWithLego(int hours) {
        System.out.println("Played with lego for " + hours + " hours.");
    }
}
