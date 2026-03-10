public class Product {
    // Attributes
    String name;
    double price;
    String brand;

    // Static attributes
    static int totalObjects = 0;

    // Default constructor
    Product() {
        name = "Unknown";
        price = 0.0;
        brand = "No Brand";
        totalObjects++;
    }

    // Parameterized constructor
    Product(String n, double p) {
        name = n;
        price = p;
        brand = "Generic";
        totalObjects++;
    }

    // Overloaded constructor
    Product(String n, double p, String b) {
        name = n;
        price = p;
        brand = b;
        totalObjects++;
    }

    public String getName () {
        return this.name;
    }

    public String getPrice() {
        return this.price;
    }

    public String getBrand() {
        return this.brand;
    }

    // Method without parameter
    void displayProduct() {
        System.out.println("Product Name: " + name);
        System.out.println("Product Price: " + price);
        System.out.println("Product Brand: " + brand);
    }

    // Method with parameter
    void setPrice(double newPrice) {
        price = newPrice;
    }

    // Static method
    static void printTotalObjects() {
        System.out.println("Total products created: " + totalObjects);
    }
}
   
