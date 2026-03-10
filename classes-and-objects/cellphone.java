class cellphone { 

String brand; 
String model; 
String OS; 

public static int phoneSales = 0; //no parameters

public cellphone () { 
this.brand = "iphone"; 
this.model = "17";
this.OS = "IOS"; 
 phoneSales++;
}

public cellphone (String n, String i, String g) { //with parameters
this.brand = n; 
this.model = i;
this.OS = g; 
 phoneSales++;
}


public cellphone (String i, String g) { //with parameters overload
this.brand = "iphone"; 
this.model = i;
this.OS = g; 
 phoneSales++;
} 

void displayItems(){
        System.out.println("Item brand: " +brand);
        System.out.println("Phone model: " +model);
        System.out.println("Phone OS: " + OS);
   }

   //Static method
        static void displayTotalSales(){
            System.out.println("Total Items: " + phoneSales);
        }
     }




}