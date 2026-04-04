package abstraction;

// Abstract class
public abstract class Rizz {
    private String name;
    private int auraLevel;

// Constructor
public Rizz (String name, int auraLevel) {
    this.name = name;
    this.auraLevel = auraLevel;
}

// Getter methods
public String getName() {
    return name;
}

public int getauraLevel() {
    return auraLevel;
}

// Setter method with validation
public void setName(String name){
    if (name == null)
        System.out.println("Invalid rizzler name");
    else
        this.name = name;
}

public void setauraLevel(int auraLevel) {
    if (auraLevel < 50)
        System.out.println("Aura too low, enhance your rizzing ability");
    else
        this.auraLevel = auraLevel;
}

// Abstract method
    public abstract void showRizz();

// Concrete method
    public void displayInfo() {
        System.out.println("Rizzler: " + name);
        System.out.println("Aura level: " + auraLevel);
    }



}