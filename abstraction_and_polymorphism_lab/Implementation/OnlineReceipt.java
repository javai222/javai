/*This is created by Balanon, Ryan James M.
*Created with the help of AI.
*This class represents an online receipt.
*It extends the abstract Receipt class and implements Printable interface.
*Abstract class and Interface is created by Plantilla, Jophel Mark.
*/
package Implementation;

import abstraction.Receipt;
import interfacePkg.Printable;  


public class OnlineReceipt extends Receipt implements Printable {

    // Encapsulated fields (hidden from other classes for safety)
    private String website;
    private double deliveryFee;

    // Constructor used to initialize online receipt details
    public OnlineReceipt(String customerName, int receiptNumber, String website, double deliveryFee) {
        super(customerName, receiptNumber); // call parent constructor
        this.website = website;
        this.deliveryFee = deliveryFee;
    }

    // Getter methods for accessing private data safely
    public String getWebsite() {
        return website;
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }

    // Setter with validation to ensure valid website input
    public void setWebsite(String website) {
        if (website != null && !website.isEmpty()) {
            this.website = website;
        } else {
            System.out.println("Invalid website name.");
        }
    }

    // Setter with validation to ensure delivery fee is not negative
    public void setDeliveryFee(double deliveryFee) {
        if (deliveryFee >= 0) {
            this.deliveryFee = deliveryFee;
        } else {
            System.out.println("Delivery fee cannot be negative.");
        }
    }

    // METHOD OVERRIDING (ABSTRACT CLASS)
    @Override
    public void generateReceipt() {
        System.out.println("Generating online receipt...");
    }

    @Override
    public String getReceiptDetails() {
        return "Website: " + website + " | Delivery Fee: " + deliveryFee;
    }

    // METHOD OVERRIDING (INTERFACE)
    @Override
    public void printReceipt() {
        System.out.println("Printing online receipt...");
    }

    // Overloaded method: sends receipt via email option
    public void printReceipt(boolean sendEmail) {
        if (sendEmail) {
            System.out.println("Receipt sent via email.");
        } else {
            System.out.println("Receipt not sent via email.");
        }
    }

    // Overloaded method: includes email address and sending status
    public void printReceipt(String email, boolean sendEmail) {
        System.out.println("Email: " + email);
        System.out.println("Send email status: " + sendEmail);
    }
}