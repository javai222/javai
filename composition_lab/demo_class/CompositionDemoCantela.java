/*
 *Created by Chris Nelson B. Cantela
 
 * Q: What are the HAS-A relationships?
 * A: Hilod HAS-A Brush, HAS-A Skins, and HAS-A Libag
 
 * Q: Which classes were reused?
 * A: Brush, Skins, and Libag 
 
 * Q: How does composition reduce coupling?
 * A: the class HilodService only has access to the public methods of its components. Also the components can change
 *  its code without affecting the HilodService class.
 *  By using composition you can switch component class anytime.
 
 * Q: How did you implement high cohesion?
 * A: every method only focuses on one thing, no extra stuff/responsibility.
 
 * Q: How is cohesion maintained?
 * A: All methods work together toward the same goal. Each component has its own job.
 *    Everything stays focused and organized.
 
 * Q: Why is inheritance NOT appropriate here?
 * A: Hilod is not a type of Brush, Skins, or libag. it uses them to the job
 */

package composition_lab.demo_class;

//import the composed class and component classes
import composition_lab.Composed.HilodService;
import composition_lab.Brush;
import composition_lab.Libag;
import composition_lab.Skins;

import java.util.Scanner;

public class CompositionDemoCantela {

// Scanner for reading user input
static Scanner in = new Scanner(System.in);
      //variables to store brush component details
      static  String type;
        static String material;
        static int bristleStrength;
        static boolean isNew;
        //variables to store skins component details
        static String skinType;
        static String skinColor;
        static String skinTexture;
        //variables to store libag component details
        static String location;
        static int thickness;
        static boolean matigas;
        static String color;

    public static void main (String[] args) {

        // Ask user if they want to input their own details
        System.out.println("Do you want to put in your own brush, skin, and libag details? (yes/no)");
        String userChoice = in.nextLine().trim().toLowerCase();

        //Using user input or default values
        if (userChoice.equals("yes")) {
            // Get component details from user
            getUserInputForBrush();
            getUserInputForSkins();
            getUserInputForLibag();

            // Create hilod1 by passing parameters
            HilodService hilodOne = new HilodService(type, material, bristleStrength, isNew,
                                     skinType, skinColor, skinTexture,
                                     location, thickness, matigas, color);
            // Call methods on hilod1
            hilodOne.hilodDetails();
            hilodOne.prepareForHilod();
            hilodOne.scrubSkin();
        } else 
            System.out.println("Using default details for Hilod");
        
        //this par demonstrate Object Collaboration
        System.out.println("\n==== Default hilod =====\n");
        
        // Step 1: Instantiate component objects separately
        Brush brush = new Brush("Soft", "Nylon", 5, true);
        Skins skins = new Skins("Smooth", "Light Brown", "Soft");
        Libag libag = new Libag("Singit", 7, false, "blackish");

        // Step 2: Pass component objects into composed class
        HilodService hilod2 = new HilodService (brush, skins, libag);
        
        // Step 3: Call methods across the different classes
        System.out.println("Calling methods on component objects:");
        brush.describe();
        skins.displaySkinInfo();
        libag.describe();

        // Call methods on the composed hilod2 object
        System.out.println();
        hilod2.prepareForHilod();
        hilod2.scrubSkin();
    }


     // Method to get brush details from user
     static void  getUserInputForBrush () {
        System.out.print("Enter brush type (e.g. soft, hard): ");
        type = in.nextLine();

        System.out.print("Enter brush material (e.g. plastic, fiber): ");
        material = in.nextLine();

        System.out.print("Enter bristle strength (1-10): ");
        bristleStrength = in.nextInt();
        in.nextLine(); // Consume newline

        System.out.print("Is the brush new? (true/false): ");
        isNew = in.nextBoolean();
        in.nextLine(); // Consume newline
     }

        // Method to get skins details from user
        static void getUserInputForSkins () {
            System.out.print("Enter skin type (e.g. smooth, rough): ");
            skinType = in.nextLine();
    
            System.out.print("Enter skin color (e.g. light brown, dark brown): ");
            skinColor = in.nextLine();

            System.out.print("Enter skin texture (e.g. soft, rough): ");
            skinTexture = in.nextLine();

}

// Method to get libag details from user
static void getUserInputForLibag () {
    System.out.print("Enter libag location (e.g. leeg, batok, kilikili): ");
    location = in.nextLine();       

    System.out.print("Enter libag thickness (1-10): ");
    thickness = in.nextInt();
    in.nextLine(); // Consume newline

    System.out.print("Is the libag matigas (hardened)? (true/false): ");
    matigas = in.nextBoolean();
    in.nextLine(); // Consume newline

    System.out.print("Enter libag color: ");
    color = in.nextLine();

}

}