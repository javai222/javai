/*
* This class represents an animal parent class
* Created by Charles Justin Javier
*/

public class animal {
    
    // Attributes (variables) that describe the animal
    private String name;
    private String classification;
    private String type;

    //Default Constructor
    public animal() {
        this.name = "Unknown";
        this.classification = "Unknown";
        this.type = "Unknown";
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
    if (name != null && !name.trim().isEmpty()) {
        this.name = name;
    } else {
        System.out.println("Invalid name. It cannot be empty.");
    }
}

public void setClassification(String classification) {
    if (classification != null && !classification.trim().isEmpty()) {
        this.classification = classification;
    } else {
        System.out.println("Invalid classification.");
    }
}

public void setType(String type) {
    if (type != null && !type.trim().isEmpty()) {
        this.type = type;
    } else {
        System.out.println("Invalid type.");
    }
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
