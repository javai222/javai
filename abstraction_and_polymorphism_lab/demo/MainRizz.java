// Main created by Javier, Charles Justin
package demo;

public class Main {
    public static void main(String[] args) {

        Aura a = new Aura("Charles", 90);

        a.displayInfo();

        System.out.println();

        // Overriding
        a.showRizz();

        // Interface methods
        a.greet();
        a.flex("Too much aura");

        System.out.println();

        // Overloading
        a.flex();
        a.flex("Unstoppable", 2);
    }
}