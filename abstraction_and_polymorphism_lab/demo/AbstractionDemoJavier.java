package demo;
import subclass.RizzChildClass;

public class AbstractionDemoJavier {
    public static void main(String[] args) {

        RizzChildClass rizzler = new RizzChildClass("Charles", 80);

        rizzler.displayInfo();

        System.out.println();

        // Overridden method
        rizzler.showRizz();

        // Interface methods
        rizzler.greet();
        rizzler.compliment("You have great vibes!");

        System.out.println();

        // Overloaded methods
        rizzler.compliment();
        rizzler.compliment("Stay confident!", 2);
    }
}