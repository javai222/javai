// Interface created by Casapao, Jasmin Ann M.

package interfacePkg;

interface Wearable {

    //Abstract method
    public void wear();

    //default method
    default void showUsage() {
        Sytem.out.println("This item can be worn for fashion or protection.");
    }
}
   
    

