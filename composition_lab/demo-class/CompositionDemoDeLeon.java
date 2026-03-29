/* 
 * This Composed Class was created by De leon, Lord Ulrick A.
 * The Component classes were created by Dolormente(HDLotion), Silva(Soap), and sir Capunpon(Libag)
 * This was created with the help of AI
 */

package composition_lab;

public class CompositionDemoDeLeon { 

    public static void main(String[] args) {

        // Instantiate teammate classes
        HDLotion lotion = new HDLotion("Nivea", "Extra White", "Body Lotion", "XW-2024", "Floral", 250, 8, 200.0);

        Soap soap = new Soap("Dove", "Shea Butter", 6);

        Libag libag = new Libag("Armpit", 7, true, "black");

        // Pass Into Composed Class
        CleaningSession session = new CleaningSession(lotion, soap, libag);

        // Call Methods
        session.startCleaning();
        session.showSummary();

        // Low Coupling
        System.out.println("\n=== Replacing Soap (Low Coupling Demo) ===");

        Soap newSoap = new Soap("Safeguard", "Lemon", 8);
        session.setSoap(newSoap); 

        session.startCleaning();
    }
}


/*
* What are the **HAS-A relationships**?
//The HAS-A relationship in CleaningSession class is CleaningSession HAS-A HDLotion, CleaningSession HAS-A Soap, and CleaningSession HAS-A Libag.

* Which classes were reused?
// The classes reused are HDLotion, Soap, and Libag.

* How does composition reduce coupling?
// Composition reduces coupling by letting objects be passed and replaced without needing to change the CleaningSession class.

* How did you implement high cohesion?  
// High cohesion is implemented by ensuring each class handles only one specific task, such as cleaning, moisturizing, or representing dirt.

* How is cohesion maintained?  
// Cohesion is kept by letting each class handle only its own properties and behaviors.

* Why is inheritance **NOT appropriate** here? 
// Inheritance is not appropriate because CleaningSession is not a type of Soap, HDLotion, or Libag.
*/
