package Implementation1;

import abstraction.minecraft;
import interfacePkg.Playable;

public class Alex extends minecraft implements Playable {

     // Alex character setup
    public Alex(String player, String block, int health, int hunger) {
        super(player, block, health, hunger);
    }
   
    // Alex mines blocks
    @Override
    public void performAction() {
        System.out.println(getPlayer() + " is collecting resources from " + getBlock() + " with a stone axe.");
    }

    // Shows Alex's health
    @Override
    public void healthStatus() {
        if (getHealth() >= 8) {
            System.out.println(getPlayer() + " is healthy and ready to explore.");
        } else if (getHealth() >= 4) {
            System.out.println(getPlayer() + " has moderate health and should be careful.");
        } else {
            System.out.println(getPlayer() + " is low on health and should recover soon.");
        }
    }
    // Shows Alex's hunger
    @Override
    public void hungerStatus() {
       if (getHunger() >= 8) {
            System.out.println(getPlayer() + " is full and can keep building.");
        } else if (getHunger() >= 4) {
            System.out.println(getPlayer() + " is a bit hungry and should find food.");
        } else {
            System.out.println(getPlayer() + " is starving and needs to eat immediately.");
        }
       }
    
    // Alex builds a block structure
    @Override
    public void build(String block) {
        setBlock(block);
        System.out.println(getPlayer() + " is building a shelter using " + getBlock());
    }

    // Overloaded build method for custom structures
    public void build(String block, String structure) {
        setBlock(block);
        System.out.println(getPlayer() + " is constructing a " + structure + " with "
                + getBlock());
    }
  
    // Alex destroys blocks
    @Override
    public void destroy(String block) {
        setBlock(block);
        System.out.println(getPlayer() + " is clearing " + getBlock() + " to make room for a new build.");
    }

    // Alex plays the game
    @Override
    public void play() {
        System.out.println(getPlayer() + " is exploring caves and crafting tools with " + getBlock() + ".");
       
    }
}
