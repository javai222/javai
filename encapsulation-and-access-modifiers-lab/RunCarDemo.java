public class RunCarDemo {
    public static void main(String[] args) {
        Cars car1 = new Cars("Toyota", "Camry", 25000, 10);
        Cars car2 = new Cars("Honda", "Civic", 22000, 8);

        car1.displayCar();
        car1.sellCar(3);
        car1.displayCar();

        car2.displayCar();
        car2.sellCar(20); // invalid quantity
        car2.displayCar();

        Cars.displayTotalCars();
    }
}
