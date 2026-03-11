// this object is created by Conel and Class created by Mance
public class KeyboardOBJ {
    public static void main(String[] args) {

        // Object using default constructor
        Keyboard k1 = new Keyboard();
        k1.displayItems();

        System.out.println();

        // Object using constructor with 3 parameters
        Keyboard k2 = new Keyboard("Razer", "Black", "Mechanical");
        k2.displayItems();

        System.out.println();

        // Object using overloaded constructor with 2 parameters
        Keyboard k3 = new Keyboard("Pink", "Membrane");
        k3.displayItems();

        System.out.println();

        // Display total keyboard sales
        Keyboard.displayTotalSales();
    }
}