//Interface created by Yvette Germaine E. Tismo

package interfacePkg;

public interface Breakable {
    //Abstract method
    void breakGlass();

    //Default method
    default void handleWithCare() {
        System.out.println("Handle with care! This glass item is fragile.");
    }
}