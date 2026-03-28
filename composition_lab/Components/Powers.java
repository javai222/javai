/*
*This class/component represents power attributes such as power type, power category, and range
*Created by Yvette Germaine Tismo
*/
package composition_lab;

public class Powers {

    private String powerType; //Physical Enhancement, Mental Enhancement or Manipulation
    private String powerCategory; //Offensive, Defensive, Exploration
    private String range; //Short Range, Long Range, or both

    //Parameterized Constructor
    public Powers(String powerType, String powerCategory, String range) {
        this.powerType = powerType;
        this.powerCategory = powerCategory;
        this.range = range;
    }

    //Getters
    public String getPowerType(){
        return powerType;
    }

    public String getPowerCategory(){
        return powerCategory;
    }

    public String getRange(){
        return range;
    }

    //Setters with validation
    public void setPowerType(String powerType) {
        if (powerType != "")
            this.powerType = powerType;
    }

    public void setPowerCategory(String powerCategory){
        if (powerCategory != "")
            this.powerCategory = powerCategory;
    }

    public void setRange(String range){
        if (range != "")
            this.range = range;
    }

    //Behavior Methods 
    public void usePowers (){
        System.out.println("Powers Activated!!");
        if (powerCategory != "")
            if (powerCategory == "Offensive")
                System.out.println("ATTACKKK!");
            else if (powerCategory == "Defensive")
                System.out.println("Back off!");
            else 
                System.out.println("Adventure awaits!");
    }

    public void attackHits(){
        System.out.println("Right on target.");
    }

    public void attackMisses(){
        System.out.println("I intended to do that. It was a... misdirection tactic.");
    }

    public void displayDetails(){
        System.out.println("Power Details: ");
        System.out.println("Type: " +powerType);
        System.out.println("Category: " +powerCategory);
        System.out.println("Range: " +range);
    }

}