public class InheritanceKeyboard {
    
    // Keyboard properties
    private String brand;
    private String color;
    private String type;
    private int keys;
    private boolean isConnect;

    // Default constructor sets unknown properties and disconnected state
    public InheritanceKeyboard() {
        this.brand = "Unknown";
        this.color = "Unknown";
        this.type = "Unknown";
        this.keys = 0;
        this.isConnect = false;

    }

    // Parameterized constructor sets fields and ready state
    public InheritanceKeyboard(String brand, String color, String type, int keys) {
        this.brand = brand;
        this.color = color;
        this.type = type;
       if(keys > 0) {
            this.keys = keys;
        }
        else {
            this.keys = 0; // Default to 0 if invalid number of keys is provided
        }
        this.isConnect = true;
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

    // Method to simulate keyboard typing (only if connected)
    public void Typing() {
        if (isConnect){System.out.println(brand + " is typing.");}
        else {
           System.out.println("Keyboard is not connected");
        }
    }

    // Method to simulate keyboard key press (only if connected)
    public void click() {
       if (isConnect){System.out.println(brand + " is clicking.");}
       else {
        System.out.println("Keyboard is not connected");
       }
    }

    // Method to simulate keyboard RGB lighting (can override in subclass)
    public void RGB() {
        if(isConnect){System.out.println("Keyboard has rgb.");}
        else {
            System.out.println("Keyboard is not connected");
        }
    }
}