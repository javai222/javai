//this class is created by kenneth Saan 

public class Processor {
    String CPU;
    String Brand;
    String Model;

    public static int coreCount = 0;

    // Constructor without parameters
    Processor() {
        this.CPU = "Unknown";
        this.Brand = "Unknown";
        this.Model = "Unknown";

        coreCount++;
    }

    // Constructor with parameters
    Processor(String CPU, String Brand, String Model) {
        this.CPU = CPU;
        this.Brand = Brand;
        this.Model = Model;

        coreCount++;
    }
     Processor(String Brand, String Model) {
        this.CPU = "Octa-Core";
        this.Brand = Brand;
        this.Model = Model;

        coreCount++;
    }

    // Behavior: display processor information
    void displayInfo() {
        System.out.println("CPU Type: " + CPU);
        System.out.println("Brand: " + Brand);
        System.out.println("Model: " + Model);
    }

    // Behavior: display total processors created
    static void displayCoreCount() {
        System.out.println("Total Processor Objects Created: " + coreCount);
    }

}
