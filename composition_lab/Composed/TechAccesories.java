package composition_lab;

public class TechAccesories {
    
    // Component objects that make up the PC (HAS-A relationship / composition)
    private Backpack backpack;
    private Keyboard keyboard;
    private Libag libag;

    // Constructor: initializes the TechAccesories with its components (constructor injection)
    public TechAccesories(Backpack backpack, Keyboard keyboard, Libag libag) {
        this.backpack = backpack;
        this.keyboard = keyboard;
        this.libag = libag;
    }

    // Method to display all information about the PC and its components
    public void displayTechAccesories() {
        System.out.println("=== Tech Accesories ===");

        // Display backpack details
        System.out.println("\nBackpack Information:");
        backpack.showBackpackInfo(); 
        
        // Display keyboard details
        System.out.println("\nKeyboard Details:");
        System.out.println("Brand: " + keyboard.getBrand());

        // Display libag details
        System.out.println("\nLibag Information:");
        libag.describe(); 
    }
}