/*
 * This class represents a the name, color, and the weight of the fruits
 * created by Jasmin Ann M. Casapao
 */

public class Fruits {

    // Private attributes
    private String name;
    private String color;
    private double weight;

    // Default constructor
    public Fruit() {
        name = "Unknown Fruit";
        color = "Unknown Color";
        weight = 0.0;
    }

    // Parameterized constructor
    public Fruit(String name, String color, double weight) {
        this.name = name;
        this.color = color;
        this.weight = weight;
    }

    // Behavior methods
    public void eat() {
        System.out.println(name + " is being eaten");
    }

    public void showDetails() {
        System.out.println("Fruit: " + name);
        System.out.println("Color: " + color);
        System.out.println("Weight: " + weight + " kg");
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

    public double getWeight() {
        return weight;
    }
}