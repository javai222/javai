public class Item {
    
    // Attributes
    String itemName;
    String seller;
    int itemPrice;

    // Static attribute
   static int totalItems = 0;

   // Default constructor
   Item() {
        this.itemName = "Gaming Chair";
        this.seller = "Jophel";
        this.itemPrice = 2500;
        totalItems++;
   }

   // Parameterized constructor
   Item(String itemName, String seller, int itemPrice) {
        this.itemName = itemName;
        this.seller = seller;
        this.itemPrice = itemPrice;
        totalItems++;
   }

    // Overloaded constructor
   Item(String itemName, String seller) {
        this.itemName = itemName;
        this.seller = seller;
        this.itemPrice = 2500; //default price
        totalItems++;
   }
   
   //Behavior without parameters
   void displayItems(){
        System.out.println("Item Name: " +itemName);
        System.out.println("Seller Name: " +seller);
        System.out.println("Item Price: " +itemPrice);
   }

   //Behavior with parameters
   void updatePrice(int newPrice){
        itemPrice = newPrice;
        System.out.println(itemName + "price updated to " +itemPrice);
   }

   //Static method
        static void displayTotalItems(){
            System.out.println("Total Items: " +totalItems);
        }
     }
