/*
 * This class represents a Car with a brand, model, price, and stock.
 * It demonstrates encapsulation by keeping attributes private
 * and allowing access through getters and setters.
 * Created by Rj Balanon
 */

public class Cars {

    // Private attributes of the car
    private String carBrand;
    private String carModel;
    private double carPrice;
    private int carStock;

    // Static variable to count how many car objects are created
    private static int totalCars = 0;

    // Default constructor
    // Creates a car with default values
    public Cars() {
        carBrand = "Unknown";
        carModel = "Unknown";
        carPrice = 0;
        carStock = 0;
        totalCars++; // increase the number of cars created
    }

    // Parameterized constructor
    // Allows values to be set when creating the object
    public Cars(String carBrand, String carModel, double carPrice, int carStock) {
        setCarBrand(carBrand);
        setCarModel(carModel);
        setCarPrice(carPrice);
        setCarStock(carStock);
        totalCars++; // increase the counter
    }

    // Getter methods allow other classes to read the values
    public String getCarBrand() {
        return carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public double getCarPrice() {
        return carPrice;
    }

    public int getCarStock() {
        return carStock;
    }

    // Setter with validation
    // Ensures the brand is not empty
    public void setCarBrand(String carBrand) {
        if (carBrand != null && !carBrand.isEmpty()) {
            this.carBrand = carBrand;
        }
    }

    // Setter with validation
    // Ensures the model is not empty
    public void setCarModel(String carModel) {
        if (carModel != null && !carModel.isEmpty()) {
            this.carModel = carModel;
        }
    }

    // Setter with validation
    // Prevents negative price values
    public void setCarPrice(double carPrice) {
        if (carPrice >= 0) {
            this.carPrice = carPrice;
        }
    }

    // Setter with validation
    // Prevents negative stock values
    public void setCarStock(int carStock) {
        if (carStock >= 0) {
            this.carStock = carStock;
        }
    }

    // Behavior method
    // Displays the details of the car
    public void displayCar() {
        System.out.println("Brand: " + carBrand);
        System.out.println("Model: " + carModel);
        System.out.println("Price: " + carPrice);
        System.out.println("Stock: " + carStock);
    }

    // Behavior method
    // Reduces stock when a car is sold
    public void sellCar(int quantity) {
        if (quantity > 0 && quantity <= carStock) {
            carStock -= quantity;
            System.out.println(quantity + " car(s) sold.");
        } else {
            System.out.println("Invalid quantity.");
        }
    }

    // Static method
    // Displays the total number of car objects created
    public static void displayTotalCars() {
        System.out.println("Total Cars Created: " + totalCars);
    }
}
