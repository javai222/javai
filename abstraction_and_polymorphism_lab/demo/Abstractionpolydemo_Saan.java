package demo;

import java.util.Scanner;

import abstraction.minecraft;
import Implementation1.Alex;
import Implementation1.Steve;

public class Abstractionpolydemo_Saan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to the Minecraft Abstraction and Polymorphism Demo!");
        System.out.println("Pick a character to play as: \n 1. Steve \n 2. Alex");
        int characterOption = in.nextInt();
        in.nextLine();

        System.out.print("Enter the name of your character: ");
        String playerName = in.nextLine();

        System.out.print("Enter the type of block your character will use: ");
        String blockType = in.nextLine();

        System.out.print("Enter the health points for your character: ");
        int healthPoints = in.nextInt();

        System.out.print("Enter the hunger points for your character: ");
        int hungerPoints = in.nextInt();
        in.nextLine();

        // ABSTRACTION: Use abstract class type minecraft as reference
        minecraft character;
        // POLYMORPHISM & DYNAMIC BINDING: Assign Steve or Alex at runtime
        switch (characterOption) {
            case 1:
                // Actual type is Steve
                character = new Steve(playerName, blockType, healthPoints, hungerPoints);
                break;
            case 2:
                // Actual type is Alex
                character = new Alex(playerName, blockType, healthPoints, hungerPoints);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                in.close();
                return;
        }

        while (!exit) {
            System.out.println("\n--- Option ---");
            System.out.println(" 1. Display Character Information");
            System.out.println(" 2. Health Status");
            System.out.println(" 3. Hunger Status");
            System.out.println(" 4. Perform Action");
            System.out.println(" 5. Build with Block");
            System.out.println(" 6. Build a Structure");
            System.out.println(" 7. Destroy Block");
            System.out.println(" 0. Exit");
            System.out.print("Choose an option: ");

            int option = in.nextInt();
            in.nextLine();

            switch (option) {
                case 1:
                    // DYNAMIC BINDING: Calls correct overridden method at runtime
                    character.displayInfo();
                    break;
                case 2:
                    // Method overridden differently in Steve vs Alex
                    character.healthStatus();
                    break;
                case 3:
                    // Method overridden differently in Steve vs Alex
                    character.hungerStatus();
                    break;
                case 4:
                    // OVERRIDING: Both Steve and Alex override this abstract method
                    character.performAction();
                    break;
                case 5:
                    System.out.print("Enter the type of block to build: ");
                    String buildBlock = in.nextLine();
                    // OVERLOADING: build() with 1 parameter
                    character.build(buildBlock);
                    break;
                case 6:
                    System.out.print("Enter the type of block to build: ");
                    String structureBlock = in.nextLine();
                    // OVERLOADING: build() with 2 parameters (overloaded version)
                    if (character instanceof Steve) {
                        ((Steve) character).build(structureBlock, "house");
                    } else if (character instanceof Alex) {
                        ((Alex) character).build(structureBlock, "house");
                    }
                    break;
                case 7:
                    System.out.print("Enter the type of block to destroy: ");
                    String destroyBlock = in.nextLine();
                    // DYNAMIC BINDING: Calls Steve's or Alex's destroy() implementation
                    character.destroy(destroyBlock);
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
    

/* 
- What abstract class did you create?
I created an abstract class called Devilfruit_Saan that represents a devil fruit in the One Piece universe. This class has abstract methods for the fruit's abilities and effects.

- What interface did you create?
I created an interface called Attack.java that defines the common methods for all devil fruits.

- What methods did you override?
 I override almost every method in minecraft.java in both Steve and Alex classes, such as performAction(), healthStatus(), hungerStatus(), build(), and destroy().

- What methods did you overload?
    I overloaded the build() method in both Steve and Alex classes to allow for building a specific structure (like a house) in addition to building with a block.

- Where does dynamic binding occur in your code?
Dynamic binding occurs when we call the methods on the character object (which is of type minecraft) that can refer to either a Steve or Alex instance. The actual method that gets executed 
performAction(), healthStatus(), etc.) is determined at runtime based on the actual type of the object (Steve or Alex), demonstrating polymorphism.

- Which part shows polymorphism?
The part that shows polymorphism is when we create a minecraft reference (character) that can point to either a Steve or Alex object. When we call methods like performAction(), healthStatus(), 
hungerStatus(), build(), and destroy() on the character reference, the correct method implementation is executed based on whether the character is a Steve or an Alex, demonstrating polymorphism.

- How does your design achieve low coupling?
design achieves low coupling by using an abstract class (minecraft) and an interface (Playable) to define common behaviors and properties for the characters. This allows us to create 
different character implementations (Steve and Alex) without tightly coupling them to specific implementations. The main method interacts with the characters through the abstract class reference, 
which promotes flexibility and reduces dependencies between classes.

- How does your design achieve high cohesion?
The design achieves high cohesion by ensuring that each class has a clear and focused responsibility. The minecraft class defines the common properties and behaviors of the characters, 
while the Steve and Alex classes implement specific behaviors related to their character traits. The Playable interface defines the contract for playing the game, which is implemented 
by both characters. This separation of concerns allows each class to be cohesive and maintainable.
*/