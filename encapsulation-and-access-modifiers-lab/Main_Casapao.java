// this object created by Casapao, class created by Dolormente(Badminton) and Tismo(Yarn)
// This was created with a bit of help from AI

public class Main_Casapao {
    public static void main(String[] args) {

         // Create Badminton object
        Badmintons r1 = new Badmintons(
            "Astrox 99",
            "Yonex",
            "Head Heavy",
            "Graphite",
            "BG66 Ultimax",
            15000,
            10,
            83.0
        );

        // Use getters
        System.out.println("Racket Name: " + r1.getRacketName());
        System.out.println("Racket Brand: " + r1.getRacketBrand());

        // Call behaviors
        r1.introduceRacket();
        r1.sellRacket(2);

        // Use setter
        r1.setRacketName("Astrox 100ZZ");

        // Test invalid input
        r1.setRacketPrice(-5000);

        // Static method
        Badmintons.printTotalRackets();



        // Create Yarn object
        Yarns y1 = new Yarns("Red", "Cotton", 6, 100);

        // Use getters
        System.out.println("\nYarn Color: " + y1.getColor());
        System.out.println("Yarn Type: " + y1.getYarnType());

        // Use setters
        y1.setColor("Blue");
        y1.setYarnType("Wool");

        // Test invalid inputs
        y1.setPlysize(20);
        y1.setGrams(500);

        // Static behavior
        Yarns.displayTotalOrders();
    }
}
