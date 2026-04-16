/*
*Created by Javier, Charles Justin D.
*This class provides a template for for Minecraft player actions and block interactions.
*/
package abstraction;

public abstract class minecraft {
    private String player;
    private String block;
    private int health;
    private int hunger;

    public minecraft(String player, String block, int health, int hunger) {
        setPlayer(player);
        setBlock(block);
        setHealth(health);
        setHunger(hunger);
    }

    // ABSTRACT METHOD 
    public abstract void performAction();
    public abstract void healthStatus();
    public abstract void hungerStatus();
    public abstract void destroy(String string);
    public abstract void build(String string);

    // CONCRETE METHOD 
    public void displayInfo() {
        System.out.println("Player: " + player);
        System.out.println("Block: " + block);
    }

    // Getters
    public String getPlayer() {
        return player;
    }

    public String getBlock() {
        return block;
    }

    public int getHealth() {
        return health;
    }

    public int getHunger() {
        return hunger;
    }

    // Setters with validation
    public void setPlayer(String player) {
        if (player == null || player.trim().isEmpty()) {
            System.out.println("Invalid player name. Setting to 'Unknown Player'.");
            this.player = "Unknown Player";
        } else {
            this.player = player;
        }
    }

    public void setBlock(String block) {
        if (block == null || block.trim().isEmpty()) {
            System.out.println("Invalid block type. Setting to 'Default Block'.");
            this.block = "Default Block";
        } else {
            this.block = block;
        }
    }

    public void setHealth(int health) {
        if(health < 1 || health > 5) {
            System.out.println("Low health detected.");
            this.health = health;
        } else if(health > 5 && health <= 10) {
            this.health = health;
        }
        else { 
            System.out.println("High health detected.");
            this.health = health;
        }
        }

    public void setHunger(int hunger) {
        if(hunger < 1 || hunger > 5) {
            System.out.println("Need to eat soon.");
            this.hunger = hunger;
     }  else if(hunger > 5 && hunger <= 10) {
            this.hunger = hunger; 
            System.out.println("Hunger level is moderate."); }
        else {
            System.out.println("Stomach is full");
            this.hunger = hunger;
        }
}

  
}
   
