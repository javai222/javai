public class Keyboard {

// class craeated by Mance, John Roque R.
// this class is for keyboardSales with basic attributes
    String brand;
    String color;
    String type;

    public static int keyboardSales = 0;

    public Keyboard () {
        this.brand = "Reddragon";
        this.color = "white";
        this.type = "mechanical";

        keyboardSales++;
    }

    public Keyboard (String p, String e, String i) { // with parameters
        this.brand = p;
        this.color = e;
        this.type = i;

        keyboardSales++;
    }

    public Keyboard (String e, String i) { // with parameters overload
        this.brand = "Reddragon";
        this.color = e;
        this.type = i;

        keyboardSales++;
    }

    //Behavior without parameters
    void displayItems(){
        System.out.println("keyboard brand: " +brand);
        System.out.println("Keyboard color: " +color);
        System.out.println("Keyboard type: " +type);
    }

    //Static method
    static void displayTotalSales(){
        System.out.println("Total Items: " +keyboardSales);
    }
}
