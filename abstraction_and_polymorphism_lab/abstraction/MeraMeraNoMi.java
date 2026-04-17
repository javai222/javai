/* Implementation of Devilfruit_Saan and Attack interface created by Rahzel Heeroe R. Conel
*/

package abstraction;

import interfacePkg.Attack;

public class MeraMeraNoMi extends Devilfruit_Saan implements Attack {

    public MeraMeraNoMi() {
        super("Mera Mera no Mi", "Logia", "Legendary", 5);
    }

    @Override
    public String getDescription() {
        return "Allows the user to create and control fire.";
    }

    @Override
    public String useAbility(String target) {
        return "Burning flames engulf " + target + "!";
    }

    @Override
    public String getWeakness() {
        return "Weak against water and stronger elements.";
    }

    @Override
    public void attack() {
        System.out.println("Fire Fist!");
    }

    @Override
    public void defend() {
        System.out.println("Transforms into fire to avoid damage.");
    }

    @Override
    public void damage() {
        System.out.println("Deals 200 fire damage.");
    }

    @Override
    public void train() {
        System.out.println("Training to control stronger flames.");
    }
}