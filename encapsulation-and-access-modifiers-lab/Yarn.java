public class Yarn {
    /*
	*This class represents yarn orders with colors, ply size, and grams
	*Created by Yvette Germaine Tismo
	*/
	    
	//Private attributes of the yarn
	private String color;
	private String yarnType;
	private int plySize;//must be no less than 4 but not greater than 16 grams
	private int grams; //must be no less than 20 grams but not greater than 200 grams
	    
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
	    //validation
	    if (color != "")
	        this.color = color;
	}

	public void setYarnType(String yarnType) {
	    //validation
	    if (yarnType != "")
	        this.yarnType = yarnType;
	}

	public void setPlysize(int newPlysize) {
	    //Object Invariant  ply size should be at least 4 but not greater than 16
	    if (plySize >= 4 && plySize <= 16) {
	        this.plySize = newPlysize;
	    } else 
	    	System.out.println("Invalid Input.");
	}

    public void setGrams(int newGrams) {
	    //Object Invariant  grams should be at least 20 but not greater than 200
	    if (grams >= 20 && grams <= 200) {
	        this.grams = newGrams;
	    } else 
	        System.out.println("Invalid Input.");
	}
	    
	public static void displayTotalOrders() {
	    System.out.println("Total yarn orders: " + totalYarn);
	}
}
