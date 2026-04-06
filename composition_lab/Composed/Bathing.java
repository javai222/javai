//Composed class created by Casapao, component created by Sir, Plantilla, Silva

package composition_lab;

public class Bathing {

    private Soap soap;
    private Water water;
    private Libag libag;

    // Constructor Injection
    public Bathing(Soap soap, Water water, Libag libag) {
        this.soap = soap;
        this.water = water;
        this.libag = libag;
    }
    // Behavior
    public void startBathing() {
        System.out.println("======STARTING BATHING======");
        
        water.pour();
        soap.showDetails();

        libag.soak();
        libag.kuskos();

        soap.useSoap();

        System.out.println("Bathing is completed!");

    }
    public void displayStatus() {
        System.out.println("======BATHING STATUS======");
        water.display();
        libag.describe();
    }
    // Setters
    public void setSoap(Soap soap) {
        this.soap = soap;
    }
    public void setWater(Water water) {
        this.water = water;
    }
    public void setLibag(Libag libag) {
        this.libag = libag;
    }
}
