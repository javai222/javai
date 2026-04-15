/*
* This is created by Plantilla, Abstract and Interface Class created by Cantela
*Created with the help of AI
*/
package Implementation;

import abstraction.PaymentMethod;
import interfacePkg.Discountable;

public class CashPayment extends PaymentMethod implements Discountable {

    // Constructor
    public CashPayment(String accountName, String paymentType) {
        super(accountName, paymentType);
    }

    // Override Methods from Abstract Class named PaymentMethod
    @Override
    public void processPayment(double amount) {
        double finalAmount = applyDiscount(amount);

        System.out.println("\n--- CASH PAYMENT ---");
        System.out.println("Account Name: " + getAccountName());
        System.out.println("Payment Type: " + getPaymentType());
        System.out.println("Original Amount: " + amount);
        System.out.println("Discounted Amount: " + finalAmount);
    }

    @Override
    public void verifyPaymentDetails() {
        System.out.println("No verification required for cash payment.");
    }

    @Override
    public String getAccountIdentifier() {
        return "CASH";
    }

    // Override Method from Interface Class named Discountable
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.95; // 5% discount
    }
    
    //Method Overloading
    public void processPayment(double amount, boolean showDetails) {
        if (showDetails) {
            processPayment(amount);
        } else {
            System.out.println("Cash payment completed.");
        }
    }
}