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

         // Creating objects
        ValorantAccount acc1 = new ValorantAccount();
        ValorantAccount acc2 = new ValorantAccount("John", "JRoque#123", "mypassword", 500, 10, "Gold", true);

        // Using setters (valid values)
        acc1.setUserName("Rahzel");
        acc1.setValorantID("Rahzel#777");
        acc1.setPassWord("secret123");
        acc1.setValorantPoints(300);

        // Demonstrating validation rules (invalid inputs)
        acc1.setUserName("");          // Invalid username
        acc1.setPassWord("123");       // Invalid password (less than 6)
        acc1.setValorantPoints(-50);   // Invalid points

        // Calling behaviors (getters)
        System.out.println("Account 1 Information:");
        System.out.println("Username: " + acc1.getUserName());
        System.out.println("Valorant ID: " + acc1.getValorantID());
        System.out.println("Valorant Points: " + acc1.getValorantPoints());

        System.out.println();

        System.out.println("Account 2 Information:");
        System.out.println("Username: " + acc2.getUserName());
        System.out.println("Valorant ID: " + acc2.getValorantID());
        System.out.println("Valorant Points: " + acc2.getValorantPoints());

        // Using static behavior
        System.out.println();
        System.out.println("Total Valorant Accounts Created: " + ValorantAccount.getAccountCount());
        
    }
}