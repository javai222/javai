public class Laptop {

    //Class created by Torrefranca :)
    // laptop properties
    String brand; // brand name
    String model; // model name
    String cpu;   // cpu type

    // total laptops created
    public static int laptopSales = 0;

    // default laptop
    public Laptop () {
        this.brand = "Acer";
        this.model = "Nitro V15";
        this.cpu = "Ryzen 5";
        laptopSales++;
    }

    // custom laptop (brand, model, cpu)
    public Laptop (String a, String b, String c) {
        this.brand = a;
        this.model = b;
        this.cpu = c;
        laptopSales++;
    }

    // custom laptop (default brand)
    public Laptop (String b, String c) {
        this.brand = "Acer";
        this.model = b;
        this.cpu = c;
        laptopSales++;
    }

    // print this laptop's details
    void displayItems() {
        System.out.println("Laptop Brand: "+brand);
        System.out.println("Laptop Model: "+model);
        System.out.println("CPU: "+cpu);
    }

    // print total laptops created
    static void displayTotalSales() {
        System.out.println("Total Items: "+laptopSales);
    }

}
