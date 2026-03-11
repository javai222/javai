/*
 * This class represents a car with a brand, model, and price.
 * It also keeps track of the total number of cars created.
 * Created by Rj Balanon  
 */

public class Cars {

    // Attributes that describe a car
    String brand;
    String model;
    double price;

    // Static variable to count how many car objects are created
    static int totalCars = 0;

    // Default constructor (no parameters)
    // Sets default values when a car object is created
    Cars() {
        brand = "Unknown Brand";
        model = "Unknown Model";
        price = 0.0;
        totalCars++; // increase the number of cars created
    }

    // Parameterized constructor
    // Allows the user to set values when creating the object
    Cars(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        totalCars++; // increase the counter
    }

    // Overloaded constructor
    // Only the brand is provided
    Cars(String brand) {
        this.brand = brand;
        model = "Unknown Model";
        price = 0.0;
        totalCars++; // increase the counter
    }

    // Method without parameters
    // Displays the details of the car
    void displayCar() {
        System.out.println("Car Brand: " + brand);
        System.out.println("Car Model: " + model);
        System.out.println("Car Price: " + price);
    }

    // Method with parameter
    // Updates the price of the car
    void setPrice(double newPrice) {
        price = newPrice;
        System.out.println("New price set to: " + price);
    }

    // Static method
    // Displays the total number of car objects created
    static void printTotalCars() {
        System.out.println("Total Cars Created: " + totalCars);
    }
}
