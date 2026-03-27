public class KeyboardChildClass {
    
    // Keyboard properties
    private String brand;
    private String color;
    private String type;
    private int keys;
    private boolean isConnect;
    private boolean hasRGB;
    private int pollingRate;

    // Default constructor
    public KeyboardChildClass() {
        super(); // calls parent constructor
        this.hasRGB = false;
        this.pollingRate = 0;
    }

    // Parameterized constructor
    public KeyboardChildClass(String brand, String color, String type, int keys,
                          boolean hasRGB, int pollingRate) {
        super(brand, color, type, keys); // call parent constructor
        this.hasRGB = hasRGB;
        this.pollingRate = pollingRate;
    }


    //Getters
     public String getBrand() {
        return brand;
    }
    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public int getKeys() {
        return keys;
    }

    public boolean getRGB() {
        return hasRGB;
    }

    public int getPollingRate() {
        return pollingRate;
    }

    //Setters
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setKeys(int keys) {
        this.keys = keys;
    }

    public void setRGB(boolean hasRGB) {
        this.hasRGB = hasRGB;
    }

    public void setPollingRate(int pollingRate) {
        this.pollingRate = pollingRate;
    }

    // Method to simulate keyboard typing (only if connected)
    public void Typing() {
        if (isConnect){System.out.println(brand + "is getting pressed.");}
        else {
           System.out.println("Keyboard is not connected");
        }
    }

    // New behavior gaming mode
    public void gamingMode() {
        System.out.println(getBrand() + " gaming mode activated!");
    }

    // Method to simulate keyboard RGB lighting (can override in subclass)
    public void RGB() {
        if(isConnect){System.out.println("Keyboard has many light effects");}
        else {
            System.out.println("Keyboard isn't connected to anything");
        }
    }
}