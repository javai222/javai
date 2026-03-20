public class Chocolate {
/*
* This class represents a chocolate parent class
* Created by Yvette Germaine Tismo
*/
    //attributes that describe the chocolate
    private String flavor;
    private String type;
    private String shape;

    //default constructor
    public Chocolate() {
        this.flavor = "unknown";
        this.type = "unknown";
        this.shape = "unknown";
    }
    
    //parameterized constructor
    public Chocolate(String flavor, String type, String shape) {
        this.flavor = flavor;
        this.type = type;
        this.shape = shape;
    }

    //getters for the attributes
    public String getFlavor() {
        return flavor;
    }

    public String getType() {
        return type;
    }

    public String getShape() {
        return shape;
    }

    //methods that describe the behavior of the chocolate
    public void melt() {
        System.out.println("The " + flavor + " flavored " + shape + " " + type + " chocolate is melting.");
    }

    public void freeze() {
        System.out.println("The " + flavor + " flavored " + shape + " " + type + " chocolate is freezing.");
    }

    public void eat() {
        System.out.println("You are eating the " + flavor + " flavored " + shape + " " + type + " chocolate.");
    }

    //this method can be overridden in child classes
    public void packaging() {
        System.out.println("The chocolate is packed in a box.");
    }
}
