public class Main_Mance {
    public static void main(String[] args) {

        System.out.println("=== Computer Shop Purchase Scenario ===\n");

        // Creating objects (customer buys different mouse products)
        Mouse mouse1 = new Mouse(); // default mouse
        Mouse mouse2 = new Mouse("Logitech", "White", "Wired");
        Mouse mouse3 = new Mouse("Red", "Wireless");

        System.out.println("Customer purchased the following mouse items:\n");

        // Behavior 1: display items
        mouse1.displayItems();
        System.out.println();

        mouse2.displayItems();
        System.out.println();

        mouse3.displayItems();
        System.out.println();

        // Using getters
        System.out.println("Checking product details using getters:");
        System.out.println("Mouse 2 Brand: " + mouse2.getBrand());
        System.out.println("Mouse 2 Color: " + mouse2.getColor());
        System.out.println();

        // Using setters (valid input)
        System.out.println("Customer requested to update Mouse 1 details:\n");

        mouse1.setBrand("SteelSeries");
        mouse1.setColor("Blue");

        mouse1.displayItems();
        System.out.println();

        // Demonstrating validation rules
        System.out.println("Testing validation rules:\n");

        mouse2.setBrand("");   // invalid brand
        mouse2.setColor("");   // invalid color

        System.out.println();

        // Behavior 2: show total sales
        Mouse.displayTotalSales();

        System.out.println("\n=== Transaction Completed ===");
    }
}