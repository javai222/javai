/*
*Created by Yvette Germaine E. Tismo
*This class provides a template for glass type and glass transparency
*/
package abstraction;

public abstract class Glass {
    private String glassType; //Tableware, Drinkware, Container, Household Essentials, or Personal Items
    private String glassTransparency; //Clear, Frosted, or Tinted

    //Overloaded Constructor
    public Glass (String glassType, String glassTransparency) {
        this.glassType = glassType;
        this.glassTransparency = glassTransparency;
    }

    //Getters
    public String getGlassType(){
        return glassType;
    }

    public String getGlassTransparency(){
        return glassTransparency;
    }

    //Setters with validators
    public void setGlassType(String glassType){
        if (glassType != null)
            this.glassType = glassType;
        else
            System.out.println("Invalid glass type.");
    }

    public void setGlassTransparency(String glassTransparency) {
        if (glassTransparency != null)
            this.glassTransparency = glassTransparency;
        else
            System.out.println("Invalid glass transparency.");
    }

    //Abstract methods that the subclasses must implement
    public abstract void useGlass();
    public abstract void cleanGlass();

    //Abstract method to get the purpose of the glass (Vary depending on subclass)
    public abstract String getGlassPurpose(); //Ex. Ventilation, Storage, Drinking, Eating, Eye Protection, etc.

    //Concrete method
     public void displayGlassInfo() {
        System.out.println("\nGLASS INFORMATION");
        System.out.println("Type: " + glassType);
        System.out.println("Transparency: " + glassTransparency);
        System.out.println("Purpose: " + getGlassPurpose());
    }
}