package demo;

import abstraction.Devilfruit_Saan;
import abstraction.HieHieNoMi;
import abstraction.MeraMeraNoMi;
import interfacePkg.Attack;

public class AbstractionPolyDemoConel {

    public static void main(String[] args) {

        // ✅ Runtime Polymorphism
        Devilfruit_Saan fruit1 = new MeraMeraNoMi();
        Devilfruit_Saan fruit2 = new HieHieNoMi();

        System.out.println("=== DEVIL FRUIT INFO ===");
        fruit1.DisplayDevilfruitInfo();
        fruit2.DisplayDevilfruitInfo();

        System.out.println("\n=== ABILITIES ===");
        System.out.println(fruit1.useAbility("Enemy"));
        System.out.println(fruit2.useAbility("Enemy"));

        // ✅ Interface Polymorphism
        System.out.println("\n=== COMBAT ===");

        Attack atk1 = (Attack) fruit1;
        Attack atk2 = (Attack) fruit2;

        atk1.attack();
        atk1.defend();
        atk1.damage();
        atk1.train();
        atk1.ultimateAttack();

        System.out.println();

        atk2.attack();
        atk2.defend();
        atk2.damage();
        atk2.train();
        atk2.ultimateAttack();
    }
}
/*

What abstract class did you create?
- I created the abstract class named Stand.

What interface did you create?
- I created the interface class named Fight.

What methods did you override?
- I overrode getDescription(), useAbility(), and getWeakness() from the Devilfruit_Saan class.
- I also overrode attack(), defend(), damage(), and train() from the Attack interface.
- Additionally, I overrode ultimateAttack() in the HieHieNoMi class.

What methods did you overload?
- No methods were overloaded in this implementation.

Where does dynamic binding occur in your code?
- Dynamic binding occurs when methods like useAbility() and DisplayDevilfruitInfo() are called
  using the Devilfruit_Saan reference. Java determines at runtime whether to execute the
  MeraMeraNoMi or HieHieNoMi implementation.

Which part shows polymorphism?
- Polymorphism is shown through method overriding (runtime polymorphism), where the same
  methods behave differently depending on the object (MeraMeraNoMi and HieHieNoMi).
- It is also shown using interface references (Attack), where different classes implement
  the same set of methods.

How does your design achieve low coupling?
- The main program depends only on the Devilfruit_Saan abstract class and Attack interface,
  so new Devil Fruit classes can be added without modifying existing code.

How does your design achieve high cohesion?
- Each class focuses on a single responsibility. MeraMeraNoMi handles fire abilities,
  while HieHieNoMi handles ice abilities, making the design organized and focused.
*/