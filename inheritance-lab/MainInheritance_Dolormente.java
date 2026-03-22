/*
* Child class created by Dolormente, parent class created by De Leon
*/

public class MainInheritance_Dolormente {
  public static void main(String[] args) {
    
    instrument gt = new instrumentChildClass("ZVX Electric Guitar", "Electric guitar", "Hardwood");  // This line of code shows the IS-A relationship because guitar is an instrument

    System.out.println("The guitar's name is " + gt.getName() + ".");                     // Inherited from parent class
    System.out.println("It's a " + gt.getType() + " as its name suggests.");              // Inherited from parent class
    System.out.println("Made from high quality " + gt.getMaterial()                       // Inherited from parent class
                       + " that you would mostly see on quality electric guitars.");
    
    gt.clean();
    gt.tune();
    gt.play();
    gt.playChord();                                                                    // Overriden method

    instrument vl = new instrumentChildClass("Vean Vio", "Modern Acoustic", "Tonewoods");            // This line of code shows the IS-A relationship because violin is an instrument
    
    System.out.println("The violin's name is " + vl.getName() + ".");                     // Get is inherited from parent class
    System.out.println("It's a " + vl.getType() + " type of violin.");                    // Get is inherited from parent class
    System.out.println("Originated from Honduras, it is the most superior "            // Get is nherited from parent class
                       + vl.getMaterial() + " out of all the tonewoods in the world.");

    vl.play();                                                                         // Inherited from parent class
    vl.tune();                                                                         // Inherited from parent class
    vl.clean();                                                                        // Inherited from parent class
    vl.useBow();                                                                       // Overriden method

  }
}
    
    
    
    
    
