package composition_lab;

// This class is created by Torrefranca :)

public class Battery {

    // Private attributes
    private int capacity;       // total battery capacity (e.g., mAh)
    private int chargeLevel;    // current charge level (0–100)
    private String brand;       // battery brand name

    public Battery(int capacity, String brand) {
        this.capacity = capacity;
        this.brand = brand;
        this.chargeLevel = 100; // default fully charged
    }

    public int getChargeLevel() {
        return chargeLevel;
    }

    // Setters with validation, ensures charge level stays within 0–100
    public void setChargeLevel(int chargeLevel) {
        if (chargeLevel >= 0 && chargeLevel <= 100) {
            this.chargeLevel = chargeLevel;
        } else {
            System.out.println("Invalid charge level. Must be 0–100.");
        }
    }
    
    // Drains the battery by a specified amount, ensuring it doesn't go below 0
    public void drain(int amount) {
        if (amount > 0) {
            chargeLevel -= amount;

            // Prevent negative charge
            if (chargeLevel < 0) {
                chargeLevel = 0;
            }
        }
    }

    // Fully recharges the battery
    public void charge() {
        chargeLevel = 100;
    }
}
