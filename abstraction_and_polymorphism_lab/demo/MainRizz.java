// Main created by Javier, Charles Justin
package demo;

public class Main {
    public static void main(String[] args) {

        // Polymorphism (parent reference)
        Rizz a = new Aura("Charles", 90);
        Rizz c = new Chad("Justin", 85);

        System.out.println("=== AURA ===");
        a.displayInfo();
        a.showRizz(); // overridden

        System.out.println();

        System.out.println("=== CHAD ===");
        c.displayInfo();
        c.showRizz(); // overridden

        System.out.println();

        // Interface + Overloading Demo
        Aura auraObj = new Aura("Charles", 95);

        auraObj.greet();
        auraObj.flex("Too much aura");

        System.out.println();

        // ✅ Overloading
        auraObj.flex();
        auraObj.flex("Unstoppable", 2);
    }
}