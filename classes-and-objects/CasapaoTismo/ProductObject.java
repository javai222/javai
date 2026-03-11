//Object created by Tismo, Class created by casapao

public class ProductObject {
    public static void main(String[] args) {

        // Object using default constructor
        Product p1 = new Product();

        // Object using overloaded constructor
        Product p2 = new Product("Laptop", 50000);

        // Object using parameterized constructor
        Product p3 = new Product("Phone", 20000, "Samsung");

        // Display product details
        p1.displayProduct();
        System.out.println();

        p2.displayProduct();
        System.out.println();

        p3.displayProduct();
        System.out.println();

        // Change price using method with parameter
        p2.setPrice(48000);
        System.out.println("Updated Price for Laptop:");
        p2.displayProduct();
        System.out.println();

        // Call static method
        Product.printTotalObjects();
    }
}