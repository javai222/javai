
/*
* This class represents a product with a model, brand and manufacturer.
* Created by Dustin Elijah C. Mercado
*/
public class Product {
    private String model;
    private String brand;

    static int totalProducts = 0;

    private static String manufacturer = "NVIDIA";

    // Default constructor
    public Product() {
        this.model = "Unknown";
        this.brand = "Unknown";
        totalProducts++;
    }   

    // Overloaded constructor
    public Product(String brand) {
        this(); 
        this.brand = brand;
        totalProducts++;
    }
    
    // Parameterized constructor
    public Product(String brand, String model) {
        this.brand = brand;
        this.model = model;
        totalProducts++;
    }

    //Method without parameter
    public void displayDetails() {
        System.out.println("Product Details:");
        System.out.println("Brand: " + this.brand);
        System.out.println("Model: " + this.model);
        System.out.println("Manufacturer: " + manufacturer);
    }

    // Method with parameter
    public void setBrand(String brand){
        this.brand = brand;
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