package composition_lab;

public class CompositionDemoConel {
    public static void main(String[] args) {

        // Instantiate component classes
        Backpack bag = new Backpack(120.0, 50, 8);
        Keyboard keyboard = new Keyboard("AttackShark", "Black", "Magnetic");
        Libag libag = new Libag("Armpit", 6, true, "black");

        // Inject into composed class
        TechAccesories system = new TechAccesories(bag, keyboard, libag);

        // Use the system
        system.displayTechAccesories();

        // Direct access (same style as your classmate)
        System.out.println("\n=== Direct Access ===");
        bag.display();
        System.out.println(keyboard.getBrand());
        libag.describe();
    }
}

/*
* What are the HAS-A relationships?
// The TechAccesories class has a Backpack, Keyboard, and Libag as its components.

* Which classes were reused?
// The classes reused in this program are Backpack, Keyboard, and Libag.

* How does composition reduce coupling?
// Composition reduces coupling by allowing parts like the keyboard to be replaced without affecting the whole system.

* How did you implement high cohesion?  
// High cohesion is implemented by making each class focus on a single responsibility, such as storage, input, or carrying.

* How is cohesion maintained?  
// Cohesion is maintained by keeping each class simple and ensuring its methods are related to one purpose only.

* Why is inheritance NOT appropriate here? 
// Inheritance is not appropriate because these components are not types of each other. For example, a TechAccesories is not a Keyboard, it only uses one.
*/