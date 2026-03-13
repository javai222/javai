import java.util.Scanner;
public class Main_CantelaBankSorcerer {
    public static void main (String[] args) {
//This test or class is created by (Cantela), the bank object (Saan), Sorcerer object (Javier)         

        Scanner in = new Scanner(System.in);

        System.out.println("========== SORCERER CLASS STRESS TEST ==========\n");

        // TEST 1: Default Constructor
        System.out.println("TEST 1: Default Constructor");
        sorcerer s1 = new sorcerer();
        s1.displayStatus();

        // TEST 2: Parameterized Constructor
        System.out.println("\nTEST 2: Parameterized Constructor");
        sorcerer s2 = new sorcerer("Gojo", 500, 95, 100, 180);
        s2.displayStatus();

        // TEST 3: Multiple Objects
        System.out.println("\nTEST 3: Multiple Object Creation");

        sorcerer s3 = new sorcerer("Yuji", 150, 85, 80, 90);
        sorcerer s4 = new sorcerer("Megumi", 130, 70, 85, 120);

        s3.displayStatus();
        s4.displayStatus();

        // TEST 4: Setter Methods (Valid)
        System.out.println("\nTEST 4: Valid Setter Inputs");

        s2.setName("Satoru Gojo");
        s2.setCursedEnergy(300);
        s2.setSpeed(100);
        s2.setDurability(200);
        s2.setIq(190);
        s2.updateSchool("Tokyo Jujutsu High");

        s2.displayStatus();

        // TEST 5: Invalid Setter Inputs
        System.out.println("\nTEST 5: Invalid Setter Inputs");

        s2.setCursedEnergy(-50);
        s2.setSpeed(150);
        s2.setDurability(-10);
        s2.setIq(300);
        s2.setName("");
        s2.updateSchool("");

        // TEST 6: Null Values
        System.out.println("\nTEST 6: Null Input Tests");

        s2.setName(null);
        s2.updateSchool(null);

        // TEST 7: Boundary Testing
        System.out.println("\nTEST 7: Boundary Values");

        s2.setSpeed(0);
        s2.setSpeed(100);

        s2.setIq(0);
        s2.setIq(200);

        s2.displayStatus();

        // TEST 8: Extreme Numbers
        System.out.println("\nTEST 8: Extreme Number Test");

        s2.setCursedEnergy(Integer.MAX_VALUE);
        s2.setDurability(Integer.MAX_VALUE);

        s2.displayStatus();

        // TEST 9: Getter Methods
        System.out.println("\nTEST 9: Getter Methods");

        System.out.println("Name: " + s2.getName());
        System.out.println("Cursed Energy: " + s2.getCursedEnergy());
        System.out.println("Speed: " + s2.getSpeed());
        System.out.println("Durability: " + s2.getDurability());
        System.out.println("IQ: " + s2.getIq());
        System.out.println("School: " + s2.getSchool());

        // TEST 10: User Input Stress Test
        System.out.println("\nTEST 10: Manual Input Test");

        try {
            System.out.print("Enter cursed energy (try typing letters): ");
            int energy = in.nextInt();
            s1.setCursedEnergy(energy);
        } catch (Exception e) {
            System.out.println("Program crashed due to invalid integer input.");
        }

        try {
            System.out.print("Enter speed (try typing letters): ");
            int speed = in.nextInt();
            s1.setSpeed(speed);
        } catch (Exception e) {
            System.out.println("Program crashed due to invalid integer input.");
        }



   System.out.println("===== BANK CLASS TESTING START =====\n");

        // TEST 1: Default Constructor
        System.out.println("TEST 1: Default Constructor");
        bank b1 = new bank();
        System.out.println("Name: " + b1.getName());
        System.out.println("Username: " + b1.getUserName());
        System.out.println("Password: " + b1.getPassWord());
        System.out.println("Cash: " + b1.getCash());

        // TEST 2: Valid Constructor
        System.out.println("\nTEST 2: Valid Constructor");
        bank b2 = new bank("Alice", "alice123", "securePass1", 500);
        System.out.println("Name: " + b2.getName());
        System.out.println("Username: " + b2.getUserName());
        System.out.println("Password: " + b2.getPassWord());
        System.out.println("Cash: " + b2.getCash());

        // TEST 3: Short Password
        System.out.println("\nTEST 3: Short Password");
        bank b3 = new bank("Bob", "bobUser", "123", 200);
        System.out.println("Password after validation: " + b3.getPassWord());

        // TEST 4: Negative Cash
        System.out.println("\nTEST 4: Negative Cash");
        bank b4 = new bank("Charlie", "charlieUser", "password123", -100);
        System.out.println("Cash after validation: " + b4.getCash());

        // TEST 5: Large Cash Value
        System.out.println("\nTEST 5: Large Cash Value");
        bank b5 = new bank("RichGuy", "richUser", "verysecurepass", Integer.MAX_VALUE);
        System.out.println("Cash stored: " + b5.getCash());

        // TEST 6: Empty Strings
        System.out.println("\nTEST 6: Empty String Inputs");
        bank b6 = new bank("", "", "12345678", 100);
        System.out.println("Name: '" + b6.getName() + "'");
        System.out.println("Username: '" + b6.getUserName() + "'");

        // TEST 7: Null Inputs (Possible crash test)
        System.out.println("\nTEST 7: Null Input Test");

        try {
            bank b7 = new bank(null, null, null, 100);
            System.out.println("Name: " + b7.getName());
        } catch (Exception e) {
            System.out.println("Program crashed due to null values.");
        }

        // TEST 8: Password Setter
        System.out.println("\nTEST 8: Password Setter");

        b2.setPassWord("newpassword123");
        System.out.println("Updated password: " + b2.getPassWord());

        // TEST 9: Setting Weak Password
        System.out.println("\nTEST 9: Weak Password via Setter");

        b2.setPassWord("123");
        System.out.println("Password after weak set: " + b2.getPassWord());

        // TEST 10: Multiple Objects Test
        System.out.println("\nTEST 10: Multiple Object Creation");

        bank b8 = new bank("User1", "u1", "password111", 100);
        bank b9 = new bank("User2", "u2", "password222", 200);
        bank b10 = new bank("User3", "u3", "password333", 300);

        System.out.println("User1 Cash: " + b8.getCash());
        System.out.println("User2 Cash: " + b9.getCash());
        System.out.println("User3 Cash: " + b10.getCash());

        // TEST 11: Static Variable Test
        System.out.println("\nTEST 11: Total Accounts Created");
        System.out.println("Total Accounts: " + bank.totalAccounts);

        // TEST 12: Extreme Password Length
        System.out.println("\nTEST 12: Extremely Long Password");

        String longPassword = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        bank b11 = new bank("LongPass", "longUser", longPassword, 100);
        System.out.println("Password stored: " + b11.getPassWord());

        System.out.println("\n===== BANK CLASS TESTING FINISHED =====");
    }
}
