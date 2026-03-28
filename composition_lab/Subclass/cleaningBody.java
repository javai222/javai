/* 
    Composed class created by Dolormente | Component class created by sir, plantilla, and silva.
*/

package composition_lab;

public class cleaningBody {

    // Composition (HAS-A)
    private Skins skin;
    private Libag libag;
    private Soap soap;
    private Water water;

    // Constructor Injection
    public CleaningBody(Skins skin, Libag libag, Soap soap, Water water) {
        this.skins = skin;
        this.libag = libag;
        this.soap = soap;
        this.water = water;
    }

    // Setters with validation
    public void setLibag(Libag libag) {
        if (libag != null) {
          this.libag = libag;
        }
    }

    public void setSoap(Soap soap) {
        if (soap != null) {
            this.soap = soap;
        }
    }

    public void setWater(Water water) {
        if (water != null) {
            this.water = water;
        }
    }

    public void setSkin(Skins skin) {
        if (skin != null) {
            this.skin = skin;
        }
    }

    public void showStatus() {
        System.out.println("\n=== Cleaning Status ===");
        libag.describe();
        soap.showDetails();
        water.display();
    }

    // Behaviors
    public void startCleaning() {
        System.out.println("Starting body cleaning process...");

        water.pour();
        libag.soak();
        soap.useSoap();
        libag.kuskos();

        System.out.println("Body is now clean!");
    }

    public void checkSkinAfterCleaning() {
        System.out.println("\n🧴 Checking skin condition...");

        skin.displaySkinInfo();

        if (skin.getTexture().equalsIgnoreCase("dry")) {
            System.out.println("Skin is dry, try considering using a moisturizer.");
        } else {
            System.out.println("Skin looks healthy!");
        }
    }
  
    public void showStatus() {
        System.out.println("\n=== Cleaning Status ===");
        libag.describe();
        soap.showDetails();
        water.display();
        skin.describeSkin();
    }
  
    // Getters
    public Skins getSkin() {
        return skin;
    }
    public Libag getLibag() {
        return libag;
    }

    public Soap getSoap() {
        return soap;
    }

    public Water getWater() {
        return water;
    }

    // Setters
    public void setLibag(Libag libag) {
        this.libag = libag;
    }

    public void setSoap(Soap soap) {
        this.soap = soap;
    }

    public void setWater(Water water) {
        this.water = water;
    }
}



