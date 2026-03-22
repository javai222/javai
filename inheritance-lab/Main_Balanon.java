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
