/*
* This class represent the name, price, brand, and stock for the product
* created by Jasmin Ann M. Casapao
*/

public class Productt {

    // Private Attributes 
    private String name;
    private double price;
    private String brand;
    private int stock;
    private int quality;

    // Static attribute
    private static int totalObjects = 0;

    // Default constructor
    public Productt() {
        name = "Unknown";
        price = 0.0;
        brand = "No Brand";
        stock = 0;
        quality = 0;
        totalObjects++;
    }

    // Parameterized constructor
    public Productt(String n, double p) {
        setName(n);
        setPrice(p);
        brand = "Generic";
        stock = 0;
        quality = 0;
        totalObjects++;
    }

    // Overloaded constructor
    public Productt(String n, double p, String b, int s, int q) {
        setName(n);
        setPrice(p);
        setBrand(b);
        setStock(s);
        setQuality(q);
        totalObjects++;
    }

    
    public String getName () {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public String getBrand() {
        return this.brand;
    }

    public int getStock() {
        return this.stock;
    }

    public int getQuality() {
        return this.quality;
    }

    // Setters with Validation

    public void setName(String name) {
        if(name != null && !name.isEmpty()){
            this.name = name;
        } else {
            System.out.println("Invalid name.");
        }
    }

    public void setPrice(double newPrice) {
        if(newPrice >= 0){
            price = newPrice;
        } else {
            System.out.println("Price cannot be negative.");
        }
    }

    public void setStock(int stock) {
        if(stock >= 0){
            this.stock = stock;
        } else {
            System.out.println("Stock cannot be negative.");
        }
    }

    public void setBrand(String brand) {
        if(brand != null && !brand.isEmpty()){
        this.brand = brand;
    } else {
        System.out.println("Brand cannot be empty.");
    }
 }
    

    // Method without parameter (Behavior)
    public void displayProduct() {
        System.out.println("Product Name: " + name);
        System.out.println("Product Price: " + price);
        System.out.println("Product Brand: " + brand);
        System.out.println("Product Stock: " + stock);
    }

    // Behavior with validation
    public void sellProduct(int quantity) {
        if(quantity > 0 && quantity <= stock){
            stock -= quantity;
            System.out.println(quantity + " product(s) sold.");
        } else {
            System.out.println("Invalid quantity or not enough stock.");
        }
    }

    // Static method
    public static void printTotalObjects() {
        System.out.println("Total products created: " + totalObjects);
    }
}
