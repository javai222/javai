/*
*Subclass created by Casapao, Abstraction and Interface Class created by Tismo
*/

package demo;

import abstraction.Glass;
import subclass.DrinkingGlass;
import subclass.WindowGlass;


public class AbstractionDemoCasapao {

    public static void main(String[] args) {

        /*
         * DYNAMIC BINDING + POLYMORPHISM
         * Using abstract reference
         */
        Glass glass1 = new DrinkingGlass("Drinkware", "Clear");
        Glass glass2 = new WindowGlass("Household", "Tinted");

        // Dynamic binding occurs here
        glass1.displayGlassInfo();
        glass1.useGlass();
        glass1.cleanGlass();

        glass2.displayGlassInfo();
        glass2.useGlass();
        glass2.cleanGlass();

        /*
         * METHOD OVERLOADING demonstration
         */
        DrinkingGlass drink = new DrinkwareGlass("Drinkware", "Clear");
        drink.fillGlass();
        drink.fillGlass("Juice");

        WindowGlass window = new WindowGlass("Household", "Tinted");
        window.openWindow();
        window.openWindow(50);

        /*
         * INTERFACE METHOD
         */
        drink.breakGlass();
        window.breakGlass();
    }
}

/*

1. What abstract class did you create?
the abstract class that I created is from Tismo which is the Glass class.

2. What interface did you create?
The interface that I created is the breakable interface.

3. What methods did you override?
The methods that I override is useGlass(), cleanGlass(), getGlassPurpose() and breakGlass().

4. What methods did you overload?
The methods that i overloaded are fillGlass() and fillGlass(String drink), in DrinkwareGlass openWindow() and openWindow(int width) in WindowGlass

5. Where does dynamic binding occur?
When using Glass glass1 = new DrinkwareGlass(...); Glass glass2 = new WindowGlass(...); The method calls are resolved at runtime.

6. Which part shows polymorphism?
- Using Glass reference for different objects: Glass glass1, glass2

7. How does your design achieve low coupling?
- Classes depend on abstraction (Glass and Breakable), not concrete classes.

8. How does your design achieve high cohesion?
- Each class has a focused responsibility for example drinking glass is for drinking and window glass is for window.
*/
