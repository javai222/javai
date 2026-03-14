// this object created by Casapao, class created by Tismo
// This was created with a bit of help from AI

public class Main_Casapao {
    public static void main(String[] args) {

        // Create objects from teammate class
        Yarns yarn1 = new Yarns();
        Yarns yarn2 = new Yarns("Blue", "Cotton", 8, 100);

        // Display default yarn
        System.out.println("Yarn 1 Details:");
        System.out.println("Color: " + yarn1.getColor());
        System.out.println("Type: " + yarn1.getYarnType());
        System.out.println("Ply Size: " + yarn1.getPlysize());
        System.out.println("Grams: " + yarn1.getGrams());

        System.out.println();

        // Display parameterized yarn
        System.out.println("Yarn 2 Details:");
        System.out.println("Color: " + yarn2.getColor());
        System.out.println("Type: " + yarn2.getYarnType());
        System.out.println("Ply Size: " + yarn2.getPlysize());
        System.out.println("Grams: " + yarn2.getGrams());

        System.out.println();

        // Use setters (behaviors)
        yarn1.setColor("Red");
        yarn1.setYarnType("Wool");
        yarn1.setPlysize(10);
        yarn1.setGrams(150);

        System.out.println("Updated Yarn 1:");
        System.out.println("Color: " + yarn1.getColor());
        System.out.println("Type: " + yarn1.getYarnType());
        System.out.println("Ply Size: " + yarn1.getPlysize());
        System.out.println("Grams: " + yarn1.getGrams());

        System.out.println();

        // Test invalid inputs 
        System.out.println("Testing invalid inputs:");
        yarn1.setPlysize(20);   // invalid ply size
        yarn1.setGrams(300);    // invalid grams

        System.out.println();

        // Static behavior
        Yarns.displayTotalOrders();
    }
}
