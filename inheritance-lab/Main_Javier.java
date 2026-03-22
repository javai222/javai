/*
* Child class created by Javier, Parent class created by Balanon
*/

/* What is the IS-A relationship in your program?
 * // This line of code shows the IS-A relationship because a Tiger is a type of Pet
 * 
 * Which method was overridden?
 * // The makeSound() method was overridden
 * 
 * What happens during dynamic binding?
 * // During dynamic binding, the overridden method will be executed based on the actual object (Tiger), not the reference type (Pet)
 * 
 * What methods were inherited from the parent class?
 * // The methods inherited from the parent class are eat() and sleep()
 * 
 * What new behavior did the subclass introduce?
 * // The new behavior introduced by the subclass is hunt()
 */

public class Main_Javier {
    public static void main(String[] args) {
        Tiger tiger = new Tiger("Rajah", 5, "Mammal", "jungle");

        tiger.makeSound(); // Overridden method
        tiger.eat();       // Inherited
        tiger.sleep();     // Inherited
        tiger.hunt();      // Tiger-specific

        /* What is the IS-A relationship in your program?
 * // This line of code shows the IS-A relationship because a Tiger is a type of Pet
 * 
 * Which method was overridden?
 * // The makeSound() method was overridden
 * 
 * What happens during dynamic binding?
 * // During dynamic binding, the overridden method will be performed based on the actual object (Tiger), not the reference type (Pet)
 * 
 * What methods were inherited from the parent class?
 * // The methods inherited from the parent class are eat() and sleep()
 * 
 * What new behavior did the subclass introduce?
 * // The new behavior that the subclass introduced is hunt()
 */
    }
}