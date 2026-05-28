/*
 * This collaboration object demonstrates the testing of validation rules and using getters/setters.
 * Object created by Plantilla, Classes made by Balanon & Torrefranca
 * This is created with the help of AI
 */


public class Main_Plantilla {
    public static void main(String[] args) {
        // Cars Class created by Balanon
        // Object with parameterized constructor 
        CarsNiBalanon c1 = new CarsNiBalanon("Ford", "Raptor", 2500000.0, 5);

        // Test validation rules
        c1.setCarStock(-2); // Invalid negative stock
        c1.setCarPrice(-1000.0); // Invalid negative price
        c1.setCarStock(10); // Valid stock
        c1.setCarPrice(3000000.0); // Valid price

        // Car behaviors
        c1.sellCar(3); // Valid sale
        c1.sellCar(15); // Invalid oversale
        c1.displayCar(); // Display details

        // Information Display from the Getters
        System.out.println("Car Information:");
        System.out.println("Brand: " + c1.getCarBrand());
        System.out.println("Model: " + c1.getCarModel());
        System.out.println("Price: Php " + c1.getCarPrice());
        System.out.println("Stock: " + c1.getCarStock());
        System.out.println();

        // Display total objects created
        CarsNiBalanon.displayTotalCars();

        // Using Producttt Class created by Torrefranca
        // Object with parameterized constructor 
        Producttt p1 = new Producttt("Laptop", "Gadget", 12000.0, 8);

        // Test product validation
        p1.setPrice(-50.0); // Invalid negative price
        p1.sellProduct(5); // Valid sale
        p1.sellProduct(10); // Invalid oversale
        p1.addStock(10); // Add stock

        // Product Information Display from the Getters
        System.out.println("Product Information:");
        System.out.println("Name: " + p1.getName());
        System.out.println("Category: " + p1.getCategory());
        System.out.println("Price: Php " + p1.getPrice());
        System.out.println("Stock: " + p1.getStock());
        System.out.println();

        // Display total objects created
        System.out.println("Total Products Created: " + Producttt.totalProducts);
    }
}