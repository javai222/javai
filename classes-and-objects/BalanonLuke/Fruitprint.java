//Object created by Balanon, Class created by De Leon

package BalanonLuke;

public class Fruitprint {

    public static void main(String[] args) {

        // Create object using default constructor
        Fruit f1 = new Fruit();

        // Create object using parameterized constructor
        Fruit f2 = new Fruit("Apple", 25.50, 10);

        // Create object using overloaded constructor
        Fruit f3 = new Fruit("Mango", 35.00);

        // Display attributes using getters
        System.out.println("FIRST FRUIT");
        System.out.println("Name: " + f1.getFruitName());
        System.out.println("Price: " + f1.getFruitPrice());
        System.out.println("Quantity: " + f1.getFruitQuantity());

        System.out.println();

        System.out.println("SECOND FRUIT");
        System.out.println("Name: " + f2.getFruitName());
        System.out.println("Price: " + f2.getFruitPrice());
        System.out.println("Quantity: " + f2.getFruitQuantity());

        System.out.println();

        System.out.println("THIRD FRUIT");
        System.out.println("Name: " + f3.getFruitName());
        System.out.println("Price: " + f3.getFruitPrice());
        System.out.println("Quantity: " + f3.getFruitQuantity());

        System.out.println();

        // Call method without parameters
        f2.displayFruit();

        System.out.println();

        // Call method with parameter
        f3.updatePrice(40.00);

        System.out.println();

        // Demonstrate static method
        Fruit.displayTotalFruits();
    }
}
