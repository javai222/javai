
/*
* This class represents a product with a model, brand and manufacturer.
* Created by Dustin Elijah C. Mercado
*/
public class GPU {
    private String model;
    private String brand;

    static int totalProducts = 0;

    public static String manufacturer = "NVIDIA";

    // Default constructor
    public GPU() {
        this.model = "Unknown";
        this.brand = "Unknown";
        totalProducts++;
    }   

    // Overloaded constructor
    public GPU(String brand) {
        this(); 
        this.brand = brand;
    }
    
    // Parameterized constructor
    public GPU(String brand, String model) {
        this.brand = brand;
        this.model = model;
        totalProducts++;
    }

    //Method without parameter
    public void displayDetails() {
        System.out.println("Product Details:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Manufacturer: " + manufacturer);
    }

    // Method with parameter
    public void setBrand(String brand){
        this.brand = brand;
    }

    public void setModel(String model){
        this.model = model;
    }   
    static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }

    public String getModel() {
        return this.model;
    }
    
    public String getBrand() {
        return this.brand;
    }

    // Static method
    public static String getManufacturer() {
        return manufacturer;
    }

}