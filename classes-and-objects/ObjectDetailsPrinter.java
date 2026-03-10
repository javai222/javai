public class ObjectDetailsPrinter {
    public static void main(String[] args) {
        // This is the object instance created from the Student class
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
    }
}

// javac classes-and-objects-lab/Student.java classes-and-objects-lab/ObjectDetailsPrinter.java
// java -cp classes-and-objects-lab ObjectDetailsPrinter