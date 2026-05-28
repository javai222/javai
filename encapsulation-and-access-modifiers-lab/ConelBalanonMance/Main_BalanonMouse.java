//This object created by Balanon for Conel class

package ConelBalanonMance;



public class Main_BalanonMouse {
    public static void main(String[] args) {

        //Object using default constructor
        Mouse mouse1 = new Mouse();

        //Object using parameterized constructor
        Mouse mouse2 = new Mouse("Asus", "White", "Wired");

        //Object using overloaded constructor
        Mouse mouse3 = new Mouse("Red", "Wired");

        // Display the objects
        mouse1.displayItems();
        System.out.println();

        mouse2.displayItems();
        System.out.println();

        mouse3.displayItems();
        System.out.println();

        // Display total objects created
        Mouse.displayTotalSales();
    }
}
