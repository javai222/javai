package interfacePkg;

//Interface:
public interface ReverseCursedTechnique {
    
    //Core healing
    void heal(int amount);

    //Stronger healing
    void reviveTarget(String target);

    //Insert JJk narrator and explains 
    default void explainRCT(){
        System.out.println("RCT converts negative cursed energy into positive energy for healing.");
    }

    //Self healing
    default void selfHeal(){
        System.out.println("User performs self-healing using RCT.");
    }
}