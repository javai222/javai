/*
* Composed class created by Cantela, Chris Nelson B.
* Components created by Sir Ramon, De Leon, and Casapao
* This class represents Hilod which is a composed class that uses 3 components
 Brush, Skins, and Libag. 
*/


package composition_lab.Composed;

import composition_lab.Components.Brush;
import composition_lab.Components.Skins;
import composition_lab.Components.Libag;


public class HilodService {

    private Brush brush;      // HAS-A Brush
    private Skins skins;      // HAS-A Skins
    private Libag libag;      // HAS-A Libag

    // Constructor 1: Full constructor injection
    public HilodService (String type, String material, int bristleStrength, boolean isNew,
                      String skinType, String skinColor, String skinTexture,
                      String location, int thickness, boolean matigas, String color) {
        this.brush = new Brush(type, material, bristleStrength, isNew);
        this.skins = new Skins(skinType, skinColor, skinTexture);
        this.libag = new Libag(location, thickness, matigas, color);
    }

    // Constructor 2: Constructor injection with pre-made Skins object
    public HilodService (Brush brush, Skins skins, Libag libag) {
        this.brush = brush;
        this.skins = skins;
        this.libag = libag;
    }

    // SETTERS: Alternative to constructor injection (allows changing components)
    public void setBrush(Brush brush) {
        this.brush = brush;
    }

    public void setSkins(Skins skins) {
        this.skins = skins;
    }

    public void setLibag(Libag libag) {
        this.libag = libag;
    }

    // GETTERS: Access composed objects if needed
    public Brush getBrush() {
        return brush;
    }

    public Skins getSkins() {
        return skins;
    }

    public Libag getLibag() {
        return libag;
    }

    // BEHAVIOR METHOD 1: Display details of all composed objects
    public void hilodDetails() {
        System.out.println("===== HILOD DETAILS =====");
        brush.describe();
        skins.displaySkinInfo();
        libag.describe();
    }

    // BEHAVIOR METHOD 2: Another behavior using the composed objects
    public void prepareForHilod() {
        System.out.println("===== PREPARING FOR HILOD =====");
        System.out.println("Brush status: " + (brush.isNew() ? "Brand new" : "Used"));
        System.out.println("Brush material: " + brush.getMaterial());
        System.out.println("Skins texture: " + skins.getTexture());
        System.out.println("Libag thickness: " + libag.getThickness());
        if (libag.isMatigas()) {
            System.out.println("Libag is matigas - need extra time to soak!");
            libag.soak();
        }
        System.out.println("Ready for hilod!");
    }

    // BEHAVIOR METHOD 3: The main hilod action - scrub skin to remove dirt
    public void scrubSkin() {
        System.out.println("===== STARTING HILOD RAHHHH =====");
        System.out.println("Starting to scrub with " + brush.getType() + " brush...");
        libag.soak();
        libag.kuskos();
        System.out.println("Hilod complete! WALA NG LIBAGGGG SA " + libag.getLocation() + "!");
    }

    
}