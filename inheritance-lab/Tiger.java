public class Tiger extends animal {

    // Additional attribute specific to Tiger
    private String habitat;

    // Constructor
    public Tiger(String name, int age, String type, String habitat) {
        super(name, age, "Mammal", type); // Calls the parent constructor
        this.habitat = habitat;
    }

    // Getter
    public String getHabitat() {
        return habitat;
    }

    // Setter
    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    // Overriding the makeSound() method
    @Override
    public void makeSound() {
        System.out.println(getName() + " roars loudly!");
    }

    // Additional behavior specific to Tiger
    public void hunt() {
        System.out.println(getName() + " is hunting in the " + habitat);
    }
}