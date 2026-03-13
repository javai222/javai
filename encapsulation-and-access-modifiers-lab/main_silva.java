// Object created by Silva, Class made by Tismo

public class yarntrial {
	    public static void main(String[] args) {

	        // Object using default constructor
	        Yarns yarn1 = new Yarn();

	        // Object using overloaded constructor
	        Yarns yarn2 = new Yarn("Blue", "Cotton", 8);

	        // Object using parameterized constructor
	        Yarns yarn3 = new Yarn("Red", "Wool", 12, 100);

	        // Display information using getters
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

	        // Display total objects created
	        System.out.println("______________________________ \n");
	        Yarn.displayTotalOrders();
	 }
}