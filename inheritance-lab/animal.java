/*
* This class represents an animal parent class
* Created by Charles Justin Javier
*/

public class animal {
    
    // Attributes (variables) that describe the animal
    private String name;
    private String classification;
    private String type;

    // Default Constructors
    public animal(String name, String classification, String type) {
        this.name = name;              
        this.classification = classification; 
        this.type = type;               
    }
    // Parameterized Constructors
     public animal(String name, String classification, String type) {
        this.name = name;
        this.classification = classification;
        this.type = type;
    }

    //Getters
     public String getName() {
        return name;
    }
    public String getClassification() {
        return classification;
    }

    public String getType() {
        return type;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public void setType(String type) {
        this.type = type;
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