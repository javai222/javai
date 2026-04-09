/*
    This composed clasll was created by Dolormente, Henry II, S.
    The component classes were created by Sir(Libag), Tismo(Powers), and Casapao(Skins)
*/

package composition_lab;

public class CompositionDemoDolormente {
    public static void main(String[] args) {

        // Create components
        Libag l = new Libag("leeg", 8, true, "Gray");
        Powers p = new Powers("Physical Enhancement", "Offensive", "Short Range");
        Skins s = new Skins("Human", "Moreno", "Smooth");

        // Composed object
        SuperPower hero = new SuperPower(l, p, s);

        // Usage of behaviors
        hero.activateAll();
        hero.displayAll();

        // Testing low coupling
        Powers newPowers = new Powers("Manipulation", "Defensive", "Long Range");;
        hero.setPowers(newPower);

        System.out.println("\nAfter changing powers: ");
        hero.activateAll();
    }
}

/*
* What are the **HAS-A relationships**?
// The SuperPower class HAS-A Powers, HAS-A Skins, and HAS-A Libag.

* Which classes were reused?
// The classes reused are Powers and Skins (created by teammates) and Libag (provided by the instructor).

* How does composition reduce coupling?
// Composition reduces coupling by allowing Powers, Skins, or Libag to be replaced or modified without changing the SuperPower class.

* How did you implement high cohesion?  
// High cohesion is implemented by ensuring each class focuses on a single responsibility: Powers handles abilities, Skins handles appearance, and Libag handles dirt properties.

* How is cohesion maintained?  
// Cohesion is maintained because each class manages only its own data and behaviors, while SuperPower coordinates them without doing their work.

* Why is inheritance **NOT appropriate** here? 
// Inheritance is not appropriate because SuperPower is not a type of Powers, Skins, or Libag; it simply uses them (HAS-A relationship).
*/
