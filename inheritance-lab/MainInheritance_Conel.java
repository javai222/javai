/*
* Child class created by Rahzel Heeroe R. Conel, Parent class created by [Your Parent Author]
*/

/* What is the IS-A relationship in your program?
 * // This line of code shows the IS-A relationship because a KeyboardChildClass is a type of InheritanceKeyboard
 * 
 * Which method was overridden?
 * // The Typing() and RGB() methods were overridden
 * 
 * What happens during dynamic binding?
 * // During dynamic binding, the overridden method will be executed based on the actual object (KeyboardChildClass), not the reference type (InheritanceKeyboard)
 * 
 * What methods were inherited from the parent class?
 * // The methods inherited from the parent class are getBrand(), getColor(), getType(), getKeys(), and any other parent methods
 * 
 * What new behavior did the subclass introduce?
 * // The new behavior introduced by the subclass is gamingMode()
 */

public class MainInheritance_Conel {
    public static void main(String[] args) {

        // Creating a KeyboardChildClass object using parameterized constructor
        KeyboardChildClass razer = new KeyboardChildClass(
            "Razer",
            "Black",
            "Mechanical",
            104,
            true,
            1000
        );

        // Calling overridden methods
        razer.Typing();  // Overridden Typing method
        razer.RGB();     // Overridden RGB method

        // Calling inherited methods (from parent)
        System.out.println("Brand: " + razer.getBrand());
        System.out.println("Color: " + razer.getColor());
        System.out.println("Type: " + razer.getType());
        System.out.println("Keys: " + razer.getKeys());

        // Calling subclass-specific method
        razer.gamingMode(); // New behavior
    }
}

/* What is the IS-A relationship in your program?
 * // This line of code shows the IS-A relationship because a KeyboardChildClass is a type of InheritanceKeyboard
 * 
 * Which method was overridden?
 * // The Typing() and RGB() methods were overridden
 * 
 * What happens during dynamic binding?
 * // During dynamic binding, the overridden method will be executed based on the actual object (KeyboardChildClass), not the reference type (InheritanceKeyboard)
 * 
 * What methods were inherited from the parent class?
 * // The methods inherited from the parent class are getBrand(), getColor(), getType(), getKeys()
 * 
 * What new behavior did the subclass introduce?
 * // The new behavior introduced by the subclass is gamingMode()
 */