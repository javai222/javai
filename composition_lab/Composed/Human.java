package composition_lab;
//composed creatd by Saanand components created by Sir Ramon and Cantella
// Human class using composition (has Brain and Libag objects)
public class Human {
    // Basic human data
    private String name;
    private int age;
   

    // Composed objects
    private Brain brain;
    private Libag libag;


    public Human(String name, int age, int cortisol, int iq, int sleepHours, String libagLocation, int libagThickness, boolean libagMatigas, String libagColor) {
        this.name = name;
        this.age = age;
        this.brain = new Brain(cortisol, iq, sleepHours);
        this.libag = new Libag(libagLocation, libagThickness, libagMatigas, libagColor);
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Brain getBrain() {
        return brain;
    }

    public Libag getLibag() {
        return libag;
    }

    // Behavior methods
    public void think() {
        brain.think();
    }

    public void displayBrainInfo() {
        System.out.println("  Cortisol Level: " + brain.getCortisolLevel());
        System.out.println("  IQ: " + brain.getIQ());
        System.out.println("  Sleep Hours: " + brain.getSleepHours());
    }

    public void displayLibagInfo() {
        System.out.println("  Libag Location: " + libag.getLocation());
        System.out.println("  Libag Thickness: " + libag.getThickness());
        System.out.println("  Libag Matigas: " + libag.isMatigas());
        System.out.println("  Libag Color: " + libag.getColor());
    }

    // Setters for Brain
    public void setCortisolLevel(int cortisol) {
        brain.setCortisolLevel(cortisol);
    }

    public void setIQ(int iq) {
        brain.setIQ(iq);
    }

    public void setSleepHours(int sleepHours) {
        brain.setSleepHours(sleepHours);
    }

    // Setters for Libag
    public void setLibagLocation(String location) {
        libag.setLocation(location);
    }

    public void setLibagThickness(int thickness) {
        libag.setThickness(thickness);
    }

    public void setLibagMatigas(boolean matigas) {
        libag.setMatigas(matigas);
    }

    public void setLibagColor(String color) {
        libag.setColor(color);
    }

    // Extra actions
    public void eat() {
        System.out.println(name + " is eating.");
    }
    
    public void sleep() {
        System.out.println(name + " is sleeping.");
    }
}