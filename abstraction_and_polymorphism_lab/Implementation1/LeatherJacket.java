/*
*Subclass created by Tismo, Abstraction and Interface Class created by Casapao
*Created with the help of AI
*/
package Implementation1;

import abstraction.Leather;
import interfacePkg.Wearable;

public class LeatherJacket extends Leather implements Wearable {
    //Constructor
    public LeatherJacket (String leatherType, String leatherTexture) {
        super(leatherType, leatherTexture);
    }

    //Method overriding
    @Override
    public void describe(){
        System.out.println("This is a "+getleatherTexture()+" "+getleatherType()+ "jacket.");
    }

    @Override
    public void wear(){
        System.out.println("You are now wearing the leather jacket.");
    }

    //Method overloading
    public void describe(String jacketStyle, boolean detailed){
        if (detailed)
            System.out.println("This is a "+getleatherTexture()+" "+getleatherType()+ jacketStyle);
        else
            describe();
    }
}