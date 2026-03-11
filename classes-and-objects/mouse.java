public class mouse {

String brand;
String color;
String type;

public static int mouseSales = 0; 

public mouse () { //no parameters
this.brand = "razer";
this.color = "black";
this.typo = "wireless";

mouseSales++;
}

public mouse (String b, String c, String t) { //with parameters
this.brand = b;
this.color = c;
this.typo = t;

mouseSales++;
}
public mouse (String c, String t) { //with parameter overload
this.brand = "razer";
this.color = c;
this.typo = t;

mouseSales++;
}
   //Behavior without parameters
   void displayItems(){
        System.out.println("Mouse Brand: " +brand);
        System.out.println("Mouse Color: " +color);
        System.out.println("Mouse Type: " +type);
   }

   //Static method
        static void displayTotalSales(){
            System.out.println("Total Items: " + mouseSales);
        }
}