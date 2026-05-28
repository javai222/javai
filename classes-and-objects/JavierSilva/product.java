/*
* This class represents a product with a brand, size, and type.
* Created by Charles Justin Javier
*/

public class product {

    // Static attribute (shared by all Product objects)
    static String shirt;

    // Attributes (instance variables of the object)
    String brand;
    String size;
    String type;

    // Default constructor
    // Sets default values when a Product object is created without parameters
    product() {
        brand = "H&M";
        size = "Medium";
        type = "T-shirt";
    }

    // Parameterized constructor
    // Allows the user to set brand, size, and type when creating the object
    product(String brand, String size, String type) {
        this.brand = brand;
        this.size = size;
        this.type = type;
    }

    // Overloaded constructor
    // Allows creation of a Product object with brand and type only
    // The size will automatically default to "Medium"
    product(String brand, String type) {
        this.brand = brand;
        this.type = type;
        size = "Medium";
    }

    // Method without parameters
    // Displays the details of the product
    void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Size: " + size);
        System.out.println("Type: " + type);
    }

    // Method with parameters
    // Updates the size of the product
    void updateSize(String newSize) {
        size = newSize;
        System.out.println("The size of the " + brand + " " + type + " has been updated to " + size + ".");
    }

    // Static method
    // Displays the value of the static variable shirt
    static void displayShirt() {
        System.out.println("Shirt: " + shirt);
    }
}