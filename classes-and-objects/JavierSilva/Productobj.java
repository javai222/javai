public class Productobj {
    public static void main(String[] args) {

        // Object created by Silva, Class created by Javier

        // Creating an product object using default constructor
        product p1 = new product();

        // Creating object using parameterized constructor
        product p2 = new product("Nike", "Large", "Polo Shirt");

        // Creating object using overloaded constructor
        product p3 = new product("Adidas", "Hoodie");

        // Calling methods
        p1.displayDetails();
        System.out.println();

        p2.displayDetails();
        System.out.println();

        p3.displayDetails();
        System.out.println();

        // Updating size of product with parameters
        p2.updateSize("Extra Large");

        // Using static variable and method
        product.shirt = "Cotton Shirt";
        product.displayShirt();
    }
}