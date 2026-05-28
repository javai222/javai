// Interface created by Dolormente, Henry II S.

package interfacePkg;

public interface Skill {

    // Abstract method
    void useSkill();

    // Default method
    default void showSkillType() {
        System.out.println("This is a basic character skill.");
    }
}
