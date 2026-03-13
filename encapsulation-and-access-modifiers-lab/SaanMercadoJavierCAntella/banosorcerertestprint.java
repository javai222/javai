//this obj is created by Saan and class created by Mercado and Javier
//this obj is assisted with Ai
/*
 * This class is for testing Sorcerer and ValorantAccount
 */

public class banosorcerertestprint {

    public static void main(String[] args) {

        // Create Sorcerer object
        sorcerer s1 = new sorcerer("Kozth", 120, 80, 90, 110);
        s1.updateSchool("Calamba Jujutsu High");

        // Create ValorantAccount object
        ValorantAccount v1 = new ValorantAccount(
                "KozthPlayer",
                "Kozth#1234",
                "secure123",
                1500,
                25,
                "Gold",
                true
        );

        // Display Sorcerer information
        System.out.println("=== Sorcerer Test ===");
        s1.displayStatus();

        // Display Valorant Account information
        System.out.println("\n=== Valorant Account Test ===");
        System.out.println("Username: " + v1.getUserName());
        System.out.println("Valorant ID: " + v1.getValorantID());
        System.out.println("Valorant Points: " + v1.getValorantPoints());

        // Call behaviors
        s1.setSpeed(95);
        s1.setIq(140);

        v1.setValorantPoints(2000);
        v1.setPassWord("newpass123");

        // Test invalid inputs
        System.out.println("\n=== Validation Test ===");

        s1.setSpeed(200);          // invalid
        s1.setCursedEnergy(-10);   // invalid

        v1.setValorantPoints(-500); // invalid
        v1.setUserName("");         // invalid

        // Static behavior
        System.out.println("\nTotal Valorant Accounts Created: " + ValorantAccount.getAccountCount());
    }
}