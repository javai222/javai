/*
* Child class created by Dolormente, parent class created by Conel, Rahzel Heeroe R.
*/

public class KeyboardChildClass extends InheritanceKeyboard {

    // Child-only attributes
    private boolean hasRGB;
    private int pollingRate;

    // Default constructor
    public KeyboardChildClass() {
        super(); // calls parent constructor
        this.hasRGB = false;
        this.pollingRate = 0;
    }

    // Parameterized constructor
    public KeyboardChildClass(String brand, String color, String type, int keys,
                              boolean hasRGB, int pollingRate) {
        super(brand, color, type, keys); // call parent constructor
        this.hasRGB = hasRGB;
        this.pollingRate = pollingRate;
    }

    // Getters
    public boolean getRGB() {
        return hasRGB;
    }

    public int getPollingRate() {
        return pollingRate;
    }

    // Setters
    public void setRGB(boolean hasRGB) {
        this.hasRGB = hasRGB;
    }

    public void setPollingRate(int pollingRate) {
        this.pollingRate = pollingRate;
    }

    // Override Typing method
    @Override
    public void Typing() {
        System.out.println(getBrand() + " keyboard is being used for gaming typing.");
    }

    // New behavior
    public void gamingMode() {
        System.out.println(getBrand() + " gaming mode activated!");
    }

    // Override RGB method
    @Override
    public void RGB() {
        if (hasRGB) {
            System.out.println(getBrand() + " has RGB lighting effects.");
        } else {
            System.out.println(getBrand() + " has no RGB.");
        }
    }
}