// This Abstract Class was created by De Leon, Lord Ulrick A.

package abstraction;

public abstract class Lego {

    // Attributes
    private String legoSetName;     // Name of the lego set
    private int legoPiecesQuantity; // Number of lego pieces in the set
    private double legoSetPrice;    // Price of the lego set

    // Constructor
    public Lego(String legoSetName, int legoPiecesQuantity, double legoSetPrice) {
        this.legoSetName = legoSetName;
        this.legoPiecesQuantity = legoPiecesQuantity;
        this.legoSetPrice = legoSetPrice;
    }

    // Getters and Setters
    public String getlegoSetName() {
        return legoSetName;
    }

    public void setlegoSetName(String legoSetName) {
        if(legoSetName != null) {
            this.legoSetName = legoSetName;
        } else {
            System.out.println("This is an invalid Name");
        }
    }

    public int getlegoPiecesQuantity() {
        return legoPiecesQuantity;
    }

    public void setlegoPiecesQuantity(int legoPiecesQuantity) {
        if(legoPiecesQuantity > 0) {
            this.legoPiecesQuantity = legoPiecesQuantity;
        } else {
            System.out.println("Number of pieces should not be 0 or below");
        }
    }

    public double getlegoSetPrice() {
        return legoSetPrice;
    }

    public void setlegoSetPrice(double legoSetPrice) {
        if(legoSetPrice >= 0.0) {
            this.legoSetPrice = legoSetPrice;
        } else {
            System.out.println("Price cannot be a negative integer!");
        }
    }

    // Abstract Method that subclass must implement
    public abstract void buildLegoSet();

    // Concrete Method
    public void displayLegoSetDetails() {
        System.out.println("\nDetails of the Lego Set:");
        System.out.println("Name: " + legoSetName);
        System.out.println("Number of pieces: " + legoPiecesQuantity);
        System.out.println("Price:" + legoSetPrice);
    }
}