public class GamingMouse extends inheritanceMouse {
    //This child class is made by Torrefranca, branching from the parent class of Conel
    // New attribute
    private String rgbLighting;

    // Default constructor
    public GamingMouse() {
        super();
        this.rgbLighting = "Off";
    }

    // Parameterized constructor
    public GamingMouse(String brand, String color, String type, int dpi, String rgbLighting) {
        super(brand, color, type, dpi);
        this.rgbLighting = rgbLighting;
    }

    // New behavior (required)
    public void changeLighting() {
        System.out.println("RGB lighting is set to " + rgbLighting);
    }

    // Override method (required)
    @Override
    public void scroll() {
        System.out.println("Gaming mouse scrolls smoothly with high precision.");
    }
}
