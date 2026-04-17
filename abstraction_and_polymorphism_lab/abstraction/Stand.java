/* Created by Rahzel Heeroe R. Conel
*/
package abstraction;

public abstract class Stand {
    // Basic details of each stand.
    private String name; 
    private String type; 
    private String rarity; 

// Constructor to initialize stand data.
Stand (String name, String type, String rarity) {
    this.name = name;
    this.type = type;
    this.rarity = rarity;
} 

String getName() {
    return name;
} 

String getType() {
    return type;
} 

String getRarity() {
    return rarity;
} 


// Setters with simple validation.
void setName(String name) {
    if (name != null)
        this.name = name;
    else
        System.out.println("Invalid name.");
} 

void setType(String type) {
    if (type != null)
        this.type = type;
    else
        System.out.println("Invalid type.");

} 

void setRarity(String rarity) {
    if (rarity != null)
        this.rarity = rarity;
    else
        System.out.println("Invalid rarity.");

} 


// Abstract methods that each stand class must implement.
    public abstract void activateAbility();
    public abstract int calculatePowerLevel();
    public abstract void summon();

// Displays all stand information.
void DisplayStandInfo() {
    System.out.println("\nSTAND INFORMATION");
    System.out.println("Name: " + name);
    System.out.println("Type: " + type);
    System.out.println("Rarity: " + rarity);
    System.out.println("Power Level: " + calculatePowerLevel()); 
}
}
