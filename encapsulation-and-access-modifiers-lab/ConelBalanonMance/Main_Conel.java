// This object is created by Conel and these classes are created by Balanon and Mance.


package encapsulation.and.access.modifiers.lab;

public class Main_Conel {

    public static void main(String[] args) {

        // Create two car objects with brand, model, price, and stock
        Cars car1 = new Cars("Toyota", "Supra", 4500000, 5);
        Cars car2 = new Cars("Honda", "Civic", 1500000, 10);

        // Create keyboards: one default and one custom
        Keyboard kb1 = new Keyboard();
        Keyboard kb2 = new Keyboard("Logitech", "Black", "Mechanical", 20);

        // Display initial car inventory
        System.out.println("=== CAR INVENTORY ===");
        car1.displayCar();
        System.out.println();
        car2.displayCar();
        System.out.println();

        // Sell 2 units from first car stock and show updated state
        car1.sellCar(2);
        car1.displayCar();
        System.out.println();

        // Display initial keyboard inventory
        System.out.println("=== KEYBOARD INVENTORY ===");
        kb1.displayItems();
        System.out.println();
        kb2.displayItems();
        System.out.println();

        // Sell 5 keyboards and show updated state
        kb2.sellKeyboard(5);
        kb2.displayItems();
        System.out.println();

        // Attempt invalid updates (negative values are blocked by setters)
        System.out.println("=== TEST INVALID INPUT ===");
        kb2.setStock(-5);
        car2.setCarPrice(-10000);

        // Display after invalid update attempts
        car2.displayCar();
        kb2.displayItems();
        System.out.println();

        // Show static counters from classes
        Cars.displayTotalCars();
        Keyboard.displayTotalSales();
    }
}