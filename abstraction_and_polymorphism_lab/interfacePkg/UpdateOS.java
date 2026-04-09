//Interface created by John Roque R. Mance

package interfacePkg;

interface UpdateOS {
    //Abstract method
    public void outdated();

    //Default method
    default void updatePhone() {
        System.out.println("Your device is up to date!:)");
    }
}