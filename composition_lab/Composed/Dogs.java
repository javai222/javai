/*
*Composed class created by Tismo, Component created by Sir, Saan, and Cantela
*This was created with the help of AI
*/

package composition_lab;

public class Dogs {
    
    private String name;
    private Libag libag;
    private Brain brain;
    private Heart heart;

    //Constructor
    public Dogs (String name,  Libag libag, Brain brain, Heart heart){
        this.name = name;
        this.libag = libag;
        this.brain = brain;
        this.heart = heart;
    }

    //Display Status
    public void showStatus(){
        System.out.println("===== STATUS OF " + name.toUpperCase() + " =====");
        //Libag info
        libag.describe();
        //Brain info
        System.out.println();
        System.out.println("Brain Info: ");
        System.out.println("Cortisol Level: " + brain.getCortisolLevel());
        System.out.println("IQ: " + brain.getIQ());
        System.out.println("Sleep Hours: " + brain.getSleepHours());
        //Heart info
        heart.displayHeartStats();
    }

    //Behavior Methods
    public void takeBath(){
        System.out.println(name + " is taking a bath ^-^");

        libag.kuskos();
        libag.soak();

        //Bath = relaxing → affects heart & brain
        heart.setBpm(70);
        brain.setCortisolLevel(30);

        System.out.println(name + " is now relaxed ^-^");
    }

    public void think(){
        System.out.println(name + " is thinking...");
        brain.think();
    }

    public void panic(){
        System.out.println(name + " is panicking!!!");
        brain.panicMode();
        heart.setBpm(120);
    }

    //Getters
    public Libag getLibag(){
        return libag;
    }

    public Brain getBrain(){
        return brain;
    }

    public Heart getHeart(){
        return heart;
    }

    //Setters
    public void setLibag(Libag libag){
       this.libag = libag;
    }

    public void setBrain(Brain brain){
        this.brain = brain;
    }

    public void setHeart(Heart heart){
        this.heart = heart;
    }

}