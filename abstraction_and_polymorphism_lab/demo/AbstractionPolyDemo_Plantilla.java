/*
* Created by Plantilla
* This demo class demonstrates the CardPayment and CashPayment classes
* Created with the help of AI
*/

package demo;

import Implementation.CardPayment;
import Implementation.CashPayment;

public class AbstractionPolyDemo_Plantilla {

    public static void main(String[] args) {

        CardPayment card = new CardPayment("Jophel Plantilla", "Card", "12345678910");
        CashPayment cash = new CashPayment("Jophel Plantilla", "Cash");

        // CardPayment
        // Runtime polymorphism (Overriding)
        card.processPayment(1200);
        card.verifyPaymentDetails();

        // Compile time polymorphism (Overloading)
        card.processPayment(1200, true);
        card.processPayment(1200, false);

        // CashPayment
        // Runtime polymorphism (Overriding)
        cash.processPayment(500);
        cash.verifyPaymentDetails();

        // Compile time polymorphism (Overloading)
        cash.processPayment(500, true);
        cash.processPayment(500, false);
    }
}

/*

What abstract class did you create?
- I created the abstract class named Receipt.

What interface did you create?
- I created the interface class named Printable.

What methods did you override?
- I overrode processPayment(), verifyPaymentDetails(), and getAccountIdentifier() in both CardPayment and CashPayment classes.

What methods did you overload?
// I overloaded the processPayment() method with different parameters.

Where does dynamic binding occur in your code?
- It happens when I call the processPayment() using CardPayment or CashPayment objects.

Which part shows polymorphism?
- Polymorphism is shown when the same method is used in different class which is the CardPayment and CashPayment,
also when the method is overloaded with different parameters.

How does your design achieve low coupling?
-  CardPayment and CashPayment only follow the structure of PaymentMethod and Discountable,
so I can change one class without affecting the others.

How does your design achieve high cohesion?
- CardPayment handles card payments and CashPayment handles cash payments only so each class focuses on a single responsibility.
*/