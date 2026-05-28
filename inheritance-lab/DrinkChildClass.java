/*
*Child class created by Silva, Parent class created by Plantilla
*/

class coffee extends Drink {

// IS-A realtionship from a parent class and this child class
public coffee (String flavor, String temperature, String size, int price ) {
    super ("Black", "Hot", "Tall", 100);
}

// new behavior
public static void doubleFlavor () {
    System.out.println("This coffee can have a double flavor");
}

@Override
public void feeling () {
    System.out.println("I am feeling good baby !");
}
}

class juice extends Drink {

public juice (String flavor, String temperature, String size, int price){
        super ("American", "Cold", "Venti", 90);
    }

// new behavior
public static void doubleFlavor () {
    System.out.println("This coffee can have a double flavor");
}

@Override
public void sound () {
    System.out.println ("BRAHHHHHHH");
}
}