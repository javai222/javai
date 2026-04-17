/* Implementation of Devilfruit_Saan and Attack interface created by Rahzel Heeroe R. Conel
*/
package abstraction;

import interfacePkg.Attack;

public class HieHieNoMi extends Devilfruit_Saan implements Attack {

    // ✅ Public constructor (no access issues)
    public HieHieNoMi() {
        super("Hie Hie no Mi", "Logia", "Epic", 5);
    }

    // Abstract methods
    @Override
    public String getDescription() {
        return "A Logia-type Devil Fruit that allows the user to create and control ice.";
    }

    @Override
    public String useAbility(String target) {
        return "Freezing " + target + " instantly with ice powers!";
    }

    @Override
    public String getWeakness() {
        return "Weak against extreme heat and magma.";
    }

    // Interface methods
    @Override
    public void attack() {
        System.out.println("Ice Spear launched!");
    }

    @Override
    public void defend() {
        System.out.println("Creates a solid ice shield.");
    }

    @Override
    public void damage() {
        System.out.println("Deals 180 ice damage.");
    }

    @Override
    public void train() {
        System.out.println("Training to improve ice control and freezing range.");
    }

    // Optional override of default method
    @Override
    public void ultimateAttack() {
        System.out.println("Ice Age! Freezes everything in the surroundings!");
    }
}