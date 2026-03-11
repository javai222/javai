/*
* This class represents an item with a name, brand, type, material, string, price, and racketWeight
* Created by Henry S. Dolormente II
*/



public class Badminton {
    String racketName;              // Attributes
    String racketBrand;              
    String racketType;
    String racketMaterial;              
    String racketString;
    int racketPrice;
    double racketWeight;
    
    static int totalRackets = 0;  // Static attribute

    Badminton() {                   // Default constructor
        racketName = "Unknown";
        racketBrand = "Unknown";
        racketType = "Unknown";
        racketMaterial = "Unknown";
        racketString = "Unknown";
        racketPrice = 0;
        racketWeight = 0.0;
        totalRackets++;
    }
                                    // Parameterized constructor
    Badminton(String racketName, String racketBrand, String racketType, String racketMaterial,
                String racketString, int racketPrice, double racketWeight) {
        this.racketName = racketName;
        this.racketBrand = racketBrand;
        this.racketType = racketType;
        this.racketMaterial = racketMaterial;
        this.racketString = racketString;
        this.racketPrice = racketPrice;
        this.racketWeight = racketWeight;
        totalRackets++;
    }
                                    // Overloaded constructor
    Badminton(String racketName, String racketBrand, String racketString) {
        this.racketName = racketName;
        this.racketBrand = racketBrand;
        this.racketType = "head heavy";
        this.racketMaterial = "carbon";
        this.racketString = racketString;
        this.racketPrice = 12000;
        this.racketWeight = 0.83;
        totalRackets++;
    }
                                    // Behavior without parameters
    void introduceRacket() {
        System.out.println("This racket is from " + racketBrand + " and is named " + racketName
        + " its racket type is " + racketType + "." + " It is made of " + racketMaterial + " and has a " + racketString + " string to it, it weighs " + racketWeight 
        + "g and costs " + racketPrice + " pesos.\n");
    }
                                    // Behavior with parameters
    void updateRacket(String newBrand) {
        racketBrand = newBrand;
        System.out.println(racketName + " is now updated to " + racketBrand);
    }
                                    // Static method
    static void displayTotalRackets() {
        System.out.println("Total Rackets: " + totalRackets);

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

    public String getRacketPrice () {
        return this.racketPrice;
    }

    public String getRacketWeight (){
        return this.racketWeight;
    }
}
