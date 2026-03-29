public class CompositionDemoJavier {
    public static void main(String[] args) {

        Brain brain = new Brain(10, 120, 8);
        compositionKeyboard keyboard = new compositionKeyboard("Logitech", "Black", "Mechanical");
        Libag libag = new Libag("leeg", 7, true, "brown");

        StorageItems storage = new StorageItems(brain, keyboard, libag);

        storage.displayStorageItems();

        System.out.println("\n=== Direct Access ===");
        brain.showPerson(); 
        System.out.println(keyboard.getBrand());
        libag.describe(); 
    }
}

/* What are the HAS-A relationships?
 
// The StorageItems class HAS-A Brain, HAS-A compositionKeyboard, and HAS-A Libag.
Which classes were reused?
// The reused classes are Brain, compositionKeyboard, and Libag.
How does composition reduce coupling?
// Composition reduces coupling because the StorageItems class does not create its own objects. Instead, the objects are passed through the constructor (constructor injection)
How did you implement high cohesion?
// High cohesion was implemented by ensuring that the StorageItems class focuses only on one responsibility, which is managing and displaying the stored components
How is cohesion maintained?
// Cohesion is maintained by keeping all related functionalities within their respective classes
Why is inheritance NOT appropriate here?
// Inheritance is not appropriate because there is no “IS-A” relationship between the classes.*/
