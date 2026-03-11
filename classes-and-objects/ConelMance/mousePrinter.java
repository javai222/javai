public class mousePrinter {
    public static void main(String[] args) {

        // Object using no parameters
        mouse m1 = new mouse();

        // Object using all parameters
        mouse m2 = new mouse("Logitech", "White", "Wired");

        // Object using overloaded constructor
        mouse m3 = new mouse("Pink", "Wireless");

        // Display each mouse information
        m1.displayItems();
        System.out.println();

        m2.displayItems();
        System.out.println();

        m3.displayItems();
        System.out.println();

        // Display total sales
        mouse.displayTotalSales();
    }
}