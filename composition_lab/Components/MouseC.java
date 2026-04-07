/*
 * This class represents a Mouse object used in a composition relationship
 * Created by Rahzel Heeroe R. Conel
 */

package composition_lab;

public class MouseC {
    
    // Mouse attributes (properties of the mouse)
    private String brand;
    private String color;
    private String type;
    private boolean isConnect; // indicates if the mouse is connected or not

    // Default constructor: initializes mouse with unknown values and disconnected state
    public MouseC() {
        this.brand = "Unknown";
        this.color = "Unknown";
        this.type = "Unknown";
        this.isConnect = false;
    }

    // Parameterized constructor: sets mouse details and automatically connects it
    public MouseC(String brand, String color, String type) {
        this.brand = brand;
        this.color = color;
        this.type = type;
        this.isConnect = true;
    }

    // Getters (used to access private attributes)
    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    // Setters (used to modify private attributes)
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

    // Method to simulate mouse movement (only works if connected)
    public void typing() {
        if (isConnect)
            System.out.println(brand + " is moving.");
        else
            System.out.println("Mouse is not connected");
    }

    // Method to simulate mouse clicking (only works if connected)
    public void click() {
        if (isConnect)
            System.out.println(brand + " is clicking.");
        else
            System.out.println("Mouse is not connected");
    }

    // Method to simulate RGB lighting feature (can be overridden in subclasses)
    public void rgb() {
        if (isConnect)
            System.out.println("Mouse has RGB lighting.");
        else
            System.out.println("Mouse is not connected");
    }
}