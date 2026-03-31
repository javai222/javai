package composition_lab;

public class CompositionDemoSilva {
    public static void main(String[] args) {
        // Instantiated teammate classes 
        Water waterDestroyer = new Water(1.0, 25, true );
        Brush brushWiper = new Brush("Soft", "Plastic", 5, true);
        Libag libagInvader = new Libag("Leeg", 10, true, "black" );

        // teammate classes passed to the composed class
        LibagKiller operation = new LibagKiller (waterDestroyer, brushWiper, libagInvader);

        // Call all the methods used in KilltheLibag behavior
        System.out.println("===== INTRODUCTION =====");
            operation.introduceParts();
        System.out.println("===== RISING ACTION =====");
            operation.startCleaning();
        System.out.println("===== CLIMAX =====");
            operation.destroyLibag();
        System.out.println("===== FALLING ACTION AND CONCLUSION");
            operation.reachConclusion();
}
}

/*

- What are the **HAS-A relationships**?  
The HAS-A relationships are those that have a connection with each other. It is basically 
"something containing something." In my work, the execution of the class KilltheLibag HAS-
A" water, brush, and libag.

- Which classes were reused?  
The classes reused are the water, brush, and libag. They are from my teammates and teacher
classes and I used them for my composed class.

- How does composition reduce coupling?
Composition is like an "easiest arrangement of relationship" wherein the connection of the 
classes are not directly tight. You can still modify something without restarting the rest
of your code.

- How did you implement high cohesion?  
In my work, high cohesion is implemented by focusing in one goal. The class KilltheLibag
is a class built to just show the building connection of water, brush, and libag (water and
brush will help each other to beat libag. That is the only focus or target of implementing
this code.)

- How is cohesion maintained?  
By staying in one goal for the code and not adding any useless or many types of function 
in it.

- Why is inheritance **NOT appropriate** here? 
If I used inheritance in this code, I will be suffering to modify something from the code.
Specifically on the multiplier task, wherein I need to update or change something from 
my teammates class. Inheritance will make me perform a massive changes if I modify
something from this code.

*/