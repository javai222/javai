// Class created by Mance, John Roque R.

package demo;

import abstraction.Glass;
import interfacePkg.Breakable;
import implementation1.WineGlass;
import implementation1.WindVisorGlass;

public class AbstractionPolyDemo_Mance {
    public static void main(String[] args) {

        WineGlass drink = new WineGlass ("Drinkware", "Clear");
        WindVisorGlass visor = new WindVisorGlass ("Motor parts", "Tinted");

        // WineGlass
        // Runtime polymorphism (Overriding)
        drink.useGlass();
        drink.cleanGlass();
        drink.breakGlass();

        // Compile time Polymorphism (Overloading)
        drink.useGlass("Wine");
        drink.useGlass(100);

        // PhoneGlass
        //Runtime polymorphism
        visor.useGlass();
        visor.cleanGlass();
        visor.breakGlass();

        // Compile time polymorphism
        visor.breakScreen();
        visor.breakScreen(380);

        drink.displayGlassInfo();
        visor.displayGlassInfo();

    }
}


/*
*This class is created by Cantela, Chris Nelson B.

What abstract class did you create?
- Glass abstract class
What interface did you create?
- UpdateOS interface
What methods did you override?
- useGlass(), cleanGlass(), getGlassPurpose,
What methods did you overload?
- useGlass in both WindVisorGlass and WineGlass
Where does dynamic binding occur in your code?
- When creating Glass objects at runtime
Which part shows polymorphism?
- The use of the Glass reference to call overridden methods
How does your design achieve low coupling?
- By using interfaces and abstract classes to define contracts without specifying implementation details
How does your design achieve high cohesion?
- Each class has a single responsibility and related methods grouped together
*/