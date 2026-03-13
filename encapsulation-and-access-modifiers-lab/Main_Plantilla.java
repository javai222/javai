/*
 * This collaboration object demonstrates the testing of validation rules and using getters/setters.
 * Created by Jophel Mark Plantilla
 */

public class Main_Plantilla {
    public static void main(String[] args) {
        // Using car class created by Balanon
        // Creating car object c1
        Cars c1 = new Cars("Ford", "Raptor", 2500000.0, 5); // object with brand, model, price, and stock
        
        // Test if the car class protects from bad data
        c1.setCarStock(-2); // test negative stock
        c1.setCarPrice(-1000.0); // test negative price
        c1.setCarStock(10); // valid stock
        c1.setCarPrice(3000000.0); // valid price
        
        // Calling the car class methods
        c1.sellCar(3); // try to sell cars to reduce stock
        c1.sellCar(15); // try to sell more than stock
        c1.displayCar(); // shows all car details
        Cars.displayTotalCars(); // call static method to counts all car objects made

        // Using Producttt Class created by Torrefranca
        // Creating product object p1
        Producttt p1 = new Producttt("Laptop", "Gadget", 12000.0, 8); // name, category, price, and stock
        
        // Testing product validation
        p1.setPrice(-50.0); // negative price
        p1.sellProduct(5); // try sell laptop
        p1.sellProduct(10); // try to sell more than stock
        p1.addStock(10); //try add more stock

        // Prints output using their getter methods
        System.out.println("Product price is Php " + p1.getPrice());
        System.out.println("Product category: " + p1.getCategory());
    }
}