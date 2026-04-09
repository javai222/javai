/*
* Created by Plantilla, Jophel Mark
* This class provides a template for receipt information
*/

package abstraction;

public abstract class Receipt {

    private String customerName;   // name of the customer
    private int receiptNumber;  // number identifier for the receipt

    // Constructor
    public Receipt(String customerName, int receiptNumber) {
        this.customerName = customerName;
        this.receiptNumber = receiptNumber;
    }

    // Getters
    public String getCustomerName() {
        return customerName;
    }

    public int getReceiptNumber() {
        return receiptNumber;
    }

    // Setters with validation
    public void setCustomerName(String customerName){
        if (customerName != null){
            this.customerName = customerName;
        }else{
            System.out.println("Invalid customer name.");
        }
    }

    public void setReceiptNumber(int receiptNumber) {
        if (receiptNumber > 0){
            this.receiptNumber = receiptNumber;
        }else{
            System.out.println("Invalid receipt number.");
        }
    }

    // Abstract methods that subclasses must implement
    public abstract void generateReceipt();
    public abstract String getReceiptDetails();

    // Concrete method
    public void displayReceiptInfo() {
        System.out.println("\n===== RECEIPT INFORMATION =====");
        System.out.println("Customer: " + customerName);
        System.out.println("Receipt Number: " + receiptNumber);
        System.out.println("Details: " + getReceiptDetails());
    }
}