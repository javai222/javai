// This Interface was created by De Leon, Lord Ulrick A.

package interfacePkg;

public interface LegoActions {

    // Abstract method
    void playWithLego();

    // Default Method
    default void cleanUpLego() {
        System.out.println("Cleaning up the lego pieces after playing.");
    }
}