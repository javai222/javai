/* this implementation is created by Kenneth Saan */

package Implementation1; 

import abstraction.minecraft;
import interfacePkg.Playable;


public class Steve extends minecraft implements Playable {

    // Steve character setup
    public Steve(String player, String block, int health, int hunger) {
        super(player, block, health, hunger);
    }
   
    // Steve mines blocks
    @Override
    public void performAction() {
        System.out.println(getPlayer() + " is mining " + getBlock() + " with a pickaxe.");
    }

    // Shows Steve's health
    @Override
    public void healthStatus() {
        System.out.println(getPlayer() + "'s health is at " + getHealth() + " points.");
    }

    // Shows Steve's hunger
    @Override
    public void hungerStatus() {
        System.out.println(getPlayer() + "'s hunger is at " + getHunger() + " points.");
    }

    // Steve builds a block structure
    @Override
    public void build(String block) {
        setBlock(block);
        System.out.println(getPlayer() + " is building with " + getBlock());
    }

    public void build(String block, String structure) {
        setBlock(block);
        System.out.println(getPlayer() + " is building a " + structure + " with "
                + getBlock());
    }
  
    // Steve destroys blocks
    @Override
    public void destroy(String block) {
        setBlock(block);
        System.out.println(getPlayer() + " is destroying " + getBlock());
    }

    // Steve plays the game
    @Override
    public void play() {
        System.out.println(getPlayer() + " is playing Minecraft and building structures with " + getBlock() + ".");
       
    }
   
}