// Object created by Silva, Class made by Tismo

public class main_silva {
	    public static void main(String[] args) {

	        // Object with a default constructor
	        Yarns yarn1 = new Yarns();

	        // Object with a overloaded constructor
	        Yarns yarn2 = new Yarns("Blue", "Cotton", 8);

	        // Object with a parameterized constructor
	        Yarns yarn3 = new Yarns("Red", "Wool", 12, 100);

	        // Information Display from the Getters
	        System.out.println("Yarn 1");
	        System.out.println("Color: " + yarn1.getColor());
	        System.out.println("Type: " + yarn1.getYarnType());
	        System.out.println("Ply Size: " + yarn1.getPlysize());
	        System.out.println("Grams: " + yarn1.getGrams());

	        System.out.println();

	        System.out.println("Yarn 2");
	        System.out.println("Color: " + yarn2.getColor());
	        System.out.println("Type: " + yarn2.getYarnType());
	        System.out.println("Ply Size: " + yarn2.getPlysize());
	        System.out.println("Grams: " + yarn2.getGrams());

	        System.out.println();

	        System.out.println("Yarn 3");
	        System.out.println("Color: " + yarn3.getColor());
	        System.out.println("Type: " + yarn3.getYarnType());
	        System.out.println("Ply Size: " + yarn3.getPlysize());
	        System.out.println("Grams: " + yarn3.getGrams());

	        // Display all the objects created 
	        System.out.println("______________________________ \n");
	        Yarn.displayTotalOrders();
	 }
}