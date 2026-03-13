package encapsulation.and.access.modifiers.lab;

public class Items {
    
    // Attributes
    private String itemName;
    private String sellerName;
    private double itemPrice;
    private int itemStock;
    private boolean isAvailable;

    // Static Class Behavior
   public static int totalItems = 0;

   // Default Constructor
   public Items() {
        this.itemName = "Unknown Item";
        this.sellerName = "Unknown";
        this.itemPrice = 0.0;
        this.itemStock = 0;
        this.isAvailable =false;
        totalItems++;
   }

   // Parameterized Constructor
   public Items(String itemName, String sellerName, double itemPrice, int itemStock, boolean isAvailable) {
        this.itemName = itemName;
        this.sellerName = sellerName;
        this.itemPrice = itemPrice;
        this.itemStock = itemStock;
        this.isAvailable = isAvailable;
        totalItems++;
   }

    // Overloaded Constructor
   public Items(String itemName, String sellerName) {
        this.itemName = itemName;
        this.sellerName = sellerName;
        this.itemPrice = 2500; //default price
        this.itemStock = 5; //default stock
        this.isAvailable = false; //default availability
        totalItems++;
   }
   
    // Getter methods
    public String getItemName () { return this.itemName; }   

    public String getSellerName () { return this.sellerName;}                                  
        
    public double getItemPrice () { return this.itemPrice; }                                
    
    public int getItemStock () { return this.itemStock; }                              
        
    public boolean isAvailable () { return this.isAvailable;}                                  
        
    
    // Setter methods with validation
    public void setItemName(String itemName) {
        if (itemName != "") {
            this.itemName = itemName;
        }
    }

    public void setSellerName(String sellerName) {
        if (sellerName != "") {
            this.sellerName = sellerName;
        }
    }

    public void setItemPrice(double itemPrice) {
        if (itemPrice >= 0) {
            this.itemPrice = itemPrice;
        }
    }

    public void setItemStock(int itemStock) {
        // Object Invariant : Item stock can only be positive number 
        if (itemStock < 0) {
            System.out.println("The stock of the item cannot be negative!");
            return;
        }
        this.itemStock = itemStock;
    }

    public void setIsAvailable(boolean isAvailable) {
        // Object Invariant : It can only be available if stock exists
        if (this.itemStock > 0) {
            this.isAvailable = true;
        } else {
            this.isAvailable = false;  
        }
    }
    
    //Static method
    public static void displayTotalItems(){
            System.out.println("Total Items: " +totalItems);
        }
}