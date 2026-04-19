/*
 * Abstraction class created by Dolormente, Henry II S.
 * This class provides a template for different character types and roles
 */

package abstraction;

public abstract class Character {
  
    private String characterType; // Warrior, Mage, Archer
    private String role; // Tank, Damage Dealer, Support

    // Overloaded Constructors
    public Character(String characterType, String role) {
        this.characterType = characterType;
        this.role = role;
    }

    // Getters
    public String getCharacterType() {
        return characterType;
    }

    public String getRole() {
        return role;
    }

    // Setters with validation
    public void setCharacterType(String characterType) {
        if (characterType != null)
            this.characterType = characterType;
        else
            System.out.println("Invalid character type.");
    }

    public void setRole(String role) {
        if (role != null)
            this.role = role;
        else
            System.out.println("Invalid role.");
    }

    // Abstract methods
    public abstract void attack();
    public abstract void defend();

    // Abstract method that varies per subclass
    public abstract String getSpecialty(); 
    // Ex: Close Combat, Magic Damage, Long Range

    // Concrete method (same style as your teammate)
    public void displayCharacterInfo() {
        System.out.println("\nCHARACTER INFORMATION");
        System.out.println("Type: " + characterType);
        System.out.println("Role: " + role);
        System.out.println("Specialty: " + getSpecialty());
    }
}
