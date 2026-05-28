//interface created by kenneth Saan

package interfacePkg;

// Interface for basic combat actions.
public interface Attack {
    
    // Performs an attack action.
    void attack();

    // Performs a defensive action.
    void defend();
    
    // Applies damage to an opponent.
    void damage();

    // Improves combat ability.
    void train();

    // Default special move available to all implementers.
    default void ultimateAttack() {
        System.out.println("Executing ultimate attack!");
    }
}
