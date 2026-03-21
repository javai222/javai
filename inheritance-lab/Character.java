/*
* This class represents a character parent class
* Created by Vinz Joseph R. Silva
*/

public class Character {

    //Attributes that describes the information about the character
    private String name;
    private String weapon;
    private String artifacts;
    private String emote;
    private String SpecialSkill;

    // Constructors for initialization of the objects
    public Character (String name, String weapon, String artifacts, String emote, String SpecialSkill){
        this.name = name;
        this.weapon = weapon;
        this.artifacts = artifacts;
        this.emote = emote;
        this.SpecialSkill = SpecialSkill;
    }

    // getter methods
    public String getName (){
        return name;
    }

    public String getWeapon () {
        return weapon;
    }

    public String getArtifacts () {
        return artifacts;
    }

    public String getEmote () {
        return emote;
    }

    public String getSpecialSkill () {
        return SpecialSkill;
    }


    // Displays the name 
    public void showName (){
        System.out.println(name);
    }

    // Displays the weapon that the character possessed 
    public void dispayWeapon () {
        System.out.println("The weapon is " + weapon);
    }

    // Showcase all the artifacts owned by the character 
    public void showcaseArtifacts () {
        System.out.println("All the artifacts are " + artifacts);
    }

    // Shows the emote that the character will execute 
    public void doEmote () {
        System.out.println("Character starts to dance");
    }
    
    // This method can be overridden in child class
    public void executeSpecialSkill () {
        System.out.println("Character use his special skill");
    }

}