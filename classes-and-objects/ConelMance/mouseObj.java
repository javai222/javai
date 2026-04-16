// this object is created by Mance and class created by Conel


public class mouseObj {
    public static void main(String[] args) {

        // Object using no-parameter constructor
        mouse m1 = new mouse();
        m1.displayItems();

        System.out.println();

        // Object using constructor with 3 parameters
        mouse m2 = new mouse("Logitech", "White", "Wired");
        m2.displayItems();

        System.out.println();

        // Object using overloaded constructor (2 parameters)
        mouse m3 = new mouse("Red", "Wireless");
        m3.displayItems();

        System.out.println();

        // Display total mouse objects created
        mouse.displayTotalSales();
    }
}