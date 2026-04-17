/* Implementation of Devilfruit_Saan and Attack interface created by Rahzel Heeroe R. Conel
*/
package abstraction;

import interfacePkg.Attack;

public class GomuGomuNoMi extends Devilfruit_Saan implements Attack {

    GomuGomuNoMi() {
        super("Gomu Gomu no Mi", "Paramecia", "Legendary", 1);
    }

    // Abstract method implementations
    @Override
    String getDescription() {
        return "A Paramecia-type Devil Fruit that grants the user's body the properties of rubber.";
    }

    @Override
    String useAbility(String target) {
        return "Stretching rubber fist launched at " + target + "!";
    }

    @Override
    String getWeakness() {
        return "Seawater and Seastone nullify all rubber abilities.";
    }

    // Attack interface implementations
    @Override
    public void attack() {
        System.out.println("Gomu Gomu no Pistol! Launching a stretched rubber fist");
    }

    @Override
    public void defend() {
        System.out.println("Rubber body deflects bullets and blunt attacks");
    }

    @Override
    public void damage() {
        System.out.println("Dealing 150 impact damage to the opponent");
    }

    @Override
    public void train() {
        System.out.println("Training devil fruit to improve mastery and gaining new mode like Gear 2.");
    }

    // Overriding default ultimate attack
    @Override
    public void ultimateAttack() {
        System.out.println("Gomu Gomu no King Kong Gun! Massive rubber fist obliterates the opponent");
    }

    public static void main(String[] args) {
        // Creates a new instance of GomuGomuNoMi to test all methods.
        GomuGomuNoMi fruit = new GomuGomuNoMi();

        // Displays all inherited devil fruit information from Devilfruit_Saan
        fruit.DisplayDevilfruitInfo();

        // Demonstrates all combat actions from the Attack interface.
        System.out.println("\nCOMBAT ACTIONS");
        fruit.attack();
        fruit.defend();
        fruit.damage();
        fruit.train();
        fruit.ultimateAttack();

        System.out.println("\nABILITY USE");
        System.out.println(fruit.useAbility("Buggy"));
    }
}