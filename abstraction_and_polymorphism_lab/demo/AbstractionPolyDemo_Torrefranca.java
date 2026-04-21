package demo;

import abstraction.Devilfruit_Saan;
import Implementation1.OpeOpe;
import Implementation1.YamiYami;

public class AbstractionPolyDemo_Torrefranca {

    public static void main(String[] args) {

        // Dynamic binding / polymorphism
        Devilfruit_Saan fruit;

        fruit = new OpeOpe();
        fruit.DisplayDevilfruitInfo();
        System.out.println(fruit.useAbility("Enemy"));

        System.out.println();

        fruit = new YamiYami();
        fruit.DisplayDevilfruitInfo();
        System.out.println(fruit.useAbility("Enemy"));
    }
}

// 1. What abstract class did you create?
// I created the abstract class AnimeCharacter.

// 2. What interface did you create?
// I created the interface Healable.

// 3. What methods did you override?
// I overrode usePower() from AnimeCharacter.
// I also overrode attack(), defend(), damage(), and train() from Attack
// in OpeOpe and YamiYami.

// 4. What methods did you overload?
// No overloaded method yet. (Add one if required)

// 5. Where does dynamic binding occur in your code?
// Dynamic binding occurs when:
// Devilfruit_Saan fruit = new OpeOpe();
// Devilfruit_Saan fruit = new YamiYami();
// The overridden methods run depending on the object assigned.

// 6. Which part shows polymorphism?
// Polymorphism is shown when one reference type (Devilfruit_Saan)
// is used for different objects such as OpeOpe and YamiYami.

// 7. How does your design achieve low coupling?
// Low coupling is achieved by using abstract classes and interfaces,
// so classes depend on abstractions instead of specific implementations.

// 8. How does your design achieve high cohesion?
// High cohesion is achieved because each class has one clear purpose.
// AnimeCharacter handles anime character data.
// OpeOpe and YamiYami handle devil fruit abilities.
