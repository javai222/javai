/*
*Created by Cantela, Chris Nelson B.
*This class provides a template for different payment types like credit card, PayPal, etc.
*/
package abstraction;

public abstract class PaymentMethod {
    private String accountName;     //Name of the account holder
    private String paymentType;     //Type of payment method (gcash, card, paypal)

    
     //Constructor to initialize the payment method with account name and type
    
    public PaymentMethod (String accountName, String paymentType) {
            this.accountName = accountName;
            this.paymentType = paymentType;
    }

        //Getter for accound name and payment type
    public String getAccountName() {
        return accountName;
    }

    public String getPaymentType() {
        return paymentType;
    }

        //setters with validation to prevent empty values
    public void setAccountName(String accountName) {
        if (accountName != null && !accountName.trim().isEmpty()) {
            this.accountName = accountName;
        } else {
            System.out.println("Invalid account name. Cannot be empty.");
        }
    }

        //setters with validation to prevent empty values
    public void setPaymentType(String paymentType) {
        if (paymentType != null && !paymentType.trim().isEmpty()) {
            this.paymentType = paymentType;
        } else {
            System.out.println("Invalid payment type. Cannot be empty.");
        }
    }

     //Abstract method to process a payment. Subclasses must implement this
    public abstract void processPayment(double amount);

         //Abstract method to verify payment details. Subclasses must implement this
    public abstract void verifyPaymentDetails();

    /**
     *Abstract method to get the account identifier. Subclasses must implement this
     *This can be a number, email, etc., depends on the payment type
     */
    public abstract String getAccountIdentifier(); 


     //Displays payment information including method, account name, amount, and identifier
    public void displayPaymentInfo(double amount) {
        System.out.println( "\nPAYMENT INFORMATION"
                        +   "\nPayment Method: " + paymentType
                        +   "\nAccount Name: " + accountName
                        +   "\nTotal Amount: " + amount
                        +   "\nAccount Identifier: " + getAccountIdentifier());

    }
}