// Interface representing a connectable laptop, and created by Balanon, Ryan James M.
package interfacePkg;

public interface ConnectableLaptop {

    // Abstract method (must be implemented by child classes)
    void connect();

    // Getter and Setter for network name (encapsulation)
    String getNetworkName();
    void setNetworkName(String networkName);

    // Default method
    default void showConnectionStatus() {
        System.out.println("Checking network connection...");
    }
}
