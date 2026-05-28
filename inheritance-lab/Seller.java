/*
     Parent class created by Cantela, Chris Nelson B.
     and sample subclaass Buyer created by Kenneth R. Saan
 */


import java.util.*;

public class Seller extends User {
    private String storeName;
    private ArrayList<String> inventory;
    private double totalSales;
    private double rating;
    private int itemsSold;

    // Constructor
    public Seller(String userName, String password, String email, String storeName) {
        super(userName, password, email);
        this.storeName = storeName;
        this.inventory = new ArrayList<>();
        this.totalSales = 0.0;
        this.rating = 5.0; // Default starting rating
        this.itemsSold = 0;
    }

    // Overriding the displayRole method
    public void displayRole() {
        System.out.println("Role: Seller / Vendor");
        System.out.println("Function: Manage inventory, track sales, and fulfill orders.");
    }

    // Unique method for Seller: Inventory Management
    public void addProduct(String productName) {
        inventory.add(productName);
        System.out.println("System: " + productName + " is now listed in " + storeName);
    }

    // Unique method for Seller: Sales Processing
    public void processSale(String item, double price) {
        if (inventory.contains(item)) {
            inventory.remove(item);
            totalSales += price;
            itemsSold++;
            System.out.println("Sale Confirmed: " + item + " sold for Php " + price);
        } else {
            System.out.println("Error: Item not found in inventory.");
        }
    }

    // Unique method for Seller: Performance update
    public void updateRating(double newReview) {
        // Simple average logic for demonstration
        this.rating = (this.rating + newReview) / 2;
        System.out.println("New Store Rating: " + String.format("%.1f", this.rating) + " stars.");
    }

    // Overriding showInfo to include Seller-specific data
    public void showInfo() {
        System.out.println("\n========= SELLER DASHBOARD =========");
        System.out.println("Store Name : " + storeName);
        System.out.println("Seller ID  : " + getUserID());
        System.out.println("Username   : " + getUserName());
        System.out.println("Email      : " + getEmail());
        System.out.println("Store Type : " + getType());
        System.out.println("Status     : " + getStatus());
        System.out.println("------------------------------------");
        System.out.println("Total Sales: Php " + totalSales);
        System.out.println("Items Sold : " + itemsSold);
        System.out.println("Rating     : " + String.format("%.1f", rating) + "/5.0");
        System.out.println("Stock Count: " + inventory.size());
        System.out.println("====================================");
    }

    // Getter for Store Name
    public String getStoreName() {
        return storeName;
    }
}