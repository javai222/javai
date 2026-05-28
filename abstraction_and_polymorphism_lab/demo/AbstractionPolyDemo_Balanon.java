/*This is created by Balanon, Ryan James M.
*Created with the help of AI.
*/

package demo;

import Implementation.OnlineReceipt;
import Implementation.StoreReceipt;
import abstraction.Receipt;
import interfacePkg.Printable;

// Demo program showing abstraction, polymorphism, overriding, overloading, and dynamic binding
public class AbstractionPolyDemo_Balanon {

    public static void main(String[] args) {

        // Create receipt objects using abstract class reference (dynamic binding)

        Receipt store = new StoreReceipt("Juan Dela Cruz", 101, "Milk", 50.0);
        Receipt online = new OnlineReceipt("Maria Santos", 102, "Shopee", 99.0);

        store.generateReceipt();
        online.generateReceipt();

        System.out.println(store.getReceiptDetails());
        System.out.println(online.getReceiptDetails());

        // Interface usage (created by teammates)
        Printable p1 = new StoreReceipt("Ana", 201, "Bread", 30.0);
        Printable p2 = new OnlineReceipt("Ben", 202, "Lazada", 120.0);

        p1.printReceipt();
        p2.printReceipt();

        p1.confirmPrint();
        p2.confirmPrint();

        // Overloading demonstration (receipt system)
        StoreReceipt sr = new StoreReceipt("Luis", 301, "Rice", 200.0);
        sr.printReceipt("Cashier John");
        sr.printReceipt("Cashier John", true);

    }
}
/*
===========================================================
CODE-BASED ANALYSIS
===========================================================

1. WHAT ABSTRACT CLASS DID YOU CREATE?
- I created a Laptop abstract class that serves as a blueprint for different laptop types with shared properties.

-----------------------------------------------------------

2. WHAT INTERFACE DID YOU CREATE?
- I created a Connectable interface that defines rules for connecting laptops to a network.

-----------------------------------------------------------

3. WHAT METHODS DID YOU OVERRIDE?
- I overrode methods like performTask(), generateReceipt(), getReceiptDetails(), and printReceipt() to give different behaviors in subclasses.

-----------------------------------------------------------

4. WHAT METHODS DID YOU OVERLOAD?
- I overloaded printReceipt() by creating versions with different parameters like cashier name and boolean options.

-----------------------------------------------------------

5. WHERE DOES DYNAMIC BINDING OCCUR?
- Dynamic binding happens when a parent class reference calls a method that is executed by the child class at runtime.

-----------------------------------------------------------

6. WHICH PART SHOWS POLYMORPHISM?
- Polymorphism is shown when the same method behaves differently depending on the object that is calling it.

-----------------------------------------------------------

7. HOW DOES YOUR DESIGN ACHIEVE LOW COUPLING?
- The system uses abstract classes and interfaces so classes are not tightly connected to each other.

-----------------------------------------------------------

8. HOW DOES YOUR DESIGN ACHIEVE HIGH COHESION?
- Each class has one clear responsibility, making the code organized and easier to maintain.

===========================================================
*/
