/* 
 * This Composed Class was created by De leon, Lord Ulrick A.
 * The Component classes were created by Dolormente(HDLotion), Silva(Soap), and sir Capunpon(Libag)
 * This was created with the help of AI
 */

package composition_lab;

public class CleaningSession {

    //Attributes
    private HDLotion lotion;
    private Soap soap;
    private Libag libag;

    // Constructor Injection
    public CleaningSession(HDLotion lotion, Soap soap, Libag libag) {
        this.lotion = lotion;
        this.soap = soap;
        this.libag = libag;
    }

    // Getters and Setters
    public HDLotion getLotion() {
        return lotion;
    }

    public Soap getSoap() {
        return soap;
    }

    public Libag getLibag() {
        return libag;
    }

    public void setLotion(HDLotion lotion) {
        this.lotion = lotion;
    }

    public void setSoap(Soap soap) {
        this.soap = soap;
    }

    public void setLibag(Libag libag) {
        this.libag = libag;
    }

    // Behavior Methods 
    public void startCleaning() {
        System.out.println("=== Cleaning Session Started ===");

        // Show Details
        lotion.displayLotion();
        libag.describe();
        soap.showDetails();

        // Cleaning Process
        System.out.println("\nStep 1: Soaking...");
        libag.soak();

        System.out.println("\nStep 2: Applying soap...");
        soap.useSoap();

        System.out.println("\nStep 3: Scrubbing...");
        libag.kuskos();

        System.out.println("\nStep 4: Applying lotion...");
        lotion.lotionOpen();
        System.out.println("Applying lotion for moisture...");
        lotion.lotionClose();

        System.out.println("\n=== Cleaning Finished ===");
    }

    public void showSummary() {
        System.out.println("\n=== Session Summary ===");
        System.out.println(libag.toString());
        System.out.println("Lotion Moisture Level: " + lotion.getMoistureLevel());
    }
}