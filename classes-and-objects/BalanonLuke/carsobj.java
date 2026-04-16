// This object is created by De Leon and class by Balanon

public class carsobj {
    public static void main(String[] args) {

        // Object using the default constructor
        Cars car1 = new Cars();

        // Object using the parameterized constructor
        Cars car2 = new Cars("Toyota", "Corolla", 1500000, 0);

        // Object using the overloaded constructor (brand only)
        Cars car3 = new Cars("Honda", null, 0, 0);

        // Display car details
        car1.displayCar();
        System.out.println();

        car2.displayCar();
        System.out.println();

        car3.displayCar();
        System.out.println();

        // Update price of a car
        car3.setCarPrice(1200000);

        // Print total number of cars created
        Cars.displayTotalCars();
    }
}