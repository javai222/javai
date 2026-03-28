package composition_lab;

public class StorageItems {
    //Component classes
    private Brain brain;
    private compositionKeyboard keyboard;
    private Libag libag;

    //Constructor Injection
    public StorageItems(Brain brain, compositionKeyboard keyboard, Libag libag) {
        this.brain = brain;
        this.keyboard = keyboard;
        this.libag = libag;
    }

    // Behavior Method
    public void displayStorageItems() {
        System.out.println("=== Bulldog MarketHub Storage ===");

        System.out.println("Human Factory Update:");
        brain.showPerson(); 
        System.out.println("\nKeyboard brand available: " + keyboard.getBrand() + "\n");

        libag.describe(); 
}
}