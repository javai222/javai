package composition_lab;

public class CompositionDemoSaan {
    public static void main(String[] args) {
        // Shared address for both humans
        Address address = new Address("123 Main St", "Anytown", "USA");

        // Create Human objects
        Human human = new Human("Kenneth", 30, address, 50, 95, 8, "leeg", 7, true, "brown");
        Human human2 = new Human("Alesandra", 28, address, 30, 110, 7, "batok", 4, false, "white");

        // Show first human's initial data
        System.out.println("\n=== " + human.getName() + " (Initial) ===");
        System.out.println("Age: " + human.getAge());
        System.out.println("Address: " + human.getAddress().getStreet() + ", " + human.getAddress().getCity() + ", " + human.getAddress().getCountry());
        System.out.println("\nBrain Info:");
        human.displayBrainInfo();
        System.out.println("\nLibag Info:");
        human.displayLibagInfo();
        
        // Update first human using setters
        System.out.println("\n--- Using Setters to Update Kenneth's Data ---");
        human.setCortisolLevel(65);
        human.setIQ(100);
        human.setSleepHours(6);
        human.setLibagLocation("kilikili");
        human.setLibagThickness(5);
        human.setLibagMatigas(false);
        human.setLibagColor("dark brown");
        
        // Show updated first human data
        System.out.println("\n=== " + human.getName() + " (After Setters) ===");
        System.out.println("Age: " + human.getAge());
        System.out.println("\nBrain Info:");
        human.displayBrainInfo();
        System.out.println("\nLibag Info:");
        human.displayLibagInfo();
        
        // Show second human data
        System.out.println("\n=== " + human2.getName() + " ===");
        System.out.println("Age: " + human2.getAge());
        System.out.println("Address: " + human2.getAddress().getStreet() + ", " + human2.getAddress().getCity() + ", " + human2.getAddress().getCountry());
        System.out.println("\nBrain Info:");
        human2.displayBrainInfo();
        System.out.println("\nLibag Info:");
        human2.displayLibagInfo();
        
        // Run behavior methods
        System.out.println("\n=== Actions ===");
        human.think();
        human2.think();
    }
}

/* -Has A relationship is not dependent to another class and it can be easily modified without destroying the other class
- The reused classes were Brain, Libag, and Address
-the composition reduces coupling since the human class does not control the code inside thebrain and libag class instead the human has them not Is A relationship
- Each class has a specific responsibility, where the Human class is responsible for the overall human data and behaviors, the Brain class is responsible for brain-related attributes and behaviors. while the libag is responsible for libag related things.
- Cohesion is maintained through the use of encapsulation and methods, where each class has its own set of attributes and methods that are related to its specific responsibility.
- inheritance is not appropiate because human is not a brain or libag like car is not an engine, instead the human has A libag and a brain */