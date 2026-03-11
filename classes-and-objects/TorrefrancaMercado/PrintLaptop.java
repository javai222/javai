//This object is created By Mercado and Class created by Torrenfranca   
public class PrintLaptop {
    public static void main(String[] args) {

        // object using default constructor
        Laptop laptop1 = new Laptop();

        // object using custom constructor (brand, model, cpu)
        Laptop laptop2 = new Laptop("ASUS", "TUF F15", "Intel i7");

        // object using constructor with default brand
        Laptop laptop3 = new Laptop("Predator Helios 300", "Intel i9");

        // print laptop details
        laptop1.displayItems();
        System.out.println();

        laptop2.displayItems();
        System.out.println();

        laptop3.displayItems();
        System.out.println();

        // display total laptops created
        Laptop.displayTotalSales();
    }
}