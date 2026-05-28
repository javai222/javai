/*
* This class represents four attributes for a drink, constructors, getter, and override methods.
* Created by Jophel Mark Plantilla
*/

public class Drink {

    //Attributes for a drink
    private String flavor;
    private String temperature; //Hot, Cold, Warm
    private String size;  // Tall, Grande, Venti
    private double price;

    //Default Constructor
    public Drink (){
        this.flavor = "Unknown";
        this.temperature = "Unknown";
        this.size = "Unknown";
        this.price = 0.0;
    }

    //Paramaterized Constructor
    public Drink (String flavor, String temperature, String size, double price){
        this.flavor = flavor;
        this.temperature = temperature;
        this.size = size;
        this.price = price;
    }

    // Getter methods for all attributes 
    public String getFlavor() {
        return flavor;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    //Method for serving the drink
    public void serveDrink(){
        System.out.println("Serving " + temperature + " " + size + " " + flavor + ". Enjoy your drink!");
    }

    //Method for displaying the price of drink
    public void displayPrice(){
        System.out.println(flavor + " " + size + ": Php " + price);
    }

    //OVERRIDABLE METHOD : SOUND
    public void sound() {
        System.out.println("Slurppp....."); //Sound made when sipping the drink
    }

    //OVERRIDABLE METHOD : FEELING
    public void feeling() {         
        System.out.println("I feel so refreshed!"); //Feeling after drinking the beverage
    }
}