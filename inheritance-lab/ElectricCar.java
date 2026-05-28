// This child class was created by De Leon
// The parent class was created by Dolormente

public class ElectricCar extends Car {
    public ElectricCar(String carBrand, String carModel, String carWheel, String carEngine, String carExhaust, int gasAmount) {
        super(carBrand, carModel, carWheel, carEngine, carExhaust, gasAmount);
    }

    // New Behavior
    public void chargeBattery() {
        System.out.println("The electric car is charging its battery.");
    }

    //Overridden Method
    @Override
    public void car() {
        System.out.println("This car runs on electricity.");
    }
}