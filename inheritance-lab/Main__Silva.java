/*
*Child class created Silva, Parent class created by Plantilla
*/

/* What is the IS-A relationship in your program?
 * // This line of code shows the IS-A relationship  because coffee is a type of drink 
 * 
 * Which method was overridden?
 * // The feeling() method was overridden
 * 
 * What happens during dynamic binding?
 * // During the dynamic binding, the overriden method will be perfromed based on the parent class. The methods will execute base on the actual object
 * 
 * What methods were inherited from the parent class?
 * // the methods were inherited from the parent class is serveDrink(), displayPrice(), sound(), feeling()
 * 
 * What new behavior did the subclass introduce?
 * // the new behavior that subclass is the doubleFlavor()
 */


public class Main__Silva {
    public static void main(String[] args) {
        //this will show the IS-A relationship because coffee is a type of drink
        Drink dr = new coffee ("Black", "Hot", "Tall", 100);
        // methods inherited from the parent class
        dr.serveDrink();
        dr.displayPrice();

        //overridable methods
        dr.sound();
        dr.feeling();


/* What is the IS-A relationship in your program?
 * // This line of code shows the IS-A relationship  because juice is a type of drink 
 * 
 * Which method was overridden?
 * // The sound() method was overridden
 * 
 * What happens during dynamic binding?
 * // During the dynamic binding, the overriden method will be perfromed based on the parent class. The methods will execute base on the actual object
 * 
 * What methods were inherited from the parent class?
 * // the methods were inherited from the parent class is serveDrink(), displayPrice(), sound(), feeling()
 * 
 * What new behavior did the subclass introduce?
 * // the new behavior that subclass is the doubleFlavor()
 */

        //this will show the IS-A relationship because coffe is a type of drink
        Drink in = new juice ("American", "Cold", "Venti", 90);
        //methods inherited from the parent class
        dr.serveDrink();
        dr.displayPrice();

        //overridable methods
        dr.sound();
        dr.feeling();
    }
}