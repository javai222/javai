
/*
     Parent class created by Cantela, Chris Nelson B.
     and sample subclaass Buyer created by Kenneth R. Saan
 */

import java.util.*;

public class Buyer extends User {
    private ArrayList<String> shoppingCart;
    private double totalBalance;
    private int loyaltyPoints;
    private String preferredPaymentMethod;

    // Constructor
    public Buyer(String userName, String password, String email) {
        super(userName, password, email); // Calls the parent constructor
        this.shoppingCart = new ArrayList<>();
        this.totalBalance = 0.0;
        this.loyaltyPoints = 0;
        this.preferredPaymentMethod = "Not Set";
    }

    // Overriding the displayRole method
    public void displayRole() {
        System.out.println("Role: Buyer");
        System.out.println("Function: Browse products, add to cart, and checkout.");
    }

    // Unique method for Buyer: Adding items
    public void addToCart(String itemName, double price) {
        if (getStatus().equals("Active")) {
            shoppingCart.add(itemName);
            totalBalance += price;
            System.out.println(itemName + " added to cart.");
        } else {
            System.out.println("Please login first to add items to your cart.");
        }
    }

    // Unique method for Buyer: Checkout
    public void checkout() {
        if (shoppingCart.isEmpty()) {
            System.out.println("Cart is empty. Nothing to purchase.");
            return;
        }

        System.out.println("\n--- Checkout Summary ---");
        for (String item : shoppingCart) {
            System.out.println("- " + item);
        }
        System.out.println("Total Amount: Php " + totalBalance);
        
        // Logic for loyalty points: 1 point for every 100 spent
        int earned = (int) (totalBalance / 100);
        loyaltyPoints += earned;
        
        System.out.println("Transaction Successful! Points earned: " + earned);
        shoppingCart.clear();
        totalBalance = 0;
    }

    // Overriding showInfo to include Buyer-specific data
    public void showInfo() {
        System.out.println("\n========= BUYER PROFILE =========");
        System.out.println("User ID   : " + getUserID());
        System.out.println("Username  : " + getUserName());
        System.out.println("Email     : " + getEmail());
        System.out.println("Type      : " + getType());
        System.out.println("Status    : " + getStatus());
        System.out.println("Points    : " + loyaltyPoints);
        System.out.println("Items in Cart: " + shoppingCart.size());
        System.out.println("=================================");
    }

    // Setters for unique fields
    public void setPaymentMethod(String method) {
        this.preferredPaymentMethod = method;
    }
}




