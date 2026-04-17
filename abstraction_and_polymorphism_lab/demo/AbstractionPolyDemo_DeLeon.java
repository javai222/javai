// This demo was created by De Leon, Lord Ulrick A.

package demo;

import abstraction.Receipt;
import interfacePkg.Printable;
import Implementation1.StoreReceipt;
import Implementation1.RestaurantReceipt;

public class AbstractionPolyDemo_DeLeon {

    public static void main(String[] args) {

        Receipt store = new StoreReceipt("Luke", 101);
        Receipt restaurant = new RestaurantReceipt("Ulrick", 202);

        Printable printableStore = new StoreReceipt("Mario", 303);
        Printable printableRestaurant = new RestaurantReceipt("Leo", 404);

       
        // Abstract Class Dynamic Binding
        store.generateReceipt();            
        store.displayReceiptInfo();         
        restaurant.generateReceipt();       
        restaurant.displayReceiptInfo();    

        // Interface Dynamic Binding
        printableStore.printReceipt();
        printableRestaurant.printReceipt();

        // Method Overloading
        StoreReceipt sr = new StoreReceipt("Lloyd", 505);

        sr.generateReceipt();
        sr.generateReceipt("Thank you for shopping!");

        RestaurantReceipt rr = new RestaurantReceipt("Lance", 606);

        rr.generateReceipt();
        rr.generateReceipt("No onions, extra sauce");

        System.out.println("\nReceipt Details (Store): " + store.getReceiptDetails());
        System.out.println("Receipt Details (Restaurant): " + restaurant.getReceiptDetails());

        /*
        1. What abstract class did you create?
        I created the abstract class Lego.java

        2. What interface did you create?
        I created the interface LegoActions.java

        3. What methods did you override?
        The overridden methods are generateReceipt(), getReceiptDetails(), and printReceipt().

        4. What methods did you overload?
        The overloaded methods are generateReceipt() and generateReceipt(String message).

        5. Where does dynamic binding occur in your code?
        Dynamic binding occurs when Receipt and Printable references call methods on StoreReceipt and RestaurantReceipt objects.

        6. Which part shows polymorphism?
        Polymorphism is shown when different implementations execute through Receipt and Printable references.

        7. How does your design achieve low coupling?
        Low coupling is achieved by using abstract class and interface references instead of concrete classes.

        8. How does your design achieve high cohesion?
        High cohesion is achieved because each class focuses on handling receipt-related behavior only.
        */
    }
}
