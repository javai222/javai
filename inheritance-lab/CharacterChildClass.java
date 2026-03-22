/*
*Child class created Plantilla, Parent class created by Silva
*/

//This class shows the IS-A relationship because Clorinde is a Character from Genshin Impact
class Clorinde extends Character {

    // Assigning values to attributes inherited from the parent class
    public Clorinde(String name, String weapon, String artifacts, String emote, String SpecialSkill) {
        super(name, weapon, artifacts, emote, SpecialSkill);
    }

    // Adding new method
    public void dash(){
        System.out.println("Clorinde dashes with electric speed! ");
    }

    //Override method from the character parent class
    @Override
    public void doEmote() {
        System.out.println("Clorinde enters Hunter's Vigil stance!");
    }

    //Override method from the character parent class
    @Override
    public void executeSpecialSkill() {
        System.out.println("Clorinde unleashes the Last Lightfall! ");
    }
}

//This class shows the IS-A relationship because Chiori is a Character from Genshin Impact
class Chiori extends Character {
    
    // Assigning values to attributes inherited from the parent class
    public Chiori(String name, String weapon, String artifacts, String emote, String SpecialSkill) {
        super(name, weapon, artifacts, emote, SpecialSkill);
    }

    //Adding a new method
    public void castSpell() {
        System.out.println("Chiori summons Tamoto puppet! ");
    }
    
    //Override method from the character parent class
    @Override
    public void doEmote() {
        System.out.println("Chiori performs Fluttering Hasode! ");
    }

    //Override method from the character parent class
    @Override
    public void executeSpecialSkill() {
        System.out.println("Chiori performs Twin Blades! ");
    }
}

