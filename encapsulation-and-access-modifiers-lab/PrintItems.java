public class PrintItems {

    //object created by Torrefranca
    //clas created by Platilla
    public static void main(String[] args) {

        // Create an object
        Items item1 = new Items("Keyboard", "Vincent", 2500.0, 10, true);

        // Print item details using getters
        System.out.println("Item Name: " + item1.getItemName());
        System.out.println("Seller Name: " + item1.getSellerName());
        System.out.println("Item Price: " + item1.getItemPrice());
        System.out.println("Item Stock: " + item1.getItemStock());
        System.out.println("Available: " + item1.isAvailable());

        System.out.println();

        // Modify values using setters
        item1.setItemPrice(2000.0);
        item1.setItemStock(5);

        System.out.println("Updated Price: " + item1.getItemPrice());
        System.out.println("Updated Stock: " + item1.getItemStock());

        System.out.println();

        // Test invalid input
        item1.setItemStock(-3);

        // Static method
        Items.displayTotalItems();
    }
}