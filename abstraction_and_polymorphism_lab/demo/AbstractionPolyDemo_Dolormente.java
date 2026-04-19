/*
* Demo created by Dolormente, Henry II S. | Abstraction and interface class created by De Leon and Silva.
*/

package demo;

import abstraction.Lego;
import abstraction.Rizz;
import interfacePkg.LegoActions;
import interfacePkg.Mogger;
import Implementation1.CityLegoSet;
import Implementation1.SigmaRizz;

public class AbstractionPolyDemo_Dolormente {
    public static void main(String[] args) {

        // Create objects
        CityLegoSet lego = new CityLegoSet("City Builder", 500, 1999.99);
        SigmaRizz rizz = new SigmaRizz("Henry", 100);

        // Basic description
        System.out.println("=== Basic Lego Description ===");
        lego.buildLegoSet();
        lego.displayLegoSetDetails();

        System.out.println();

        System.out.println("=== Basic Rizz Description ===");
        rizz.showRizz();
        rizz.displayInfo();

        // Overloaded methods
        System.out.println("\n=== Lego ===");
        lego.playWithLego();
        lego.playWithLego("Police Chase");
        lego.playWithLego(3);

        System.out.println("\n=== Rizz ===");
        rizz.showcaseMog();
        rizz.showcaseMog("everyone");
        rizz.showcaseMog(100);

        // Interface methods
        System.out.println("\n=== Playing Lego ===");
        LegoActions action = lego;
        action.playWithLego();
        action.cleanUpLego();

        System.out.println("\n=== Mewing ===");
        Mogger mog = rizz;
        mog.mewing();
        mog.showcaseMog(100);

        // Dynamic binding
        System.out.println("\n=== Display info ===");
        Lego l1 = new CityLegoSet("City Builder", 500, 1999.99);
        Rizz r1 = new SigmaRizz("Henry", 100);

        l1.buildLegoSet();
        r1.showRizz();
    }
}

/*
* What abstract class did you create?
  * I created the Character class.
  
* What interface did you create?
  * I created the Skill class.
  
* What methods did you override?
  * I overrided playWithLego(), cleanUpLego(), buildLegoSet(),
    showRizz(), and showcaseMog(int auraLevel).
  
* What methods did you overload?
  * I overloaded playWithLego() and showcaseMog().

* Where does dynamic binding occur in your code?
  * Dynamic binding happens when the overridden method playWithLego() is called, 
    and Java determines at runtime to execute the implementation defined in the
    CityLegoSet implementation instead of the Lego abstract class.

* Which part shows polymorphism?
  * Shown when the same method name behaves differently 
    depending on the object implementation.
    Ex. lego.buildLegoSet();
        r.showRizz();

* How does your design achieve low coupling?
  * It achieves low coupling because the code depends on
    abstractions (Lego, Rizz, LegoActions, Mogger) instead
    of tightly depending on specific implementations.

* How does your design achieve high cohesion?
  * This design achieves high cohesion because each class 
    has a single focused responsibility
*/
