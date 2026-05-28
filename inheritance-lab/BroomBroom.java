/*
 * This class represents a car parent class
 * Created by Mercado, Dustin Elijah C.
 */ 
public class BroomBroom {

    private String brand;
    private String model;
    private int year;
    private String color;
    private String transmission;

    private int currentGear; // 0 = neutral, 1–6 = gears
    private boolean engineOn;

    // Constructor
    public BroomBroom(String brand, String model, int year, String color, String transmission) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.transmission = transmission;
        this.currentGear = 0; // start in neutral
        this.engineOn = false;
    }

    // Start engine
    public void startEngine() {
        engineOn = true;
        System.out.println("Engine started.");
    }

    // Stop engine
    public void stopEngine() {
        engineOn = false;
        currentGear = 0;
        System.out.println("Engine stopped. Back to neutral.");
    }

    // Shift up (1 → 6)
    public void shiftUp() {
        if (!engineOn) {
            System.out.println("Start the engine first.");
            return;
        }

        if (!transmission.equalsIgnoreCase("Manual")) {
            System.out.println("This car is not manual.");
            return;
        }

        if (currentGear < 6) {
            currentGear++;
            System.out.println("Shifted up to gear " + currentGear);
        } else {
            System.out.println("Already at max gear (6).");
        }
    }

    // Shift down (6 → 0)
    public void shiftDown() {
        if (!engineOn) {
            System.out.println("Start the engine first.");
            return;
        }

        if (!transmission.equalsIgnoreCase("Manual")) {
            System.out.println("This car is not manual.");
            return;
        }

        if (currentGear > 0) {
            currentGear--;
            if (currentGear == 0) {
                System.out.println("Shifted to neutral.");
            } else {
                System.out.println("Shifted down to gear " + currentGear);
            }
        } else {
            System.out.println("Already in neutral.");
        }
    }

    public int getCurrentGear() {
        return currentGear;
    }
}