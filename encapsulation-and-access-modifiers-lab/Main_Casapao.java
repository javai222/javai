// this object created by Casapao, class created by Dolormente(Badminton) and Tismo(Yarn)
// This was created with a bit of help from AI

public class Main_Casapao {
    public static void main(String[] args) {

        //for badminton class

        // Object using default constructor
        Badmintons r1 = new Badmintons();

        // Object using parameterized constructor
        Badmintons r2 = new Badmintons(
            "Astrox 99", "Yonex", "head heavy", "Graphite", "BG66 Ultimax", 15000, 5, 0.83
        );

        // Object using overloaded constructor
        Badmintons r3 = new Badmintons("Nanoflare 800", "Yonex", "BG65", 10);

        // getters
        System.out.println("Racket 2 Brand: " + r2.getRacketBrand());
        System.out.println("Racket 3 Name: " + r3.getRacketName());

        // setters 
        r1.setRacketName("Voltric Z-Force II");
        r1.setRacketPrice(12000);

        // invalid setter 
        r2.setRacketPrice(-5000);

        // Call behaviors
        r1.introduceRacket();
        r2.updateRacket("Victor");
        r3.sellRacket(3);

        // Display static info
        Badmintons.displayTotalRackets();

        // for Yarn class

        // Object using default constructor
        Yarns y1 = new Yarns();

        // Object using overloaded constructor
        Yarns y2 = new Yarns("Red", "Cotton", 8);

        // Object using parameterized constructor
        Yarns y3 = new Yarns("Blue", "Acrylic", 12, 100);

        // getters
        System.out.println("Yarn 2 Color: " + y2.getColor());
        System.out.println("Yarn 3 Grams: " + y3.getGrams());

        // setters 
        y1.setColor("Yellow");
        y1.setGrams(50);

        // invalid setter 
        y2.setPlysize(20); // invalid, out of range
        y3.setGrams(10);   // invalid, out of range

        // Call behaviors
        y1.setYarnType("Wool");
        y2.setColor("Green");

        // Display static info
        Yarns.displayTotalOrders();
