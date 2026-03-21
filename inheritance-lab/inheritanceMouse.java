public class inheritanceMouse {
    
    // Mouse properties
    private String brand;
    private String color;
    private String type;
    private int dpi;
    private boolean isConnect;

    // Default constructor sets unknown properties and disconnected state
    public inheritanceMouse() {
        this.brand = "Unknown";
        this.color = "Unknown";
        this.type = "Unknown";
        this.dpi = 0;
        this.isConnect = false;

    }

    // Parameterized constructor sets fields and ready state
    public inheritanceMouse(String brand, String color, String type, int dpi) {
        this.brand = brand;
        this.color = color;
        this.type = type;
       if(dpi > 0) {
            this.dpi = dpi;
        }
        else {
            this.dpi = 0; // Default to 0 if invalid DPI is provided
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

    public int getDpi() {
        return dpi;
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

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    // Method to simulate mouse moving (only if connected)
    public void move() {
        if (isConnect){System.out.println(brand + " is moving.");}
        else {
           System.out.println("Mouse is not connected");
        }
    }

    // Method to simulate mouse clicking (only if connected)
    public void click() {
       if (isConnect){System.out.println(brand + " is clicking.");}
       else {
        System.out.println("Mouse is not connected");
       }
    }

    // Method to simulate mouse scroll (can override in subclass)
    public void scroll() {
        if(isConnect){System.out.println("Mouse is scrolling.");}
        else {
            System.out.println("Mouse is not connected");
        }
    }
}