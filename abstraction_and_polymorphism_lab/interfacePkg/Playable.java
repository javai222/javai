// interface created by Javier, Charles Justin
package interfacePkg;

// Interface
public interface Playable {

    // Abstract method
   public void build(String block);

    public void play();

    void destroy(String block);
    // Default method
    default void showTip() {
        System.out.println("Tip: Use stronger blocks for better structures!");
    }
}