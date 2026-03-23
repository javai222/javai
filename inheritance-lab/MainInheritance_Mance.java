public class MainInheritance_Mance {
    public static void main(String[] args) {
        // Create a default keyboard
        InheritanceKeyboard defaultKeyboard = new InheritanceKeyboard();
        System.out.println("Default Keyboard:");
        System.out.println("Brand: " + defaultKeyboard.getBrand());
        System.out.println("Color: " + defaultKeyboard.getColor());
        System.out.println("Type: " + defaultKeyboard.getType());
        System.out.println("Keys: " + defaultKeyboard.getKeys());
        defaultKeyboard.Typing();
        defaultKeyboard.click();
        defaultKeyboard.RGB();

        System.out.println();

        // Create a parameterized keyboard
        InheritanceKeyboard customKeyboard = new InheritanceKeyboard("Logitech", "Black", "Mechanical", 104);
        System.out.println("Custom Keyboard:");
        System.out.println("Brand: " + customKeyboard.getBrand());
        System.out.println("Color: " + customKeyboard.getColor());
        System.out.println("Type: " + customKeyboard.getType());
        System.out.println("Keys: " + customKeyboard.getKeys());
        customKeyboard.Typing();
        customKeyboard.click();
        customKeyboard.RGB();
    }
}