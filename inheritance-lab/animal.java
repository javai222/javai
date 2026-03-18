/*
* This class represents an animal parent class
* Created by Charles Justin Javier
*/

public class animal {
    
    // Attributes (variables) that describe the animal
    private String name;
    private String classification;
    private String type;

    // Constructor - used to initialize the object when created
    public animal(String name, String classification, String type) {
        this.name = name;               // sets the animal's name
        this.classification = classification; // sets classification (e.g., Mammal, Reptile)
        this.type = type;               // sets type (e.g., Pet, Wild)
    }

    // Method that shows the animal playing
    public void play() {
        System.out.println(name + " is playing.");
    }

    // Method that shows the animal making a growling sound
    public void growl() {
        System.out.println(name + " is growling.");
    }

    // Method that can be overridden in child classes
    public void sick() {
        System.out.println("Animal is not feeling well.");
    }
}