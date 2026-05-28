package interfacePkg;
// Interface created by Torrefranca :)))
// Interface for healing abilities
public interface Heal {

    // abstract method
    void heal();

    // default method
    default void supportSkill() {
        System.out.println("Support skill activated!");
    }
}
