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
        setBrand(brand);
        setColor(color);
        setType(type);
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

    public boolean isConnected() {
        return isConnect;
    }

    // Setters with validation

    // Setter for connection
    public void setConnection(boolean status) {
        this.isConnect = status;
    }

    // Setter for brand (must not be null or empty)
    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            System.out.println("Invalid brand. Setting to 'Unknown'.");
            this.brand = "Unknown";
        } else {
            this.brand = brand;
        }
    }

    // Setter for color (must not be null or empty)
    public void setColor(String color) {
        if (color == null || color.trim().isEmpty()) {
            System.out.println("Invalid color. Setting to 'Unknown'.");
            this.color = "Unknown";
        } else {
            this.color = color;
        }
    }

    // Setter for type (must be wired or wireless)
    public void setType(String type) {
        if (type == null || type.trim().isEmpty()) {
            System.out.println("Invalid type. Setting to 'Unknown'.");
            this.type = "Unknown";
            return;
        }

        type = type.toLowerCase();

        if (type.equals("wired") || type.equals("wireless")) {
            this.type = type;
        } else {
            System.out.println("Invalid type. Must be 'wired' or 'wireless'. Setting to 'Unknown'.");
            this.type = "Unknown";
        }
    }

    // Method to simulate mouse movement (only works if connected)
    public void typing() {
        if (isConnect)
            System.out.println(brand + " mouse is moving.");
        else
            System.out.println("Mouse is not connected");
    }

    // Method to simulate mouse clicking (only works if connected)
    public void click() {
        if (isConnect)
            System.out.println(brand + " mouse is clicking.");
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