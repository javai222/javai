/*
 * This class represents a Mouse with attributes such as brand,
 * color, and type. It demonstrates encapsulation by keeping the
 * attributes private and accessing them through getters and setters.
 * Created by Rahzel Heeroe R. Conel
 */


public class Mouse {

    // Private attributes (Encapsulation)
    private String brand;
    private String color;
    private String type;

    // Static attribute
    private static int mouseSales = 0; 

    // Constructor without parameters
    public Mouse() {
        this.brand = "razer";
        this.color = "black";
        this.type = "wireless";
        mouseSales++;
    }

    // Constructor with parameters
    public Mouse(String b, String c, String t) {

        if(b != null && !b.isEmpty()){
            this.brand = b;
        } else {
            this.brand = "razer";
        }

        if(c != null && !c.isEmpty()){
            this.color = c;
        } else {
            this.color = "black";
        }

        if(t != null && !t.isEmpty()){
            this.type = t;
        } else {
            this.type = "wireless";
        }

        mouseSales++;
    }

    // Constructor overload
    public Mouse(String c, String t) {
        this.brand = "razer";

        if(c != null && !c.isEmpty()){
            this.color = c;
        } else {
            this.color = "black";
        }

        if(t != null && !t.isEmpty()){
            this.type = t;
        } else {
            this.type = "wireless";
        }

        mouseSales++;
    }

    // Getters
    public String getBrand(){
        return brand;
    }

    public String getColor(){
        return color;
    }

    public String getType(){
        return type;
    }

    // Setters with validation
    public void setBrand(String brand){
        if(brand != null && !brand.isEmpty()){
            this.brand = brand;
        } else {
            System.out.println("Invalid brand.");
        }
    }

    public void setColor(String color){
        if(color != null && !color.isEmpty()){
            this.color = color;
        } else {
            System.out.println("Invalid color.");
        }
    }

    public void setType(String type){
        if(type != null && !type.isEmpty()){
            this.type = type;
        } else {
            System.out.println("Invalid type.");
        }
    }

    // Behavior without parameters
    public void displayItems(){
        System.out.println("Mouse Brand: " + brand);
        System.out.println("Mouse Color: " + color);
        System.out.println("Mouse Type: " + type);
    }

    // Static method
    public static void displayTotalSales(){
        System.out.println("Total Items Sold: " + mouseSales);
    }
    
    public static void main(String[] args) {

        // Creating objects
        Mouse mouse1 = new Mouse();
        Mouse mouse2 = new Mouse("Logitech", "White", "Wired");
        Mouse mouse3 = new Mouse("Red", "Wireless");

        // Display items
        mouse1.displayItems();
        System.out.println();

        mouse2.displayItems();
        System.out.println();

        mouse3.displayItems();
        System.out.println();

        // Using setters (with validation)
        mouse1.setBrand("SteelSeries");
        mouse1.setColor("Blue");

        System.out.println("Updated Mouse 1:");
        mouse1.displayItems();
        System.out.println();

        // Testing invalid input
        mouse2.setBrand("");   // invalid brand
        mouse2.setColor("");   // invalid color

        // Display total sales
        Mouse.displayTotalSales();
    }
}
