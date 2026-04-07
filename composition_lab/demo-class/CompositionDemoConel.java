package composition_lab;

public class CompositionDemoConel {
    public static void main(String[] args) {

        // Fixed components
        Backpack bag = new Backpack(120, 50, 8);
        Libag sideBag = new Libag("Armpit", 6, true, "black");

        // Initial keyboard
        Keyboard kb1 = new Keyboard("AttackShark", "Black", "Magnetic");

        // System setup
        TechAccesories system = new TechAccesories(bag, kb1, sideBag);
        
        // The system
        system.useTech();
        system.displayTechAccesories();

        // Low Coupling: change keyboard
        Keyboard kb2 = new Keyboard("Logitech", "White", "Wired");
        system.setKeyboard(kb2);

        System.out.println("===== After Changing Keyboard =====");
        system.useTech();
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