/*
*Implementation created by Plantilla, Abstract and Interface Class created by Cantela
*Created with the help of AI
*/
package Implementation;

import abstraction.PaymentMethod;
import interfacePkg.Discountable;

public class CardPayment extends PaymentMethod implements Discountable {

    // Additional attribute
    private String cardNumber;

    // Constructor
    public CardPayment(String accountName, String paymentType, String cardNumber) {
        super(accountName, paymentType);
        this.cardNumber = cardNumber;
    }

    // Override Methods from Abstract Class named PaymentMethod
    @Override
    public void processPayment(double amount) {
        double finalAmount = applyDiscount(amount);

        System.out.println("\n--- CARD PAYMENT ---");
        System.out.println("Account Name: " + getAccountName());
        System.out.println("Payment Type: " + getPaymentType());
        System.out.println("Original Amount: " + amount);
        System.out.println("Discounted Amount: " + finalAmount);
    }

    @Override
    public void verifyPaymentDetails() {
        System.out.println("Verifying card details for " + getAccountName());
    }

    @Override
    public String getAccountIdentifier() {
        return cardNumber;
    }

    // Override Method from Interface Class named Discountable
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.90; // 10% discount
    }

    public void processPayment(double amount, boolean showDetails) {
        if (showDetails) {
            processPayment(amount);
        } else {
            System.out.println("Card payment completed.");
        }
    }
}