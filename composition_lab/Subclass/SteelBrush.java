package composition_lab.Subclass;

import composition_lab.Brush;

/*
*Created by Cantela, Chris Nelson B. 
 for the instruciton no. 7 option 1 x2 multiplier
*This shows low coupling because HilodService can use any type of brush.
*/
public class SteelBrush extends Brush {
    private String steelType;

    public SteelBrush(String type, String material, int bristleStrength, boolean isNew, String steelType) {
        super(type, material, bristleStrength, isNew);
        this.steelType = steelType;
    }

    public SteelBrush () {
        super("Scrubbing", "Steel", 8, true);
        this.steelType = "Stainless Steel";
     }

    public String getSteelType() {
        return steelType;
    }

    public void setSteelType(String steelType) {
        if(steelType != null && !steelType.isEmpty()) {
            this.steelType = steelType;
        } else 
            System.out.println("dude seriously put something valid bruh");
    }

    // Override describe method to show steel brush specific details
    @Override
    public void describe() {
        System.out.println("=== STEEL BRUSH ===");
        super.describe();
        System.out.println("Steel Type: " + steelType);
    }

    // Custom method for steel brush
    public void strengthenBristles() {
        System.out.println("Strengthening " + steelType + " bristles...");
        this.setBristleStrength(getBristleStrength() + 1);
    }
}
