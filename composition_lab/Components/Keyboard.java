/*
* This class represents the compositionKeyboard class
* Created by John Roque R. Mance
*/

package composition_lab;

public class Keyboard {
    
    // Keyboard Attributes
    private String brand;
    private String color;
    private String type;
    private boolean isConnect;

    // Default constructor sets unknown properties and disconnected state
    public compositionKeyboard() {
        this.brand = "Unknown";
        this.color = "Unknown";
        this.type = "Unknown";
        this.isConnect = false;
    }

    // Parameterized constructor sets fields and ready state
    public compositionKeyboard(String brand, String color, String type) {
        this.brand = brand;
        this.color = color;
        this.type = type;
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

    //Setters
    public void setConnection(boolean status) {
        this.isConnect = status;
    }
    
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
    public void typing() {
        if (isConnect)
            System.out.println(brand + " is typing.");
        else
            System.out.println("Keyboard is not connected");
    }

    // Method to simulate keyboard key press (only if connected)
    public void click() {
        if (isConnect)
            System.out.println(brand + " is clicking.");
        else
            System.out.println("Keyboard is not connected");
    }

    // Method to simulate keyboard RGB lighting (can override in subclass)
    public void rgb() {
        if (isConnect)
            System.out.println("Keyboard has rgb.");
        else
            System.out.println("Keyboard is not connected");
    }
}
