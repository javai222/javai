/*
*Created by Silva, Vinz Joseph R.
*This class provides the main class for the Glass class
*/

package demo;
import abstraction.Glass
import interfacePkg.Breakable
import implementation.DrinkingGlass;
import implementation.PhoneGlass;

public class AbstractionDemoSilva {
    public static void main(String[] args) {

        DrinkingGlass drink = new DrinkingGlass ("Drinkware", "Clear");
        PhoneGlass swipe = new PhoneGlass ("Personal Items", "Tinted");

        // DrinkingGlass
        // Runtime polymorphism (Overriding)
        drink.useGlass();
        drink.cleanGlass();
        drink.breakGlass();

        // Compile time Polymorphism (Overloading)
        drink.useGlass("Soda");
        drink.useGlass(100);

        // PhoneGlass
        //Runtime polymorphism
        swipe.useGlass();
        swipe.cleanGlass();
        swipe.breakGlass();

        // Compile time polymorphism
        swipe.breakScreen();
        swipe.breakScreen(500);

        drink.displayGlassInfo();
        swipe.displayGlassInfo();

    }
}


/* What abstract class did you create?
 * // I created the Rizz class
 * 
 * What interface did you create?
 * // I created the Mogger interface
 * 
 * What methods did you override?
 * // I overrode useGlass(), cleanGlass(), and breakGlass() 
 * 
 * What methods did you overload?
 * // I overloaded the useGlass()
 * 
 * Where does dynamic binding occur in your code?
 * // It occurs when I called the overriden methods and creating an object as a reference for DrinkingGlass in the main class 
  Which part shows polymorphism?
 * // Polymorphism is executed when I override diffrent methods (Runtime polymorphism) and overload method (compile time polymorphism)
  How does your design achieve low coupling?
 * // The flexibility provided by polymorphism makes different classes or even methods to not be too muv=ch dependant to each other.
      Also, the uses of default class makes it easy for the user to modify something in the interface without damaging the whole code.
  How does your design achieve high cohesion?
 * // High cohesion is achieved in this by applying the principles of abstraction by making it more efficient and focus on the most
      functional part of the method without showing the long process under it.
 */
