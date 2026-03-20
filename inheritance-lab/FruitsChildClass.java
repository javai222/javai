/*
*Child class created Tismo, Parent class created by Casapao
*/

//This line of code shows the IS-A relationship because Mango is a Fruit
class Mango extends Fruits {
    //getting needed attributes
	public Mango(String name, String color, String size) {
		super("Ripe Mango", "Yellow", "Medium");
	}

    //new behavior created
    public static void seed(){
        System.out.println("This fruit has a seed.");
    }

    //This method was overriden
    @Override 
    public void taste (){
        System.out.println("This fruit has a juicy and sweet taste");
    }
}

//This line of code shows the IS-A relationship because Pineapple is a Fruit
class Pineapple extends Fruits {
    //getting needed attributes
	public Pineapple(String name, String color, String size) {
		super("Pineappple", "Orange-Yellow", "Medium");
	}
	
    //new behavior created
    public static void seed(){
        System.out.println("This fruit is seedless.");
    }

    //This method was overriden
    @Override 
    public void taste (){
        System.out.println("This fruit has a sweet and sour taste");
    }
}