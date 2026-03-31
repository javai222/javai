package composition_lab;

public class CompositionDemoBalanon {
    public static void main(String[] args) {

        //Create Libag object
        Libag libag = new Libag("kilikili", 8, true, "dark gray");

        //Create Brush object
        Brush brush = new Brush("hard", "fiber", 7, false);

        //Create Keyboard object
        Keyboard keyboard = new Keyboard("Razer", "Black", "Mechanical");

        //Create CleaningSystem (COMPOSITION)
        CleaningSystem system = new CleaningSystem(libag, brush, keyboard);

        //Use the system
        system.startCleaning();

        System.out.println(); 

        system.testKeyboard();
    }
}


/*
1. WHAT ARE THE HAS-A RELATIONSHIPS?
- CleaningSystem HAS-A Libag, Brush, and Keyboard (it uses them as objects).

2. WHICH CLASSES WERE REUSED?
- Libag, Brush, and Keyboard were reused inside CleaningSystem.

3. HOW DOES COMPOSITION REDUCE COUPLING?
- CleaningSystem only uses the public methods of other classes, so changes in them don't break it.

4. HOW DID YOU IMPLEMENT HIGH COHESION?
- Each class has a clear purpose and does one job only.

5. HOW IS COHESION MAINTAINED?
- Cohesion is maintained by keeping related methods in the same class.

6. WHY IS INHERITANCE NOT APPROPRIATE HERE?
- Inheritance is not used because CleaningSystem is NOT a type of Libag, Brush, or Keyboard.
*/
