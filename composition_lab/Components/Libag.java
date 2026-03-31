package composition_lab.Components;

public class Libag {

    private String location;   // e.g. "leeg", "batok", "kilikili"
    private int thickness;     // scale 1–10
    private boolean matigas;   // hardened dirt
    private String color;

    // Constructor
    public Libag(String location, int thickness, boolean matigas, String color) {
        this.location = location;
        this.thickness = thickness;
        this.matigas = matigas;
        this.color = color;
    }

    // Getters & Setters
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public boolean isMatigas() {
        return matigas;
    }

    public void setMatigas(boolean matigas) {
        this.matigas = matigas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Behavior methods
    public void kuskos() {
        System.out.println("Kinukuskos ang libag... medyo satisfying 😆");
        if (thickness > 5) {
            System.out.println("Makapal! Kailangan ng extra effort.");
        } else {
            System.out.println("Madaling matanggal.");
        }
    }

    public void soak() {
        System.out.println("Binababad muna sa tubig para lumambot...");
        matigas = false;
    }

    public void describe() {
        System.out.println("Libag Details:");
        System.out.println("Location: " + location);
        System.out.println("Thickness: " + thickness);
        System.out.println("Matigas: " + matigas);
        System.out.println("Color: " + color);
    }

    @Override
    public String toString() {
        return "Libag{" +
                "location='" + location + '\'' +
                ", thickness=" + thickness +
                ", matigas=" + matigas +
                ", color='" + color + '\'' +
                '}';
    }
}