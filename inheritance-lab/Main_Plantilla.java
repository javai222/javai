/*

//Child class created Plantilla, Parent class created by Silva

What is the IS-A relationship in your program?
// Clorinde IS-A Character and Chiori IS-A Character

Which method was overridden?
// The executeSpecialSkill() and doEmote() methods were overridden.

What happens during dynamic binding?
// The overridden method in the child class is executed.

What methods were inherited from the parent class?
// The methods were inherited from the parent class are showName(), dispayWeapon(), and showcaseArtifacts().

What new behavior did the subclass introduce?
// Clorinde introduced dash().
// Chiori introduced castSpell().
*/

public class Main_Plantilla {
    public static void main(String[] args) {

        // Dynamic Binding: Create an object of subclass 
        Character c1 = new Clorinde("Clorinde", "Sword", "Fragment of Harmonic Whimsy", "Hunter's Vigil", "Last Lightfall");

        System.out.println("=== FIRST CHARACTER ===");
        
        // Call inherited methods from the parent class
        c1.showName();
        c1.dispayWeapon();
        c1.showcaseArtifacts();

        // Call overridden methods from the parent class
        c1.doEmote();
        c1.executeSpecialSkill();

        // Call new behavior from the subclass
        Clorinde cl = new Clorinde("Clorinde", "Sword", "Fragment of Harmonic Whimsy", "Hunter's Vigil", "Last Lightfall");
        cl.dash();

        // Dynamic Binding: Create another object of subclass 
        Character c2 = new Chiori("Chiori", "Sword", "Golden Troupe", "Fluttering Hasode", "Twin Blades");

        System.out.println("\n=== SECOND CHARACTER ===");

        // Call inherited methods from the parent class
        c2.showName();
        c2.dispayWeapon();
        c2.showcaseArtifacts();

        // Call overridden methods from the parent class
        c2.doEmote();
        c2.executeSpecialSkill();

        // Call new behavior from the subclass
        Chiori ch = new Chiori("Chiori", "Sword", "Golden Troupe", "Fluttering Hasode", "Twin Blades");
        ch.castSpell();
    }
}