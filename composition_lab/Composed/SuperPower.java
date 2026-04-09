/*
    This composed clasll was created by Dolormente, Henry II, S.
    The component classes were created by Sir(Libag), Tismo(Powers), and Casapao(Skins)
*/

package composition_lab;

public class SuperPower {

    // Component objects (Has-A)
    private Libag libag;
    private Powers powers;
    private Skins skins;

    // Constructor
    public SuperPower(Libag libag, Powers powers, Skins skins) {
        this.libag = libag;
        this.powers = powers;
        this.skins = skins;
    }

    // Getters
    public Libag getLibag() {
        return libag;
    }

    public Powers getPowers() {
        return powers;
    }
    public Skins getSkins() {
        return skins;
    }

    // Setters
    public void setLibag(Libag libag) {
        this.lotion = lotion;
    }

    public void setPowers(Powers powers) {
        this.powers = powers;
    }

    public void setSkins(Skins skins) {
        this.skins = skins;
    }

    // Behavior that activates all components
    public void activateAll() {
        System.out.println("=== Activating Superpower ===");
        
        powers.usePowers();
        skins.describeSkin();
        libag.kuskos();
    }

    // Behavior that displays all the details
    public void displayAll() {
        System.out.println("\n===Full Details ===")

        powers.displayDetails();
        skins.displaySkinInfo();
        libag.describe();
    }
}
















