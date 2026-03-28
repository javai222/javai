//This class is created by Balanon
//With the help of AI

package composition_lab;

public class Backpack {

    // Private attributes
    private double capacity;
    private double load;
    private int compartments;

    // Constructor
    public Backpack(double capacity, int compartments) {
        this.capacity = capacity;
        this.compartments = compartments;
        this.load = 0;
    }

    // Getter for capacity
    public double getCapacity() {
        return capacity;
    }

    // Setter for capacity (with validation)
    public void setCapacity(double capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
        } else {
            System.out.println("Invalid capacity");
        }
    }

    // Getter for load
    public double getLoad() {
        return load;
    }

    // Setter for load
    public void setLoad(double load) {
        if (load >= 0 && load <= capacity) {
            this.load = load;
        } else {
            System.out.println("Invalid load");
        }
    }

    // Getter for compartments
    public int getCompartments() {
        return compartments;
    }

    // Setter for compartments
    public void setCompartments(int compartments) {
        if (compartments > 0) {
            this.compartments = compartments;
        } else {
            System.out.println("Invalid number");
        }
    }

    // Method 1: add item
    public void addItem(double weight) {
        if (load + weight <= capacity) {
            load = load + weight;
            System.out.println("Item added");
        } else {
            System.out.println("Too heavy");
        }
    }

    // Method 2: remove item
    public void removeItem(double weight) {
        if (weight <= load) {
            load = load - weight;
            System.out.println("Item removed");
        } else {
            System.out.println("Not enough load");
        }
    }
}
