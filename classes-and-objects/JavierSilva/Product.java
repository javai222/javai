/*
* This class represents a product with a brand, size, and type.
* Created by Charles Justin Javier
*/

public class Product {

    // Static attribute
    static String shirt;

    // Attributes
    String brand;
    String size;
    String type;

    // Default constructor
    Product() {
        brand = "H&M";
        size = "Medium";
        type = "T-shirt";
    }

    // Parameterized constructor
    Product(String brand, String size, String type) {
        this.brand = brand;
        this.size = size;
        this.type = type;
    }

    // Overloaded constructor
    Product(String brand, String type) {
        this.brand = brand;
        this.type = type;
        size = "Medium";
    }

    // Behavior without parameters
    void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Size: " + size);
        System.out.println("Type: " + type);
    }

    // Behavior with parameters
    void updateSize(String newSize) {
        size = newSize;
        System.out.println("The size of the " + brand + " " + type + " has been updated to " + size + ".");
    }

    // Static method
    static void displayShirt() {
        System.out.println("Shirt: " + shirt);
    }
}
