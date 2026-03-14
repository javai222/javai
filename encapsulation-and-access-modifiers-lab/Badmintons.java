/*
* This class represents an item with a name, brand, type, material, string, price, and racketWeight
* Created by Henry S. Dolormente II
*/
public class Badmintons {
    private String racketName;              // Private Attributes
    private String racketBrand;              
    private String racketType;
    private String racketMaterial;              
    private String racketString;
    private int racketPrice;
    private int racketStock;
    private double racketWeight;
    
    private static int totalRackets = 0;  // Static attribute

    public Badmintons() {                   // Default constructor
        racketName = "Unknown";
        racketBrand = "Unknown";
        racketType = "Unknown";
        racketMaterial = "Unknown";
        racketString = "Unknown";
        racketPrice = 0;
        racketStock = 0;
        racketWeight = 0.0;
        totalRackets++;
    }
                                    // Parameterized constructor
    public Badmintons(String racketName, String racketBrand, String racketType, String racketMaterial,
                String racketString, int racketPrice, int racketStock, double racketWeight) {
        this.racketName = racketName;
        this.racketBrand = racketBrand;
        this.racketType = racketType;
        this.racketMaterial = racketMaterial;
        this.racketString = racketString;
        this.racketPrice = racketPrice;
        this.racketStock = racketStock;
        this.racketWeight = racketWeight;
        totalRackets++;
    }
                                    // Overloaded constructor
    public Badmintons(String racketName, String racketBrand, String racketString, int racketStock) {
        this.racketName = racketName;
        this.racketBrand = racketBrand;
        this.racketType = "head heavy";
        this.racketMaterial = "carbon";
        this.racketString = racketString;
        this.racketPrice = 12000;
        this.racketStock = racketStock;
        this.racketWeight = 0.83;
        totalRackets++;
    }
                                    // Behavior without parameters
    public void introduceRacket() {
        System.out.println("This racket is from " + racketBrand + " and is named " + racketName
        + " its racket type is " + racketType + "." + " It is made of " + racketMaterial + " and has a " + racketString + " string to it, it weighs " + racketWeight 
        + "g and costs " + racketPrice + " pesos.\n" + "The current stock of this racket is " + racketStock);
    }
                                    // Behavior with parameters
    public void updateRacket(String newBrand) {
        racketBrand = newBrand;
        System.out.println(racketName + " is now updated to " + racketBrand);
    }
                                    // Static method
    public static void displayTotalRackets() {
        System.out.println("Total Rackets: " + totalRackets);
    }
    public String getRacketName () {
        return this.racketName;
    }

    public String getRacketBrand () {
        return this.racketBrand;
    }

    public String getRacketType () {
        return this.racketType;
    }

    public String getRacketMaterial () {
        return this.racketMaterial;
    }

    public String getRacketString () {
        return this.racketString;
    }

    public int getRacketPrice () {
        return this.racketPrice;
    }

    public int getRacketStock () {
        return this.racketStock;
    }

    public double getRacketWeight (){
        return this.racketWeight;
    }

    public void setRacketName(String racketName) {
        if(racketName != null && !racketName.isEmpty()) 
            this.racketName = racketName;
        else
            System.out.println("Invalid racket name.");
    }

    public void setRacketBrand(String racketBrand) {
        if(racketBrand != null && !racketName.isEmpty())
            this.racketBrand = racketBrand;
        else
            System.out.println("Invalid racket brand.");
    }

    public void setRacketType(String racketType) {
        if(racketType != null && !racketType.isEmpty())
            this.racketType = racketType;
        else
            System.out.println("Invalid racket type.");
    }

    public void getRacketMaterial(String racketMaterial) {
        if(racketMaterial != null && !racketMaterial.isEmpty())
            this.racketMaterial = racketMaterial;
        else
            System.out.println("Invalid racket material.");
    }

    public void getRacketString(String racketString) {
        if(racketString != null && !racketString.isEmpty())
            this.racketString = racketString;
        else
            System.out.println("Invalid racket string.");
    }

    public void setRacketPrice(int racketPrice) {
        if(racketPrice >= 0)
            racketPrice = newPrice;
        else
            System.out.println("Price cannot be negative.");
    }

    public void setRacketStock(int racketStock) {
        if(racketStock >= 0)
            racketStock = newStock;
        else
            System.out.println("Stock cannot be negative.");
    }

    public void setRacketWeight(double racketWeight) {
        if(racketWeight >= 0)
            racketWeight = newWeight;
        else
            System.out.println("Weight cannot be negative.");
    }

    public void displayRacket() {
        System.out.println("Racket Name: " + racketName);
        System.out.println("Racket Brand: " + racketBrand);
        System.out.println("Racket Type: " + racketType);
        System.out.println("Racket Material: " + racketMaterial);
        System.out.println("Racket String: " + racketString);
        System.out.println("Racket Price: " + racketPrice);
        System.out.println("Racket Weight: " + racketWeight);
        System.out.println("Racket Stock: " + racketStock);
    }

    public void sellRacket(int quantity) {
        if(quantity > 0 && quantity <= racketStock) {
            racketStock -= quantity;
            System.out.println(quantity + " product(s) sold.");
        } else {
            System.out.println("Invalid quantity or not enought stock.");
        }
    }

    public static void printTotalRackets() {
        System.out.println("Total rackets: " + totalRackets);
    }
}
