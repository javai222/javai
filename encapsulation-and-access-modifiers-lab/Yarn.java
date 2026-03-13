public class Yarn {
    /*
    *This class represents yarn orders with colors, ply size, and grams
    *Created by Yvette Germaine Tismo
    */
    
    //Private attributes of the yarn
    private String color;
    private String yarnType;
    private int plySize;
    private int grams;

    // Static attribute
    private static int totalYarn = 0;

    // Default constructor
    public Yarn(){
        color = "white";
        yarnType = "Acrylic";
        plySize = 4;
        grams = 20;
        totalYarn++;
    }

    // Overloaded constructor
    public Yarn(String color, String yarnType, int plySize) {
        this.color = color;
        this.yarnType = yarnType;
        this.plySize = plySize;
        this.grams = 20; // default grams
        totalYarn++;
    }

    // Parameterized constructor
    public Yarn(String color, String yarnType, int plySize, int grams) {
        this.color = color;
        this.yarnType = yarnType;
        this.plySize = plySize;
        this.grams = grams;
        totalYarn++;
    }

    public String getColor() { return this.color; }

    public String getYarnType() { return this.yarnType; }

    public int getPlysize(){ return this.plySize; }

    public int getGrams(){ return this.grams; }

    // Behavior with parameters
    public void setColor(String color) {
        if (color != ""){
            this.color = color;
            System.out.println("Buyer has updated the yarn color to " + color + ".");
        }
    }

    public void setYarnType(String yarnType) {
        if (yarnType != "")
            this.yarnType = yarnType;
    }

    public void setPlysize(int newPlysize) {
        if (plySize >= 4 && plySize <= 16)
            this.plySize = newPlysize;
    }

    public void setGrams(int newGrams) {
        if (grams > 0 && grams <= 200)
            this.grams = newGrams;
    }
}