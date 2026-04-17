// This subclass was created by De Leon, Lord Ulrick A.

package Implementation1;

import abstraction.Receipt;
import interfacePkg.Printable;

public class RestaurantReceipt extends Receipt implements Printable {

    public RestaurantReceipt(String customerName, int receiptNumber) {
        super(customerName, receiptNumber);
    }

    // Overriding (Abstract Method)
    @Override
    public void generateReceipt() {
        System.out.println("\n[Restaurant Receipt]");
        displayReceiptInfo();
    }

    // Overriding (Abstract Method)
    @Override
    public String getReceiptDetails() {
        return "Restaurant order completed.";
    }

    // Overriding (Interface Method)
    @Override
    public void printReceipt() {
        System.out.println("Printing Restaurant Receipt...");
        generateReceipt();
        confirmPrint();
    }

    // Method Overloading
    public void generateReceipt(String specialRequest) {
        System.out.println("\n[Restaurant Receipt - Special]");
        displayReceiptInfo();
        System.out.println("Special Request: " + specialRequest);
    }
}
