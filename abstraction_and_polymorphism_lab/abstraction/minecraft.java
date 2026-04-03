/*
*Created by Javier, Charles Justin D.
*This class provides a template for for Minecraft player actions and block interactions.
*/
package abstraction;

public abstract class minecraft {
    private String player;
    private String block;

    public minecraft(String player, String block) {
        setPlayer(player);
        setBlock(block);
    }

    // ABSTRACT METHOD 
    public abstract void performAction();

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
}