// Main created by Javier, Charles Justin
package abstraction;

public class MainRizz {
    public static void main(String[] args) {

        SigmaRizz rizzler = new SigmaRizz("Charles", 80);

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