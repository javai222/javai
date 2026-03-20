/*
 * This class represents a the name, color, and the weight of the fruits
 * created by Jasmin Ann M. Casapao
 */

public class Fruits {

    // Private attributes
    private String name;
    private String color;
    private String size;

    // Default constructor
    public Fruits() {
        name = "Unknown Fruit";
        color = "Unknown Color";
        size = "Unknown size";
    }

    // Parameterized constructor
    public Fruits(String name, String color, String size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }

    // Behavior methods
    public void eat() {
        System.out.println(name + " is being eaten");
    }

    public void showDetails() {
        System.out.println("Fruit: " + name);
        System.out.println("Color: " + color);
        System.out.println("Size: " + size);
    }

    public void peel() {
        System.out.println(name + " is being peeled");
    }

    // Method to be overridden
    public void taste() {
        System.out.println("This fruit has an enjoyable taste");
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public double getSize() {
        return size;
    }
}