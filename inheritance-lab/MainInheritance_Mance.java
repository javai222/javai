/*
* Child class created by John Roque R. Mance, Parent class created by [Your Parent Author]
*/

/* What is the IS-A relationship in your program?
 * // This line of code shows the IS-A relationship because a razer is a type of inheritanceMouse
 * 
 * Which method was overridden?
 * // The scroll() method was overridden
 * 
 * What happens during dynamic binding?
 * // During dynamic binding, the overridden method will be executed based on the actual object (razer), not the reference type (inheritanceMouse)
 * 
 * What methods were inherited from the parent class?
 * // The methods inherited from the parent class are connect() and disconnect() (or other parent methods if applicable)
 * 
 * What new behavior did the subclass introduce?
 * // The new behavior introduced by the subclass is changeRGB()
 */

public class MainInheritance_Mance {
    public static void main(String[] args) {

        attackShark mouse = new attackShark(
            "attackShark",
            "Black",
            "Wireless",
            16000,
            true,
            7
        );

        mouse.scroll();      // Overridden method
        mouse.connect();     // Inherited
        mouse.disconnect();  // Inherited
        mouse.changeRGB();   // attackShark-specific method
    }
}

/* What is the IS-A relationship in your program?
 * // This line of code shows the IS-A relationship because a attackShark is a type of inheritanceMouse
 * 
 * Which method was overridden?
 * // The scroll() method was overridden
 * 
 * What happens during dynamic binding?
 * // During dynamic binding, the overridden method will be performed based on the actual object (razer), not the reference type (inheritanceMouse)
 * 
 * What methods were inherited from the parent class?
 * // The methods inherited from the parent class are connect() and disconnect()
 * 
 * What new behavior did the subclass introduce?
 * // The new behavior that the subclass introduced is changeRGB()
 */