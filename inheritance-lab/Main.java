public class Main {
    public static void main(String[] args) {
        // Create an instance of animal
        animal myAnimal = new animal("Lion", "Mammal", "Carnivore");
        System.out.println("Animal Name: " + myAnimal.getName());
        System.out.println("Classification: " + myAnimal.getClassification());
        System.out.println("Type: " + myAnimal.getType());

        // Create an instance of User
        User user = new User();
        user.register();
        user.showInfo();
    }
}