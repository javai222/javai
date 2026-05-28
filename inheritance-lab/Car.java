/*
 * This class represents a car parent class
 * Created by Dolormente, Henry II S.
 */

public class Car {
  // Attrivutes
  private String carBrand;
  private String carModel;
  private String carWheel;
  private String carEngine;
  private String carExhaust;
  private int gasAmount; 

// Default Constructors
public Car() {
  this.carBrand = "Unknown";
  this.carModel = "Unknown";
  this.carWheel = "Unknown";
  this.carEngine = "Unknown";
  this.carExhaust = "Unknown";
  this.gasAmount = 0;
  }
// Parameterized Constructors 
public Car(String carBrand, String carModel, String carWheel, String carEngine, String carExhaust, int gasAmount) {
  this.carBrand = carBrand;
  this.carModel = carModel;
  this.carWheel = carWheel;
  this.carEngine = carEngine;
  this.carExhaust = carExhaust;
  this.gasAmount = gasAmount;

  }
// Getters for the attributes
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
// Methods to display and show the behavior of the car
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
// This method can be overriden in child classes.
public void car() {
  System.out.println("The car is electric.");
  }
}
