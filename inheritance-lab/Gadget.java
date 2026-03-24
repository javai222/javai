class Gadget {
    // This class is made by Torrefranca
    // Attributes
    private String brand;
    private String model;
    private int batteryLevel;

    // Default constructor
    public Gadget() {
        brand = "Unknown";
        model = "Unknown";
        batteryLevel = 0;
    }

    // Parameterized constructor
    public Gadget(String brand, String model, int batteryLevel) {
        this.brand = brand;
        this.model = model;
        this.batteryLevel = batteryLevel;
    }

    // Behaviors
    public void powerOn() {
        System.out.println("Gadget is powering on");
    }

    public void powerOff() {
        System.out.println("Gadget is shutting down");
    }

    // Method that can be overridden
    public void use() {
        System.out.println("Gadget is being used");
    }

    // Getter
    public String getBrand() {
        return brand;
    }
}
