public class yarn {
    // Attributes
    String color;
    int plysize;
    int grams;

    // Static attribute
    static int totalYarn = 0;

    // Default constructor
    yarn(){
        color = "white";
        plysize = 4;
        grams = 20;
        totalYarn++;
    }

    // Parameterized constructor
    yarn(String color, int plysize, int grams) {
        this.color = color;
        this.plysize = plysize;
        this.grams = grams;
        totalYarn++;
    }

    // Overloaded constructor
    yarn(String color, int plysize) {
        this.color = color;
        this.plysize = plysize;
        this.grams = 20; // default grams
        totalYarn++;
    }

    // Behavior without parameters
    void order() {
        System.out.println("I would like the color " + color + ".");
        System.out.println("The ply size should be " + plysize + " ply.");
        System.out.println("The grams should be " + grams + ".");
    }

    // Behavior with parameters
    void updateGrams(int newGrams) {
        grams = newGrams;
        System.out.println("Buyer has updated the yarn grams to " + grams + ".");
    }

    // Static method
    static void displayTotalOrders() {
        System.out.println("Total yarn orders: " + totalYarn);
    }
}