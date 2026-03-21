public class Pet {

    // Attributes
    String name;
    int age;
    String type; // e.g., Dog, Cat, Bird

    // Constructor
    public Pet(String name, int age, String type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    // Behavior 1 (can be overridden)
    public void makeSound() {
        System.out.println("The pet makes a sound");
    }

    // Behavior 2
    public void eat() {
        System.out.println(name + " is eating");
    }

    // Behavior 3
    public void sleep() {
        System.out.println(name + " is sleeping");
    }
}
