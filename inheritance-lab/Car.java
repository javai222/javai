/*
 * This class represents an animal parent class
 * Created by Dolormente, Henry II S.
 */

public class Car {

  private String carBrand;
  private String carModel;
  private String carWheel;
  private String carEngine;
  private String carExhaust;
  privte int gasAmount; 

public Car(String carBrand, String carModel, String carWheel, String carEngine, String carExhaust, int gasAmount) {

  this.carBrand = carBrand;
  this.carModel = carModel;
  this.carWheel = carWheel;
  this.carEngine = carEngine;
  this.carExhaust = carExhaust;
  this.gasAmount = gasAmount;

  }

public String getCarBrand () {
  return carBrand;
  }

public String getCarModel () {
  return carModel;
  }

public String getCarWheel () {
  return carWheel;
  }

public String getCarEngine () {
  return carEngine;
  }

public String getCarExhaust () {
  return carExhaust;
  }

public int getGasAmount () {
  return gasAmount;
  }

public void displayCarSpecs() {
  System.out.println("The brand of the car is " + carBrand 
                    + "\n. Model: " + carModel + "\n"
                    + "\n. Wheel: " + carWheel + "\n"
                    + "\n. Engine: " + carEngine + "\n"
                    + "\n. Exhaust: " + carExhaust + "\n"
                    + "\n. Gas amount: " + gasAmount + "\n");
  }
  
public void ignitionOn() {
  System.out.println("Car is turning on.");
  }

public void ignitionOff() {
  System.out.println("Car is turning off.");
  }
}
