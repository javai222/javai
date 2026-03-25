/*
* This class represents water component class
* Created by Plantilla, Jophel Mark 
* ex. Bottle HAS-A Water, Glass HAS-A Water
*/

public class Water {
    // Attributes
    private double volume;       // in liters
    private int temperature;     // in Celsius
    private boolean isClean;     

    // Default Constructor 
    public Water() {
        this.volume = 1.0;         
        this.temperature = 25;     // room temperature
        this.isClean = true;       
    }

    // Parameterized Constructor 
    public Water(double volume, int temperature, boolean isClean) {  
        this.volume = volume;
        this.temperature = temperature;
        this.isClean = isClean;    
    }

    // Getters
    public double getVolume() {
        return volume;
    }

    public int getTemperature() {
        return temperature;
    }

    public boolean isClean() {
        return isClean;    
    }

    // Setters with validation
    public void setVolume(double volume) {
        if (volume > 0) {
            this.volume = volume;
        } else {
            System.out.println("It is empty! ");
        }
    }

    public void setTemperature(int temperature) {
        if (temperature >= 0 && temperature <= 100) {
            this.temperature = temperature;
        } else if (temperature < 0) {
            System.out.println("The water is FREEZING!");
        } else {  
            System.out.println("The water is BOILING!");
        }
    }

    public void setClean(boolean isClean) { 
        this.isClean = isClean;   
    }

    // Behaviors  
    public void pour() {
        System.out.println("Pouring " + volume + " liters of water.");
    }

    public void drink() {
        System.out.println("Drinking " + volume + " liters of water.");
    }

    public void display() {
        System.out.println("Water Details:");
        System.out.println("Volume: " + volume + "L");
        System.out.println("Temperature: " + temperature + "°C");
        System.out.println("Clean: " + isClean);  
    }
}