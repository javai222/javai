/*
 * This class represents the Brush class
 * Created by De Leon, Lord Ulrick A.
 */

package composition_lab;

public class Brush {

    private String type; // e.g. "soft", "hard"
    private String material; // e.g. "plastic", "fiber"
    private int bristleStrength; // Scale from 1–10
    private boolean isNew;        

    // Constructor
    public Brush(String type, String material, int bristleStrength, boolean isNew) {
        this.type = type;
        this.material = material;
        this.bristleStrength = bristleStrength;
        this.isNew = isNew;
    }

    // Getters & Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getBristleStrength() {
        return bristleStrength;
    }

    public void setBristleStrength(int bristleStrength) {
        if (bristleStrength >= 1 && bristleStrength <= 10) {
            this.bristleStrength = bristleStrength;
        } else {
            System.out.println("Invalid value! Must be 1-10.");
        }
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean isNew) {
        this.isNew = isNew;
    }

    // Behavior methods
    public void replace() {
        System.out.println("Replaced with a brand new brush.");
        isNew = true;
    }

    public void wearOut() {
        System.out.println("The brush has worn out.");
        isNew = false;
    }

    public void describe() {
        System.out.println("Brush Details:");
        System.out.println("Type: " + type);
        System.out.println("Material: " + material);
        System.out.println("Bristle Strength: " + bristleStrength);
        System.out.println("Is New: " + isNew);
    }

    @Override
    public String toString() {
        return "Brush{" +
                "type='" + type + '\'' +
                ", material='" + material + '\'' +
                ", bristleStrength=" + bristleStrength +
                ", isNew=" + isNew +
                '}';
    }
}
