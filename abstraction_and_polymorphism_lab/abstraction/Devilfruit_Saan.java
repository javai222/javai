/* Author: Kenneth Saan 
   Class: Devilfruit_Saan
*/
package abstraction;

public abstract class Devilfruit_Saan {
    // Basic details of each devil fruit.
    private String name; 
    private String type; 
    private String rarity; 
    private int unlockLevel;

// Constructor to initialize devil fruit data.
Devilfruit_Saan(String name, String type, String rarity, int unlockLevel) {
    this.name = name;
    this.type = type;
    this.rarity = rarity;
    this.unlockLevel = unlockLevel;
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

int getUnlockLevel() {
    return unlockLevel;
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

void setUnlockLevel(int unlockLevel) {
    if (unlockLevel >= 0)
        this.unlockLevel = unlockLevel;
    else
        System.out.println("Invalid unlock level.");
}

// Abstract methods that each specific devil fruit class must implement.
abstract String getDescription();
abstract String useAbility(String target);
abstract String getWeakness();

// Displays all devil fruit information.
void DisplayDevilfruitInfo() {
    System.out.println("\nDEVILFRUIT INFORMATION");
    System.out.println("Name: " + name);
    System.out.println("Type: " + type);
    System.out.println("Rarity: " + rarity);
    System.out.println("Unlock Level: " + unlockLevel);
    System.out.println("Description: " + getDescription());
    System.out.println("Weakness: " + getWeakness());
    
}
}
