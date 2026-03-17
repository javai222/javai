/*This object created by Balanon for Mance class*/

package encapsulation.and.access.modifiers.lab;

public class Main_BalanonKeyboard {
    public static void main(String[] args) {

        // Object using default constructor
        Keyboard kb1 = new Keyboard();

        // Object using constructor with parameters
        Keyboard kb2 = new Keyboard("AttackShark", "Black", "Mechanical", 15);

        // Object using overloaded constructor
        Keyboard kb3 = new Keyboard("Brown", "Mechanical");

        // Display keyboard information
        kb1.displayItems();
        System.out.println();

        kb2.displayItems();
        System.out.println();

        kb3.displayItems();
        System.out.println();

        // Example behavior
        kb1.sellKeyboard(2);

        // Display total keyboards created
        Keyboard.displayTotalSales();
    }
}