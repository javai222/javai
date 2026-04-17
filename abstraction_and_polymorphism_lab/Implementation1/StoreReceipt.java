// This subclass was created by De Leon, Lord Ulrick A. with the help of AI

package Implementation1;

import abstraction.Receipt;
import interfacePkg.Printable;

public class StoreReceipt extends Receipt implements Printable {

    public StoreReceipt(String customerName, int receiptNumber) {
        super(customerName, receiptNumber);
    }

    // Overriding (Abstract Method)
    @Override
    public void generateReceipt() {
        System.out.println("\n[Store Receipt]");
        displayReceiptInfo();
    }

    // Overriding (Abstract Method)
    @Override
    public String getReceiptDetails() {
        return "Store purchase processed.";
    }

    // Overriding (Interface Method)
    @Override
    public void printReceipt() {
        System.out.println("Printing Store Receipt...");
        generateReceipt();
        confirmPrint();
    }

    // Method Overloading
    public void generateReceipt(String note) {
        System.out.println("\n[Store Receipt with Note]");
        displayReceiptInfo();
        System.out.println("Note: " + note);
    }
}
