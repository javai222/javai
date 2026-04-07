/*
*Created by Casapao,Jasmin Ann M.
*This class provides a template for leather type and leather texture
*/

package abstraction;

public abstract class Leather {

    private String leatherType; // Full-Grain Leather, Top-Grain Leather, Genuine Leather, Split Leather and Bonded Leather
    private String leatherTexture; // Smooth, Flat grain, Grainy, Pebble and Embossed

    // Overload Constructor 
    public Leather(String leatherType, String leatherTexture) {
        this.leatherType = leatherType;
        this.leatherTexture = leatherType;
    }

    // Getter
    public String getleatherType() {
        return leatherType;
    }
    public String getleatherTexture() { 
        return leatherTexture;
    }
    // Setter with validation
   public void setleatherType(String leatherType) {
        if (leatherType != null)
            this.leatherType = leatherType;
        else 
            System.out.println("Invalid Leather Type!");
    }

    public void setleatherTexture(String leatherTexture) {
        if (leatherTexture != null)
            this.leatherTexture = leatherTexture;
        else
            System.out.println("Invalid Leather Texture!");
    }
    //Abstract method 
    public abstract void describe();
    
    // Concrete method
    public void displayInfo() {
        System.out.println("Type: " + leatherType);
        System.out.println("texture: " + leatherTexture);

    }
}
