public class MainInheritance_Torrefranca {

    //This child class is made by Torrefranca, branching from the parent class of Conel

    /*
     * IS-A Relationship:
     * GamingMouse IS-A inheritanceMouse
     */

    /*
     * Overridden Method:
     * The scroll() method is overridden in GamingMouse
     */

    /*
     * Dynamic Binding:
     * The method executed depends on the actual object (GamingMouse),
     * not the reference type (inheritanceMouse)
     */

    /*
     * Inherited Methods:
     * move() and click() are inherited from inheritanceMouse
     */

    /*
     * New Behavior:
     * changeLighting() method is introduced in GamingMouse
     */

    public static void main(String[] args) {

        // Dynamic binding
        inheritanceMouse m = new GamingMouse("Razer", "Black", "Wireless", 16000, "Rainbow");

        // Overridden method
        m.scroll();

        // Inherited methods
        m.move();
        m.click();

        // Child-specific method
        GamingMouse gm = new GamingMouse("Razer", "Black", "Wireless", 16000, "Rainbow");
        gm.changeLighting();
    }
}
