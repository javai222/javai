/*
 * This class represents the skin class
 * Created by Jasmin Ann M. Casapao
 */

public class Skins {

    // Private attributes
    private String type;
    private String color;
    private String texture;

    // Default constructor
    public Skins() {
        this.type = "Unknown";
        this.color = "Unknown";
        this.texture = "Unknown";
    }

    // Parameterized constructor
    public Skins(String type, String color, String texture) {
        setType(type);
        setColor(color);
        setTexture(texture);
    }

    // Getters
    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public String getTexture() {
        return texture;
    }

    // Setters with validation
    public void setType(String type) {
        if (type != null && !type.isEmpty()) {
            this.type = type;
        } else {
            this.type = "Unknown";
        }
    }

    public void setColor(String color) {
        if (color != null && !color.isEmpty()) {
            this.color = color;
        } else {
            this.color = "Unknown";
        }
    }

    public void setTexture(String texture) {
        if (texture != null && !texture.isEmpty()) {
            this.texture = texture;
        } else {
            this.texture = "Unknown";
        }
    }

    // Behaviors (methods)
    public void displaySkinInfo() {
        System.out.println("Skin Type: " + type);
        System.out.println("Skin Color: " + color);
        System.out.println("Skin Texture: " + texture);
    }

    public void describeSkin() {
        System.out.println("This skin is " + texture + ", " + color + ", and classified as " + type + ".");
    }
}