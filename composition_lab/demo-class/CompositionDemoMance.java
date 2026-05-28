package composition_lab;

public class CompositionDemoMance {
    public static void main(String[] args) {

        // Instantiate component classes
        Brain brain = new Brain(120, 50, 8);
        Water water = new Water(4.0, 16, true);
        Libag libag = new Libag("Armpit", 6, true, "black");

        // Inject into composed class
        computer c = new computer(brain, water, libag);

        // The system
        c.useComputer();
        c.displayComputerStatus();

        // Low Coupling
        Water water2 = new Water(4.0, 16, true);
        c.setWater(water2);

        System.out.println("=====After Changing Water=====");
        c.useComputer();
    }
}

/*
* What are the **HAS-A relationships**?
//The HAS-A relationship in computer class is computer HAS-A Brain, computer HAS-A Water(cooling system), computer HAS-A Libag(because of sweat)).
* Which classes were reused?
// The classes were reused here is brain, water, and libag.
* How does composition reduce coupling?
// Composition reduces coupling because each class works on its own and just uses the other when needed, so changes in one class won’t easily affect the other.
* How did you implement high cohesion?  
// I implemented high cohesion by making each class focus on one clear task, so everything inside it works toward the same purpose.
* How is cohesion maintained?  
// Cohesion is maintained by keeping each class focused on one specific responsibility.
* Why is inheritance **NOT appropriate** here? 
// Inheritance is not appropriate because a computer is not a type of keyboard; it only uses a keyboard.
*/
