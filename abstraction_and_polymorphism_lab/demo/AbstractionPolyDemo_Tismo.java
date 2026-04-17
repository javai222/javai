/*
*Subclass created by Tismo, Abstraction and Interface Class created by Casapao
*/
package demo;

import Implementation1.LeatherBag;
import Implementation1.LeatherJacket;

public class AbstractionPolyDemo_Tismo {
    public static void main(String[] args) {
        // Create object
      LeatherJacket jacket = new LeatherJacket("Full-Grain Leather", "Smooth");
      LeatherBag bag = new LeatherBag("Top-Grain Leather", "Flat Grain");
        
        // Basic describe
      System.out.println("=== Basic Description ===");
      jacket.describe();
      System.out.println();
      bag.describe();

      // Overloaded method
      System.out.println("\n=== Detailed Description ===");
      jacket.describe(" Biker Jacket", true);
      System.out.println();
      bag.describe(" Backpack", true);

      // Overloaded method
      System.out.println("\n=== Simple Description ===");
      jacket.describe(" Biker Jacket", false);
      System.out.println();
      bag.describe(" Backpack", false);

      // Interface methods
      System.out.println("\n=== Wearing Jacket ===");
      jacket.wear();
      System.out.println();
      bag.wear();

      System.out.println("\n=== Usage ===");
      jacket.showUsage();
      System.out.println();
      bag.showUsage();

      System.out.println("\n=== Display Info ===");
      jacket.displayInfo();
      System.out.println();
      bag.displayInfo();
    }
}

/*
 *What abstract class did you create?
    - I created the Glass abstract class

 *What interface did you create?
    - I created the Breakable interface class

 *What methods did you override?
    - I overrided the describe() and wear() methods

 *What methods did you overload?
    - I overloaded the describe() method

 *Where does dynamic binding occur in your code?
    - Dynamic binding occurs when the overridden method describe() is called, and Java determines
      at runtime to execute the implementation defined in the LeatherJacket subclass instead of the 
      Leather abstract class.

 *Which part shows polymorphism?
    - Polymorphism is shown through the method overloading (Compile-Time polymorphism) where in
      there were same method names but different parameters. Polymorphism is also present in the
      method overriding (Runtime polymorphism) where in the abstract method found in the Leather 
      class was overriden. In this code the describe() method was both overloaded and overriden. 

 *How does your design achieve low coupling?
    - It achieves low coupling since the LeatherJacket class depends only on the Leather and 
      Wearable classes, but you can make other subclasses using the same classes and the 
      details/methods can be changed with minimal impact to the other subclasses already made.

 *How does your design achieve high cohesion?
    - It achieves high cohesion because the class has one responsibility and all the methods 
      are related to the leather jacket only.
*/
