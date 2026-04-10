/*
*Subclass created by Tismo, Abstraction and Interface Class created by Casapao
*/
package Implementation;

import abstraction.Leather;
import interfacePkg.Wearable;

public class LeatherBag extends Leather implements Wearable {
    //Constructor
    public LeatherBag (String leatherType, String leatherTexture) {
        super(leatherType, leatherTexture);
    }

    //Method overriding
    @Override
    public void describe(){
        System.out.println("This is a "+getleatherTexture()+" "+getleatherType()+ " bag.");
    }

    @Override
    public void wear(){
        System.out.println("You are now wearing the leather bag.");
    }

    //Method overloading
    public void describe(String bagStyle, boolean detailed){
        if (detailed)
            System.out.println("This is a "+getleatherTexture()+" "+getleatherType()+bagStyle);
        else
            describe();
    }
}