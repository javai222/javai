//This class is created by Cantela, Chris Nelson B.
package Implementation;
import abstraction.Cellphone;
import interfacePkg.Updatable;


public class AndroidPhone extends Cellphone implements Updatable {
    //two additional attributes
    private String color;
    private double AndroidVersion;

    //constructor that accepts the following attributes
    public AndroidPhone (String brandName, String phoneModel, String color, double AndroidVersion) {
        super(brandName, phoneModel);
        this.color = color;
        this.AndroidVersion = AndroidVersion;
    }

    //getter for the Android version
    public double getAndroidVersion () {
        return AndroidVersion;
    }

    //setter wwith validation
    public void setPhoneColor (String color) {
        if (color != null && !color.trim().isEmpty())
            this.color = color;
        else
            System.out.println("Color cannot be empty.");
    }

    //setter with validation
    public void setAndroidVersion(double AndroidVersion) {
        if (AndroidVersion > 0 && AndroidVersion <= 16)
            this.AndroidVersion = AndroidVersion;
        else if (AndroidVersion > 16)
            System.out.println("Invalid Android version. Version cannot exceed to the latest version 16.");
        else
            System.out.println("Invalid Android version.");
    }

    //overloaded setter method that accepts String input
    public void setAndroidVersion(String AndroidVersion) {
        try {
            double version = Double.parseDouble(AndroidVersion);
            setAndroidVersion(version);
        } catch (NumberFormatException e) {
            System.out.println("That is not an Android Version, perhaps you are an iphone user???.");
        }
    }


    //OVERRIDED METHODS FROM ABSTRACT: CELLPHONE
    @Override
    public void useCellphone() {
        System.out.println("The user is using the cellphone, and using gemini.");
    }

    @Override
    public void chargeCellphone() {
        System.out.println("The phone is charging using fast charging cable." +
                "\nor using wireless charging.");
    }

    @Override
    public String getPhoneColor() {
        return color;
    }

    @Override
    public void displayCellphoneInfo() {
        super.displayCellphoneInfo();
        System.out.println("Android Version: " + AndroidVersion);
    }

    //OVERRIDED METHODS FROM INTERFACE: UPDATABLE
    @Override
    public void outdated() {
        if (AndroidVersion < 16)
            System.out.println("Android Version " + AndroidVersion + " may be outdated consider updating.");
        else if (AndroidVersion == 16)
            System.out.println("Android Version " + AndroidVersion + " is up to date");


    }

    @Override
    public void updatePhone() {
        if (AndroidVersion < 16){
            AndroidVersion = 16;
            System.out.println("UPDATING... " +
                               "\nYour Android Version is now up to date!");
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
