/*
* This class represents the Bulldogs Markethub class
* Created by Charles Justin Javier
*/


public class Bulldogs_Markethub {
    //Markethub Attributes
    private int activeUsers;
    private int numOfProducts;
    private int totalOrder;

    //Default Constructor
    public Bulldogs_Markethub() {
        this.activeUsers = 0;
        this.numOfProducts = 0;
        this.totalOrder = 0;
    }
     
    //Parameterized Constructor
    public Bulldogs_Markethub(int activeUsers, int numOfProducts, int totalOrder) {
        this.activeUsers = 67;
        this.numOfProducts = 69;
        this.totalOrder = 8;
    }

    //Getters
    public int activeUsers() {
        return activeUsers;
    }

    public int numOfProducts() {
        return activeUsers;
    }

    public int totalOrder() {
        return totalOrder;
    }

    //Setters
    public void setActiveUsers(int activeUsers) {
    if (activeUsers >= 0) {
        this.activeUsers = activeUsers;
    } else {
        System.out.println("Active users cannot be negative!");
    } 
 
    }
    public void setNumofProducts(int numOfProducts) {
        this.numOfProducts = numOfProducts;
    }

    public void setTotalOrder(int totalOrder) {
        this.totalOrder = totalOrder;
    }

    //Behaviors
    public void displayUser() {
        System.out.println("Users online: "+activeUsers);
    }
    public void displayProducts() {
        System.out.println("Available Item: " + numOfProducts);
    }
   
  }

