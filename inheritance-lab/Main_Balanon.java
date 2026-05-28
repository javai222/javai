 // This child class is created by R.Balanon for K.Saan Parent class
 /*
     * WHAT IS THE IS-A RELATIONSHIP IN YOUR PROGRAM?
     * A Motorcycle IS-A vehicle.
     */

    /*
     * WHICH METHOD WAS OVERRIDDEN?
     * The honk() method was overridden in the Motorcycle class.
     */

    /*
     * WHAT HAPPENS DURING DYNAMIC BINDING?
     * When a Motorcycle object is referenced as a vehicle,
     * the overridden method (honk) in Motorcycle will execute
     * instead of the vehicle version. The method call is resolved at runtime.
     */

    /*
     * WHAT METHODS WERE INHERITED FROM THE PARENT CLASS?
     * start(), stop(), accelerate(), honk() (before overriding),
     * and all getters and setters were inherited from vehicle.
     */

    /*
     * WHAT NEW BEHAVIOR DID THE SUBCLASS INTRODUCE?
     * The doWheelie() method.
     */

class Motorcycle extends vehicle {

    private boolean hasSidecar;

    // Constructor
    public Motorcycle(String brand, String type, int wheels, int horsePower, double fuel, boolean hasSidecar) {
        super(brand, type, wheels, horsePower, fuel);
        this.hasSidecar = hasSidecar;
    }

    // Getter
    public boolean hasSidecar() {
        return hasSidecar;
    }

    // Setter
    public void setSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }

    // New behavior
    public void doWheelie() {
        System.out.println("Motorcycle is doing a wheelie!");
    }

    // Overridden method
    @Override
    public void honk() {
        System.out.println("Motorcycle honks: Meep meep!");
    }
}

public class Main_Balanon {
    public static void main(String[] args) {
        // Create a Motorcycle instance (IS-A relationship: Motorcycle IS-A vehicle)
        Motorcycle moto1 = new Motorcycle("Harley-Davidson", "Cruiser", 2, 60, 5.0, false);
        
        // Test inherited methods from vehicle parent class
        System.out.println("--- Testing Inherited Methods ---");
        System.out.println("Brand: " + moto1.getBrand());
        System.out.println("Type: " + moto1.getType());
        System.out.println("Wheels: " + moto1.getWheels());
        System.out.println("Horse Power: " + moto1.getHorsePower());
        System.out.println("Fuel: " + moto1.getFuel());
        
        // Test overridden method
        System.out.println("\n--- Testing Overridden Method ---");
        moto1.honk();
        
        // Test new behavior
        System.out.println("\n--- Testing New Behavior ---");
        moto1.doWheelie();
        
        // Test getters/setters for new field
        System.out.println("\n--- Testing New Field ---");
        System.out.println("Has Sidecar: " + moto1.hasSidecar());
        moto1.setSidecar(true);
        System.out.println("Has Sidecar (after setting): " + moto1.hasSidecar());
        
        // Dynamic Binding demonstration
        System.out.println("\n--- Dynamic Binding ---");
        vehicle myVehicle = new Motorcycle("Honda", "Sport Bike", 2, 120, 4.5, false);
        myVehicle.honk();  // Calls overridden method in Motorcycle at runtime
    }
}
