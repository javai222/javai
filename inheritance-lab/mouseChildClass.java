// Child class that inherits from inheritanceMouse
public class razer extends inheritanceMouse {

    // Additional attributes
    private boolean hasRGB;
    private int buttonCount;

    // Default constructor
    public GamingMouse() {
        super(); // calls parent default constructor
        this.hasRGB = false;
        this.buttonCount = 0;
    }

    // Parameterized constructor
    public GamingMouse(String brand, String color, String type, int dpi,
                       boolean hasRGB, int buttonCount) {
        super(brand, color, type, dpi); // calls parent constructor
        this.hasRGB = hasRGB;
        this.buttonCount = buttonCount;
    }

    // Getters
    public boolean getHasRGB() {
        return hasRGB;
    }

    public int getButtonCount() {
        return buttonCount;
    }

    // Setters
    public void setHasRGB(boolean hasRGB) {
        this.hasRGB = hasRGB;
    }

    public void setButtonCount(int buttonCount) {
        this.buttonCount = buttonCount;
    }

    // Overriding the scroll method
    @Override
    public void scroll() {
        System.out.println(getBrand() + " gaming mouse is scrolling smoothly.");
    }

    // New behavior specific to GamingMouse
    public void changeRGB() {
        if (hasRGB) {
            System.out.println(getBrand() + " RGB lights are changing colors.");
        } else {
            System.out.println("This gaming mouse has no RGB.");
        }
    }
}