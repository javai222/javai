// this composed class is created by BALANON, using De leon and Mance's class.

package composition_lab;

public class CleaningSystem {

    // Composition: this class HAS these objects
    private Libag libag;
    private Brush brush;
    private Keyboard keyboard;

    // Constructor
    public CleaningSystem(Libag libag, Brush brush, Keyboard keyboard) {
        this.libag = libag;
        this.brush = brush;
        this.keyboard = keyboard;
    }

    // Method to clean using brush on libag
    public void startCleaning() {
        System.out.println("=== START CLEANING ===");

        libag.describe();
        brush.describe();

        // Step 1: Soak first
        libag.soak();

        // Step 2: Scrub using brush
        System.out.println("Using brush to clean...");
        libag.kuskos();

        // Step 3: Check brush condition
        if (!brush.isNew()) {
            System.out.println("Brush is old, replacing...");
            brush.replace();
        }

        System.out.println("Cleaning finished!");
    }

    // Method to test keyboard after cleaning 
    public void testKeyboard() {
        System.out.println("=== TEST KEYBOARD ===");

        keyboard.setConnection(true);
        keyboard.typing();
        keyboard.click();
        keyboard.rgb();
    }
}
