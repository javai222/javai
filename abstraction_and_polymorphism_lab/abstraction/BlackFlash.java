package abstraction;
 
public abstract class BlackFlash{

    private String user;
    private double timingAccuracy;

    public BlackFlash(String user, double timingAccuracy) {
        this.user = user;
        this.timingAccuracy = timingAccuracy;
    }

    public String getUser(){
        return user;
    }

    public double getTimingAccuracy() {
        return timingAccuracy;
    }

    public void setTimingAccuracy(double timingAccuracy){
        if(timingAccuracy >= 0 && timingAccuracy <= 1) {
            this.timingAccuracy = timingAccuracy;
        } else {
            System.out.println("Invalid timing accuracy. Must be between 0 and 1.");
        }
    }

    //Abstract method
    public abstract void executeBlackFlash();
    public abstract void executeBlackFlash(int combo);

    //Concrete method 
    public void focusEnergy() {
        System.out.println(user + " is focusing cursed energy within 0.000001 seconds...");
    }

    public void checkTiming() {
        if (timingAccuracy >=0.9) {
            System.out.println(user + " has PERFECT timing!.");
        } else if (timingAccuracy >= 0.5) {
            System.out.println(user + " has decent timing.");
        } else {
            System.out.println(user + " struggles to land Black Flash.");
        }
    }

    public void displayStats() {
        System.out.println("User: " + user);
        System.out.println("Timing Accuracy: " + timingAccuracy);
    }

}