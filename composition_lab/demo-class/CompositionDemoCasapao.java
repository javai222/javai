

package composition_lab;

public class CompositionDemocasapao {
    public static void main(String[] args) {

        // Instantiate component classes
        Soap soap1 = new Soap("Lifebouy", "Citrusy", 8);
        Water water1 = new Water(4.0, 16, true);
        Libag libag = new Libag("Armpit", 6, true, "black");

        // Inject into composed class
        Bathing bath = new Bathing(soap1, water1, libag1);

        // The system
        bath.startbathing();
        bath.displayBathing();

        // Low Coupling
        Soap soap2 = new Soap("Bioderm", "Fresh", 9);
        bath.setSoap(soap2);

        System.out.println("=====After Changing Soap=====");
        bath.startBathing();
    }
}

/*
* What are the **HAS-A relationships**?
//The HAS-A relationship in Bathing class is Bathing HAS-A Soap, Bathing HAS-A Water, Bathing HAS-A Libag.
* Which classes were reused?
// The classes were reused here is soap, water, and libag.
* How does composition reduce coupling?
// Composition reduces coupling by allowing components to be changed or replaced without modifying the main class.
* How did you implement high cohesion?  
// High cohesion was implemented by assigning each class a single clear responsibility.
* How is cohesion maintained?  
// Cohesion is maintained by ensuring each class only performs tasks related to its purpose.
* Why is inheritance **NOT appropriate** here? 
// Inheritance is not appropriate because these are seperate components that work together, so a HAS-A relationship is more suitable than an IS-A relationship which is inheritance.
*/