// This object was created by De Leon with Ai 
// The classes were created by Casapao(Productt) and Tismo(Yarn)

public class Main_DeLeon {
    public static void main(String[] args) {

        // Creating Productt objects
        Productt p1 = new Productt();
        Productt p2 = new Productt("Laptop", 50000);
        Productt p3 = new Productt("Phone", 20000, "Samsung", 10);

        // Display product details
        System.out.println("PRODUCT DETAILS");
        p1.displayProduct();
        System.out.println();

        p2.displayProduct();
        System.out.println();

        p3.displayProduct();
        System.out.println();

        // Sell some products
        p3.sellProduct(3);
        System.out.println();

        // Print total products created
        Productt.printTotalObjects();

        System.out.println("\n-----------------------------\n");

        // Creating Yarns objects
        Yarns y1 = new Yarns();
        Yarns y2 = new Yarns("Red", "Cotton", 8);
        Yarns y3 = new Yarns("Blue", "Wool", 12, 100);

        // Display yarn details using getters
        System.out.println("YARN DETAILS");
        System.out.println("Color: " + y1.getColor());
        System.out.println("Type: " + y1.getYarnType());
        System.out.println("Ply Size: " + y1.getPlysize());
        System.out.println("Grams: " + y1.getGrams());
        System.out.println();

        System.out.println("Color: " + y2.getColor());
        System.out.println("Type: " + y2.getYarnType());
        System.out.println("Ply Size: " + y2.getPlysize());
        System.out.println("Grams: " + y2.getGrams());
        System.out.println();

        System.out.println("Color: " + y3.getColor());
        System.out.println("Type: " + y3.getYarnType());
        System.out.println("Ply Size: " + y3.getPlysize());
        System.out.println("Grams: " + y3.getGrams());
        System.out.println();

        // Display total yarn orders
        Yarns.displayTotalOrders();
    }
}