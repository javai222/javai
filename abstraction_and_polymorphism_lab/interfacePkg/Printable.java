/*
* Interface created by Plantilla, Jophel Mark
*/
package interfacePkg;

public interface Printable {

    // Abstract method must be implemented by classes 
    public void printReceipt();

    // Default method for confirmation of printing the receipt
    default void confirmPrint() {
        System.out.println("The receipt is printed successfully!");
    }
}