/*
* This class represents a Jujutsu Sorcerer
* Created by Charles Justin Javier
*/

public class sorcerer {

    // All attributes are private
    private int cursedEnergy;
    private int speed;
    private int durability;
    private int iq;
    private String name;
    private String school;

    // Static attribute shared by all
    private static String jujutsuStudent;

    // Default Constructor
    public sorcerer() {
        name = "Haru";
        cursedEnergy = 10;
        speed = 10;
        durability = 10;
        iq = 10;
        school = "Unknown";
    }

    // Parameterized Constructor
    public sorcerer(String name, int cursedEnergy, int speed, int durability, int iq) {
        school = "Unknown";
        setName(name);
        setCursedEnergy(cursedEnergy);
        setSpeed(speed);
        setDurability(durability);
        setIq(iq);
    }

    // GETTERS
    public String getName() {
        return name;
    }

    public int getCursedEnergy() {
        return cursedEnergy;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDurability() {
        return durability;
    }

    public int getIq() {
        return iq;
    }

    public String getSchool() {
        return school;
    }

    // SETTERS with validation

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Name cannot be empty.");
        } else {
            this.name = name;
        }
    }

    public void setCursedEnergy(int cursedEnergy) {
        if (cursedEnergy < 0) {
            System.out.println("Cursed Energy cannot be negative.");
        } else {
            this.cursedEnergy = cursedEnergy;
        }
    }

    public void setSpeed(int speed) {
        if (speed < 0 || speed > 100) {
            System.out.println("Speed must be between 0 and 100.");
        } else {
            this.speed = speed;
        }
    }

    public void setDurability(int durability) {
        if (durability < 0) {
            System.out.println("Durability cannot be negative.");
        } else {
            this.durability = durability;
        }
    }

    public void setIq(int iq) {
        if (iq < 0 || iq > 200) {
            System.out.println("IQ must be between 0 and 200.");
        } else {
            this.iq = iq;
        }
    }

    // Behavior method
    public void updateSchool(String school) {
        if (school == null || school.isEmpty()) {
            System.out.println("School name cannot be empty.");
        } else {
            this.school = school;
        }
    }

    // Display method
    public void displayStatus() {
        System.out.println("===== Jujutsu Sorcerer =====");
        System.out.println("Name: " + name);
        System.out.println("Cursed Energy: " + cursedEnergy);
        System.out.println("Speed: " + speed);
        System.out.println("Durability: " + durability);
        System.out.println("IQ: " + iq);
        System.out.println("School: " + school);
    }

    public static void demo() {
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