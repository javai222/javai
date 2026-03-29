// Composed class created by John Roque R. Mance, component created by Cantela, Plantilla, and sir.

package composition_lab;

public class computer {
    // component classes
    private Brain brain;
    private Water water;
    private Libag libag;

    // Constructor Injection
    public computer(Brain brain, Water water, Libag libag) {
        this.brain = brain;
        this.water = water;
        this.libag = libag;
    }

    // Behavior Method
    public void useComputer() {
        System.out.println("=== Computer is running ===");

        brain.process();
        water.cool();
        libag.accumulate();

        libag.brushOff();
        System.out.println("Computer is shutting down.");
    }
    public void displayComputerStatus() {
        System.out.println("=== Computer System Status ===");

        water.displayTemperature();
        libag.describe();
    }
    // Setters
    public void setBrain(Brain brain) {
        this.brain = brain;
    }
    public void setWater(Water water) {
        this.water = water;
    }
    public void setLibag(Libag libag) {
        this.libag = libag;
    }
}