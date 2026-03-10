public class yarn {
    String color;
    int plysize;
    int grams;

    static int totalYarn = 0;

    yarn(){
        color = "white";
        plysize = 4;
        grams = 20;
        totalYarn++;
    }

    yarn(String color, int plysize, int grams) {
        this.color = color;
        this.plysize = plysize;
        this.grams = grams;
        totalYarn++;
    }

    yarn(String color, int plysize) {
        this.color = color;
        this.plysize = plysize;
        this.grams = 20; // default age
        totalYarn++;
    }

    void order() {
        System.out.println("I would like the color " + color + ".");
        System.out.println("The ply size should be " + plysize + " ply.");
        System.out.println("The grams should be " + grams + ".");
    }

    void updateGrams(int newGrams) {
        grams = newGrams;
        System.out.println("Buyer has updated the yarn grams to " + grams + ".");
    }

    static void displayTotalOrders() {
        System.out.println("Total yarn orders submitted: " + totalYarn);
    }
}