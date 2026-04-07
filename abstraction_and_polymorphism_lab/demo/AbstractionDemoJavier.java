package demo;
import subclass.RizzChildClass;

public class AbstractionDemoJavier {
    public static void main(String[] args) {

        RizzChildClass rizzler = new RizzChildClass("Charles", 80);

        rizzler.displayInfo();

        System.out.println();

        // Overridden method
        rizzler.showRizz();

        // Interface methods
        rizzler.greet();
        rizzler.compliment("You have great vibes!");

        System.out.println();

        // Overloaded methods
        rizzler.compliment();
        rizzler.compliment("Stay confident!", 2);
    }
}

/* What abstract class did you create?
 * // I created the minecraft.java abstract class
 * 
 * What interface did you create?
 * // I created the Playable interface.
 * 
 * What methods did you override?
 * // I overrode showRizz(), greet(), and compliment(String msg) to provide specific behavior in the child class.
 * 
 * What methods did you overload?
 * // I overloaded the compliment() method by creating multiple versions with different parameters.
 * 
 * Where does dynamic binding occur in your code?
 * // Dynamic binding occurs when calling showRizz() using a parent reference like Rizz r = new SigmaRizz(...).
  Which part shows polymorphism?
 * // Polymorphism is shown in Rizz r = new SigmaRizz(...) where a parent reference refers to a child object.
  How does your design achieve low coupling?
 * //The design achieves low coupling by using an abstract class and interface to reduce dependency between classes.
  How does your design achieve high cohesion?
 * //The design achieves high cohesion by ensuring each class has a clear and focused responsibility.
 */
