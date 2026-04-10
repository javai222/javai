/*
*Created by John Roque R. Mance
*This class provides a template for brand name and model
*/

package abstraction;
public abstract class Cellphone {
    private String brandName; // Iphone, samsung, huawei
    private String phoneModel; // Iphone 15 pro, flip 7, huawei matepad 11

    // Parametarized constructor
    public Cellphone (String brandName, String phoneModel) {
        this.brandName = brandName;
        this.phoneModel = phoneModel;
    }

    // Getters
    public String getBrandName() {
        return brandName;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    // Setters with validation
    public void setBrandName(String brandName) {
        if (brandName != null)
            this.brandName = brandName;
        else
            System.out.println("Invalid Brand Name.");
    }
    public void setPhoneModel(String phoneModel) {
        if (phoneModel != null)
            this.phoneModel = phoneModel;
        else
            System.out.println("Invalid Phone Model.");
    }

    //Abstract methods that the subclasses must implement
    public abstract void useCellphone();
    public abstract void chargeCellphone();

    //Abstract method to get the purpose of the phone
    public abstract String getPhoneColor(); //Ex. Silver, Black, White, etc.

    //Concrete method
    public void displayCellphoneInfo() {
        System.out.println("\n CELLPHONE INFORMATION");
        System.out.println("Brand: " + brandName);
        System.out.println("Model: " + phoneModel);
        System.out.println("Color: " + getPhoneColor());
    }
}