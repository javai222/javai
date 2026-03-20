 * What is the IS-A relationship in your program?
 * // This line of code shows the IS-A relationship  because a MilkChocolate is a Chocolate
 * 
 * Which method was overridden?
 * // The packaging() method was overridden
 * 
 * What happens during dynamic binding?
 * // The method that executes is determined at runtime based on the actual object (MilkChocolate)
 * 
 * What methods were inherited from the parent class?
 * // the methods were inherited from the parent class is eat(), melt(), freeze(), getFlavor(), getType(), getShape()
 * 
 * What new behavior did the subclass introduce?
 * // the new behavior that subclass is the sweetLevel()
 */


public class Main_Casapao {
    public static void main(String[] args) {

        // This line of code shows the IS-A relationship  because a MilkChocolate is a Chocolate
        MilkChocolate milk1 = new MilkChocolate("Milk", "Milk Chocolate", "Square");

       // the methods were inherited from the parent class is eat(), melt(), freeze(), getFlavor(), getType(), getShape()
        milk1.eat();
        milk1.melt();
        milk1.freeze();

        // The packaging() method was overridden
        milk1.packaging();

        // the new behavior that subclass is the sweetLevel()
        milk1.sweetLevel();

        System.out.println("\n--- Dynamic Binding ---");

        // The method that executes is determined at runtime based on the actual object (MilkChocolate)
        Chocolate choco = new MilkChocolate("Milk", "Milk Chocolate", "Square");

        choco.eat();        
        choco.packaging(); 
    } 
}