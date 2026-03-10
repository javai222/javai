public class Fruit {
    // Attributes
    String fruitName;
    double fruitPrice;
    int quantity;

    // Static attribute
    static int totalFruits = 0;

    // Default constructor
    Fruit() {
        fruitName = "Unknown";
        fruitPrice = 0.0;
        quantity = 0;
        totalFruits++;
    }

    // Parameterized constructor
    Fruit(String fruitName, double fruitPrice, int quantity) {
        this.fruitName = fruitName;
        this.fruitPrice = fruitPrice;
        this.quantity = quantity;
        totalFruits++;
    }

    // Overloaded constructor
    Fruit(String fruitName, double fruitPrice) {
        this.fruitName = fruitName;
        this.fruitPrice = fruitPrice;
        this.quantity = 5; // default quantity
        totalFruits++;
    }

    // Behavior without parameters
    void displayFruit() {
        System.out.println("Fruit Name: " +fruitName);
        System.out.println("Fruit Price: " +fruitPrice);
        System.out.println("Quantity: " +quantity);
    }

    // Behavior with parameters
    void updatePrice(double newPrice) {
        price = newPrice;
        System.out.println(fruitName +" price has been updated to "+ price);
    }

    // Static method
    static void displayTotalFruits() {
        System.out.println("Total Fruits: " +totalFruits);
    }
}