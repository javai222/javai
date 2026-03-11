public class ObjectDetailsPrinter {
    public static void main(String[] args) {
        /*
        * This is the object instance created from the Badminton class
        * The author of this part is Dolormente, Henry II, S.
        */
      
        // Object using default constructor
        Badminton r1 = new Badminton();

        // Object using parameterized constructor
        Badminton r2 = new Badminton("Yonex Astrox 99", "Yonex", "head heavy", "Graphite",
                                 "BG66 Ultimax", 15000, 85.0);

        // Object using overloaded constructor
        Badminton r3 = new Badminton("Li-Ning N90 III", "Li-Ning","BG80 Power");

        // Print attributes and trigger behaviors
        r1.introduceRacket();
        r2.introduceRacket();
        r3.introduceRacket();
        // Method with parameter
        r2.updateRacket("Alpsport");

        // Static method
        Badminton.displayTotalRackets();

        /*
        * This is the object instance created from the  class
        * The author of this part is Plantilla, Jophel Mark, P.
        */
      
        // Object using default constructor
        Item i1 = new Item();

        // Object using parameterized constructor
        Item i2 = new Item("Laptop", "Mark", 35000);

        // Object using overloaded constructor
        Item i3 = new Item("Keyboard", "Jophel");

        // Print attributes and trigger behaviors
        i1.displayItems();
        i2.displayItems();

        // Method with parameter
        i2.updatePrice(30000);

        // Static method
        Item.displayTotalItems();
    }
}
    }
}

// javac classes-and-objects-lab/Student.java classes-and-objects-lab/ObjectDetailsPrinter.java
// java -cp classes-and-objects-lab ObjectDetailsPrinter
