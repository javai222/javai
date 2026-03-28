public class Gadget {
    // Parent class made bt Torrefranca
    // Attributes that describe the gadget
    private String brand;
    private String model;
    private String type;
    private int batteryLevel;
    private String specialFeature;

    // Constructor for initialization
    public Gadget(String brand, String model, String type, int batteryLevel, String specialFeature) {
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.batteryLevel = batteryLevel;
        this.specialFeature = specialFeature;
    }

    // Getter methods
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public String getSpecialFeature() {
        return specialFeature;
    }

    // Displays the brand
    public void showBrand() {
        System.out.println("Brand: " + brand);
    }

    // Displays the model
    public void displayModel() {
        System.out.println("Model: " + model);
    }

    // Shows the type of gadget
    public void showType() {
        System.out.println("Type: " + type);
    }

    // Shows battery level
    public void showBattery() {
        System.out.println("Battery Level: " + batteryLevel + "%");
    }

    // This method can be overridden in child class
    public void useGadget() {
        System.out.println("Gadget is being used");
    }
}
