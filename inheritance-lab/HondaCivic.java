/*
*Child class created by Mercado, Dustin Elijah C., Parent class created by Kenneth Saan
*/
public class HondaCivic extends vehicle {

    private boolean sportMode;

    // Constructor
    public HondaCivic(int horsePower, double fuel) {
        super("Honda", "Sedan", 4, horsePower, fuel);
        this.sportMode = false;
    }

    @Override
    public void start() {
    System.out.println("Honda Civic engine starts smoothly...");
    }

    // New behavior
    public void enableSportMode() {
        sportMode = true;
        System.out.println("Sport mode enabled! Faster acceleration!");
    }

    // New behavior
    public void disableSportMode() {
        sportMode = false;
        System.out.println("Sport mode disabled. Back to normal driving.");
    }

    // Override method
    @Override
    public void accelerate() {
    if (isEngine()) {
        if (sportMode) {
            System.out.println("Honda Civic accelerates rapidly in SPORT MODE!");
            setSpeed(getSpeed() + 20);
        } else {
            System.out.println("Honda Civic accelerates smoothly.");
            setSpeed(getSpeed() + 10);
        }
    } else {
        System.out.println("Engine is off");
    }
}