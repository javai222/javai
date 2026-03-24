/*
* This class represents the compositionKeyboard class
* Created by John Roque R. Mance
*/

public class compositionKeyboard {
    
    // Keyboard Attributes
    private String brand;
    private String color;
    private String type;

    // Default constructor sets unknown properties and disconnected state
    public InheritanceKeyboard() {
        this.brand = "Unknown";
        this.color = "Unknown";
        this.type = "Unknown";

    }

    // Parameterized constructor sets fields and ready state
    public InheritanceKeyboard(String brand, String color, String type, int keys) {
        this.brand = brand;
        this.color = color;
        this.type = type;
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