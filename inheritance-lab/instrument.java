public class instrument {
/*
 * This class represents an instrument parent class
 * created by Lord Ulrick A. De Leon
 */
    // Private Attributes
    private String name;
    private String type;
    private String material;

    // Default Constructor
    public instrument() {
        name = "Unknown";
        type = "Unknown";
        material = "Unknown";
    }

    // Parameterized Constructor
    public instrument(String name, String type, String material) {
        this.name = name;
        this.type = type;
        this.material = material;
    }

    // Behavior Methods
    public void play() {
        System.out.println(name + " is being played.");
    }

    public void tune() {
        System.out.println(name + " is being tuned.");
    }

    public void clean() {
        System.out.println(name + " is being cleaned.");
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getMaterial() {
        return material;
    }

    // Method to be Overridden
    public void sound() {
        System.out.println("This instrument produces a pleasant sound.");
    }
}