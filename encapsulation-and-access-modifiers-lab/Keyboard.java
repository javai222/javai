/*
 * This class represents a Keyboard with a brand, color, type, and stock.
 * It demonstrates encapsulation by keeping attributes private
 * and allowing access through getters and setters with validation.
 * It also tracks the number of keyboards created using a static counter.
 * Created by John Roque R. Mance
 */

package encapsulation.and.access.modifiers.lab;

public class Keyboard {

    // Private attributes (Encapsulation)
    private String brand;
    private String color;
    private String type;
    private int stock;

    // Static attribute
    private static int keyboardSales = 0;

    // Constructor without parameters
    public Keyboard() {
        this.brand = "Reddragon";
        this.color = "white";
        this.type = "mechanical";
        this.stock = 10;

        keyboardSales++;
    }

    // Constructor with parameters
    public Keyboard(String brand, String color, String type, int stock) {
        this.brand = brand;
        this.color = color;
        this.type = type;
        setStock(stock);

        keyboardSales++;
    }

    // Overloaded constructor
    public Keyboard(String color, String type) {
        this.brand = "Reddragon";
        this.color = color;
        this.type = type;
        this.stock = 10;

        keyboardSales++;
    }

    // Getters
    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public int getStock() {
        return stock;
    }

    // Setters with validation
    public void setBrand(String brand) {
        if (brand != null && !brand.isEmpty()) {
            this.brand = brand;
        }
    }

    public void setColor(String color) {
        if (color != null && !color.isEmpty()) {
            this.color = color;
        }
    }

    public void setStock(int stock) {
        if (stock >= 0) {   // validation rule
            this.stock = stock;
        }
    }

    // Behavior 1
    public void sellKeyboard(int quantity) {
        if (quantity > 0 && quantity <= stock) {
            stock -= quantity;
            System.out.println(quantity + " keyboard(s) sold.");
        } else {
            System.out.println("Invalid sale amount.");
        }
    }

    // Behavior 2
    public void displayItems() {
        System.out.println("Keyboard Brand: " + brand);
        System.out.println("Keyboard Color: " + color);
        System.out.println("Keyboard Type: " + type);
        System.out.println("Stock: " + stock);
    }

    // Static behavior
    public static void displayTotalSales() {
        System.out.println("Total Keyboards Created: " + keyboardSales);
    }
}