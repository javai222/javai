//interface created by Rahzel Heeroe R. Conel

package interfacePkg;

// Interface for basic combat actions.
public interface Fight {
    
    // Performs an attack move.
    void attack();

    // Applies damage to the enemy.
    void damage();

    // Improves combat ability and strength.
    void train();

    // Default special move available to all implementers.
    default void standBarrage() {
        System.out.println("Executing barrage of attack!");
    }
}
