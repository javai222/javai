// This parent class is created by Ryan James M. Balanon

public class Pet {

    // Private Attributes
    private String name;
    private int age;
    private String type;

    // Constructor
    public Pet(String name, int age, String type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getType() {
        return type;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setType(String type) {
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
