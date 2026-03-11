public class Yarn {

    /*
    *This class represents yarn orders with colors, ply size, and grams
    *Created by Yvette Germaine Tismo
    */

    // Attributes
    String color;
    int plysize;
    int grams;

    // Static attribute
    static int totalYarn = 0;

    // Default constructor
    Yarn(){
        color = "white";
        plysize = 4;
        grams = 20;
        totalYarn++;
    }

    // Parameterized constructor
    Yarn(String color, int plysize, int grams) {
        this.color = color;
        this.plysize = plysize;
        this.grams = grams;
        totalYarn++;
    }

    // Overloaded constructor
    Yarn(String color, int plysize) {
        this.color = color;
        this.plysize = plysize;
        this.grams = 20; // default grams
        totalYarn++;
    }

    public String getColor(){
        return this.color;
    }

    public int getPlysize(){
        return this.plysize;
    }

    public int getGrams(){
        return this.grams;
    }

    // Behavior without parameters
    void order() {
        System.out.println("I would like the color " + color + ".");
        System.out.println("The ply size should be " + plysize + " ply.");
        System.out.println("The grams should be " + grams + ".");
    }

    // Behavior with parameters
    void updateColor(String newColor) {
        color = newColor;
        System.out.println("Buyer has updated the yarn color to " + color + ".");
    }

    void updatePlysize(int newPlysize) {
        plysize = newPlysize;
        System.out.println("Buyer has updated the yarn ply size to " + plysize + ".");
    }

    void updateGrams(int newGrams) {
        grams = newGrams;
        System.out.println("Buyer has updated the yarn grams to " + grams + ".");
    }

    // Static method
    static void displayTotalOrders() {
        System.out.println("Total yarn orders: " + totalYarn);
    }
}
