/*
  Child class created by Dolormente, parent class created by De Leon
*/

public class MainInheritance_Dolormente {
  public static void main(String[] args) {
    
    instrument gt = new Guitar("ZVX Electric Guitar", "Electric guitar", "Hardwood");     // This line of code shows the IS-A relationship because guitar is an instrument

    System.out.println("The guitar's name is " + gt.getName() + ".");                     // Inherited from parent class
    System.out.println("It's a " + gt.getType() + " as its name suggests.");              // Inherited from parent class
    System.out.println("Made from high quality " + gt.getMaterial()                       // Inherited from parent class
                       + " that you would mostly see on quality electric guitars.");
    
    gt.clean();                                                                           // Inherited from parent class
    gt.tune();                                                                            // Inherited from parent class
    gt.play();                                                                            // Inherited from parent class
    Guitar.playChord();                                                                   // New behavior from child class

    instrument vl = new Violin("Vean Vio", "Modern Acoustic", "Tonewoods");               // This line of code shows the IS-A relationship because violin is an instrument
    
    System.out.println("The violin's name is " + vl.getName() + ".");                     // Get is inherited from parent class
    System.out.println("It's a " + vl.getType() + " type of violin.");                    // Get is inherited from parent class
    System.out.println("Originated from Honduras, it is the most superior "               // Get is inherited from parent class
                       + vl.getMaterial() + " out of all the tonewoods in the world.");

    vl.play();                                                                            // Inherited from parent class
    vl.tune();                                                                            // Inherited from parent class
    vl.clean();                                                                           // Inherited from parent class
    Violin.useBow();                                                                      // New behavior from child class

    /* What happens during **dynamic binding**?
    1. The variable type is instrument
    2. The actual object is guitar
    3. The details of the guitar is displayed
    4. The guitar is played, tuned, and cleaned
    5. The guitar version of playChord() executes
    */

    /* What happens during **dynamic binding**?
    1. The variable type is instrument
    2. The actual object is violin
    3. The details of the violin is displayed 
    4. The violin is played, tuned, and cleaned
    5. The guitar version of playChord() executes
    */    
  }
}
    
    
    
    
    
