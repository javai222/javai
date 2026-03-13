public class printstatus {
    public static void main(String[] args) {

        // Create sorcerer object
        sorcerer s1 = new sorcerer("Kozth", 120, 80, 90, 110);

        // Update school
        s1.updateSchool("Calamba Jujutsu High");

        // Display stats
        s1.displayStatus();

        // Try validation
        s1.setCursedEnergy(-50);   
        s1.setSpeed(150);          
    }
}