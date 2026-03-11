// Object created by Dolormente, Class created by Plantilla

public class ItemPrinter {
    public static void main(String[] args) {
        // This is the object instance created from the Badminton class
        // Object using default constructor
        Item i1 = new Item();

        // Object using parameterized constructor
        Item i2 = new Item("Laptop", "Mark", 35000);

        // Object using overloaded constructor
        Item i3 = new Item("Keyboard", "Jophel");

        // Print attributes and trigger behaviors
        i1.displayItems();
        i2.displayItems();
        i3.displayItems();

        // Method with parameter
        i2.updatePrice(30000);

        // Static method
        Item.displayTotalItems();
    }
}

// javac classes-and-objects-lab/Student.java classes-and-objects-lab/ObjectDetailsPrinter.java
// java -cp classes-and-objects-lab ObjectDetailsPrinter
