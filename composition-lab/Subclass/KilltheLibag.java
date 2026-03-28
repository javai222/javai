/*
* This class represents composed class
* Created by Vinz Joseph R. Silva
* Used classes of Capunpon (libag), Plaantilla (Water), Brush (De Leon)
*/
package composition-lab
public class KilltheLibag {

    // Attributes
    private Water water;
    private Brush brush;
    private Libag libag;

    // Constructors
public KilltheLibag (Water water, Brush brush, Libag libag){
    this.water = water;
    this.brush = brush;
    this.libag = libag;
}
    // Getter methods
public Water getWater () {
    return water;
}

public Brush getBrush () {
    return brush;
}

public Libag getLibag () {
    return libag;
}

    //Setter method
public void setWater (Water water){
    this.water = water;
}

public void setBrush (Brush brush){
    this.brush = brush;
}

public void setLibag (Libag libag){
    this.libag = libag;
}

    // behaviors (actions)
public void introduceParts () {
    water.display(); // will display the traits of water that will be used in fighting libag
    brush.describe(); // will showcase the capacity of the brush to obliterate any single libag
    libag.describe(); // will exhibit the characteristics of libag in this manner
}

public void startCleaning () {
    water.pour(); // starts pouring the water to cleanse the libag area
    libag.soak(); // the libag will soak and the thickness will melt slowly
    brush.wearOut(); // We cannot use this brush because its already worn out. Needed a new one
}

public void destroyLibag () {
    brush.replace();  // brand new brush that will destroy libag
    libag.kuskos(); // libag slowly falling off
    water.pour();   // pour more water to washed off libag
    libag.soak();   // libag slowly falls off as water and brush combine their behaviors
}

public void reachConclusion () {
    water.pour(); // pour it in the container
    water.drink(); // drink it for hydration after battling with libag
}
}