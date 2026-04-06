/*This class was created by Ryan James M. Balanon
*This class provides a template for Laptop specifications, stock management, 
*and tasks performed by different types of laptops.
*/

package abstraction;

// Abstract class for Laptop
public abstract class Laptop {

    private String brand;
    private int stock; // number of laptops in stock

    // Constructor
    public Laptop(String brand, int stock) {
        this.brand = brand;
        this.stock = stock;
    }

    // Getter methods
    public String getBrand() {
        return brand;
    }

    public int getStock() {
        return stock;
    }

    // Setter methods with validation
    public void setBrand(String brand) {
        if (brand == null || brand.isEmpty()) {
            System.out.println("Invalid brand name");
        } else {
            this.brand = brand;
        }
    }

    public void setStock(int stock) {
        if (stock < 0) {
            System.out.println("Stock cannot be negative");
        } else {
            this.stock = stock;
        }
    }

    // Abstract method
    public abstract void performTask(); // child classes must implement

    // Concrete method
    public void displaySpecs() {
        System.out.println("Laptop Brand: " + brand);
        System.out.println("Stock Available: " + stock);
    }
}
