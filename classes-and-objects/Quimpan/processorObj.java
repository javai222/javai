/**
* Object created by Quimpan, Class created by Saan
*
*/

public class processorObj {
    public static void main(String[] args) {

        // Create an processor object with complete information
        Processor proc1 = new Processor("Ryzen", "AMD", "3");
        // Create an processor object with only account name and owner
        Processor proc2 = new Processor("Intel", "Core i9");
        // Create a processor object using the default constructor
        Processor proc3 = new Processor();
      
        // Print attributes and trigger behaviors


      
        System.out.println("\n--- Processor Information ---");
        proc1.displayInfo(); // Call the method without parameters
        proc2.updateModel("Core i7"); // Method with parameter
        
        // Display the total number of processor objects created
        // printing static attribute
        System.out.println("\n--- Total Processors ---");
        Processor.displayCoreCount();
    }
}