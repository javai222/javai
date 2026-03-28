/*
* This class represents main Soap class
* Created by Vinz Joseph R. Silva
*/
package composition-lab
public class Soap {
    
    // Attributes
    private String brand;
    private String scent;
    private int cleaningPower;

    // constructors 
public Soap (String brand, String scent, int cleaningPower){
    this.brand = brand;
    this.scent = scent;
    this.cleaningPower = cleaningPower;
    }

    // Getter methods
public String getBrand () {
    return brand;
}

public String getScent () {
    return scent;
}

public int getCleaningPower () {
    return cleaningPower;
}

    // Setter methods
public void setBrand (String brand) {
    this.brand = brand;
}

public void setScent (String scent) {
    this.scent = scent;
}
    // With validation
public void setCleaningPower (int cleaningPower) {
    if (cleaningPower >= 0)
        this.cleaningPower = cleaningPower;
    else
        System.out.println("Power cannot be negative");
}

    // Behaviors
public void showDetails () {
    System.out.println("The brand is " + brand + " with the magical combination of " + scent + " scent");
}

public void useSoap () {
    // validation for the soap cleaning power
    if (this.cleaningPower > 0)
        System.out.println("You can use this soap to clean your libag ☺️");
    else 
        System.out.println("This soap has no cleaning power left 😨 ");
}

}