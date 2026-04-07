package composition_lab;

import composition_lab.Battery;  

public class PC {
    
    // Component objects that make up the PC (HAS-A relationship / composition)
    private Battery battery;
    private Keyboard keyboard;
    private Libag libag;

    // Constructor: initializes the PC with its components (constructor injection)
    public PC(Battery battery, Keyboard keyboard, Libag libag) {
        this.battery = battery;
        this.keyboard = keyboard;
        this.libag = libag;
    }

    // Method to display all information about the PC and its components
    public void displayPCSetup() {
        System.out.println("=== PC Setup ===");

        // Display battery details
        System.out.println("\nBattery Information:");
        battery.showBatteryInfo(); 
        
        // Display keyboard details
        System.out.println("\nKeyboard Details:");
        System.out.println("Brand: " + keyboard.getBrand());

        // Display libag details
        System.out.println("\nLibag Information:");
        libag.describe(); 
    }
}