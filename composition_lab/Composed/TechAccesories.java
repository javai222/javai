// Composed class created by Conel, component created by Sir, Mance, Balanon

package composition_lab;

public class TechAccesories {

    // component classes
    private Backpack backpack;
    private Keyboard keyboard;
    private Libag libag;

    // Constructor Injection
    public TechAccesories(Backpack backpack, Keyboard keyboard, Libag libag) {
        this.backpack = backpack;
        this.keyboard = keyboard;
        this.libag = libag;
    }

    // Behavior Method
    public void useTech() {
        System.out.println("=== Tech Accessories System Running ===");

        backpack.display();
        System.out.println("Using Keyboard: " + keyboard.getBrand());

        libag.kuskos();
        System.out.println("System operation finished.");
    }

    public void displayTechAccesories() {
        System.out.println("=== Tech Accessories Status ===");

        System.out.println("Backpack Capacity: " + backpack.getCapacity());
        System.out.println("Keyboard Brand: " + keyboard.getBrand());
        libag.describe();
    }

    // Setters (for low coupling)
    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public void setLibag(Libag libag) {
        this.libag = libag;
    }
}