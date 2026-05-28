/*
*Child class created Tismo, Parent class created by Casapao
*/

public class MainInheritance_Tismo {
	public static void main(String[] args) {

		//This line of code shows the IS-A relationship because Mango is a Fruit
        Fruits m = new Mango("Ripe Mango", "Yellow", "Medium");
		//inherited from parent class
		m.peel();
		m.eat();
		//This method was overridden
		m.taste();
		//This is the new behavior the subclass introduced
		Mango.seed();
		System.out.println();
		//inherited from parent class
		m.showDetails();
		System.out.println();
		
		/* What happens during **dynamic binding**?
		1. The variable type is Fruits
		2. The actual object is Mango
		3. The mango is peeled and eaten as stated in the parent class
		4. The Mango version of taste() executes
		5. The details of the Mango is displayed
		*/
		

		//This line of code shows the IS-A relationship because Pineapple is a Fruit
		Fruits p = new Pineapple("Pineappple", "Orange-Yellow", "Medium");
		//inherited from parent class
		p.eat();
		p.peel();
		//This method was overridden
		p.taste();
		//This is the new behavior the subclass introduced
		Pineapple.seed(); 
		System.out.println();
		//inherited from parent class
		p.showDetails();

		/* What happens during **dynamic binding**?
		1. The variable type is Fruits
		2. The actual object is Pineapple
		3. The Pineapple is peeled and eaten as stated in the parent class
		4. The Pineapple version of taste() executes
		5. The details of the Pineapple is displayed
		*/
    }
}
