// What is the IS-A relationship?
// HondaCivic IS-A vehicle

// Which method was overridden?
// The accelerate() method was overridden in HondaCivic

// What happens during dynamic binding?
// Even if the reference type is vehicle,
// the actual object's method (HondaCivic) is executed at runtime.

// What methods were inherited from the parent class?
// start(), stop(), honk(), getters and setters

// What new behavior did the subclass introduce?
// enableSportMode() and disableSportMode()

public class Main_Mercado {

    public static void main(String[] args) {

        // Dynamic Binding
        vehicle v1 = new HondaCivic(180, 40);

        v1.start();       // inherited
        v1.accelerate();  // overridden version (HondaCivic)
        v1.honk();

        System.out.println();

        // Direct object usage
        HondaCivic civic = new HondaCivic(200, 50);
        civic.start();
        civic.enableSportMode();
        civic.accelerate();
    }
}