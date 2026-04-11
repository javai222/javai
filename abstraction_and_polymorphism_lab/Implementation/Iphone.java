//This class is created by Cantela, Chris Nelson B.
package Implementation;
import abstraction.Cellphone;
import interfacePkg.UpdateOS;


public class Iphone extends Cellphone implements UpdateOS {
    //two additional attributes
    private String color;
    private double IOSVersion;

    //constructor that accepts the following attributes
    public Iphone (String brandName, String phoneModel, String color, double IOSVersion) {
        super(brandName, phoneModel);
        this.color = color;
        this.IOSVersion = IOSVersion;
    }

    //getter for the IOS version
    public double getIOSVersion () {
        return IOSVersion;
    }

    //setter wwith validation
    public void setPhoneColor (String color) {
        if (color != null && !color.trim().isEmpty())
            this.color = color;
        else
            System.out.println("Color cannot be empty.");
    }

    //setter with validation
    public void setIOSVersion(double IOSVersion) {
        if (IOSVersion > 0 && IOSVersion <= 26)
            this.IOSVersion = IOSVersion;
        else if (IOSVersion > 26)
            System.out.println("Invalid iOS version. Version cannot exceed 26.");
        else
            System.out.println("Invalid iOS version.");
    }

    //overloaded setter method that accepts String input
    public void setIOSVersion(String iOSVersionInput) {
        try {
            double version = Double.parseDouble(iOSVersionInput);
            setIOSVersion(version);
        } catch (NumberFormatException e) {
            System.out.println("That is not an IOS Version, perhaps you are an android user???.");
        }
    }


    //OVERRIDED METHODS FROM ABSTRACT: CELLPHONE
    @Override
    public void useCellphone() {
        System.out.println("The user is using the cellphone, and using Siri.");
    }

    @Override
    public void chargeCellphone() {
        System.out.println("The phone is charging using Lightning cable." +
                           "\nor using wireless charging.");
    }

    @Override
    public String getPhoneColor() {
        return color;
    }

    @Override
    public void displayCellphoneInfo() {
        super.displayCellphoneInfo();
        System.out.println("IOS Version: " + IOSVersion);
    }

    //OVERRIDED METHODS FROM INTERFACE: UPDATEOS
    @Override
    public void outdated() {
        if (IOSVersion < 26)
            System.out.println("IOS Version " + IOSVersion + " may be outdated consider updating.");
    }

    @Override
    public void updatePhone() {
        if (IOSVersion < 26){
            IOSVersion = 26.4;
            System.out.println("Your IOS Version is now up to date!");
        }
    }

    //send message method
    public void sendMessage (String recipient, String message) {
        System.out.println("Sending message to: " + recipient + ": " + message);
    }

    //overloaded method of send message 
    public void sendMessage (String recipient, String message, String time) {
        System.out.println("[" + time + "] Sending message to: " + recipient + ": " + message);
    }
}
