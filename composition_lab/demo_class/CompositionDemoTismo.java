/*
*Composed class created by Tismo, Component created by Sir, Saan, and Cantela
*This was created with the help of AI
*/

package composition_lab;

public class CompositionDemoTismo {
    public static void main(String[] args) {
        // Created component instances with specific attributes
        Libag libag1 = new Libag("Paws", 8, true, "Brown");
        Brain brain1 = new Brain(40, 100, 10);
        Heart heart1 = new Heart(70, "Great", true, 0);
        // Created a Dogs instance that composes the Libag, Brain, and Heart instances
        Dogs doggie = new Dogs("Asher", libag1, brain1, heart1);

        //initial status
        doggie.showStatus();

        //Behavior Methods
        System.out.println("----- BATH TIME!! -----");
        doggie.takeBath();

        System.out.println("\n----- AFTER BATH -----");
        doggie.showStatus();

        System.out.println("\n----- PANIC MODE!! -----");
        doggie.think();
        doggie.panic();
        doggie.showStatus();
    }
}

/*
- The program uses HAS-A relationship since Dogs does have a libag, brain, and heart
- The reused classes were Libag, Brain, and Heart
- Composition reduces coupling since the dog does not control the internal code of the classes instead 
  it interacts with it through the methods
- Each class as a specific responsibility, where the Dogs is the controller, the the Libag handles the cleaning, 
  the Brain handles the thinking, IQ, and stress, while the Heart handles the heart conditions and bpm
- Cohesion is maintained through the use of encapsulation and methods
- Inheritance is not appropriate since it is not a IS-A relationship since Dogs is not a libag, a brain, or a heart
*/