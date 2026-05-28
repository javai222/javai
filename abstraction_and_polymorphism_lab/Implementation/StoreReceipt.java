/*Implementation created by Balanon, Ryan James M.
*Created with the help of AI.
*This class represents a store receipt and extends the abstract Receipt class.
*It also implements Printable to support printing behavior.
*Abstract class and Interface is created by Plantilla, Jophel Mark.
*/

package Implementation;

import abstraction.Receipt;
import interfacePkg.Printable;

public class StoreReceipt extends Receipt implements Printable {

    // Encapsulated fields 
    private String itemName;
    private double price;

    // Constructor used to initialize store receipt details
    public StoreReceipt(String customerName, int receiptNumber, String itemName, double price) {
        super(customerName, receiptNumber); // call parent constructor
        this.itemName = itemName;
        this.price = price;
    }

    // Getter methods to access private variables safely
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    // Setter with validation to prevent invalid item names
    public void setItemName(String itemName) {
        if (itemName != null && !itemName.isEmpty()) {
            this.itemName = itemName;
        } else {
            System.out.println("Invalid item name.");
        }
    }

    // Setter with validation to ensure price is valid
    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Price must be greater than 0.");
        }
    }

    // METHOD OVERRIDING (ABSTRACT CLASS)
    @Override
    public void generateReceipt() {
        System.out.println("Generating store receipt...");
    }
    @Override
    public String getReceiptDetails() {
        return "Item: " + itemName + " | Price: " + price;
    }
    // METHOD OVERRIDING (INTERFACE)
    @Override
    public void printReceipt() {
        System.out.println("Printing store receipt...");
    }
   
    // Overloaded method: adds cashier information
    public void printReceipt(String cashierName) {
        System.out.println("Receipt printed by: " + cashierName);
    }

    // Overloaded method: includes duplicate copy option
    public void printReceipt(String cashierName, boolean duplicateCopy) {
        System.out.println("Cashier: " + cashierName);
        System.out.println("Duplicate copy printed: " + duplicateCopy);
    }
}