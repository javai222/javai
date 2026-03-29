package composition_lab;

public class CompositionDemoPlantilla {
    public static void main(String[] args) {
        
        // Instantiate teammate classes
        Soap liquidSoap = new Soap("Super Clean", "Lemon", 8);
        Brush smallBrush = new Brush("Hard", "Fiber", 5, true);
        Libag superLibag = new Libag("Tires", 4, true, "Brown");
        
        Carwash carwashService = new Carwash(liquidSoap, smallBrush , superLibag);
        
        // Call methods across objects
        carwashService.displayDetails();
        carwashService.startWashing();
        carwashService.finishWash();
        

        // Replace one component to show low coupling
        Soap newSoap = new Soap("Dove", "Milk", 10);

        carwashService.setSoap(newSoap);

        // System should still work
        carwashService.startWashing();
        carwashService.finishWash();


        /*
        1. What are the HAS-A relationships?
        Carwash HAS-A Soap, Carwash HAS-A Brush, and Carwash HAS-A Libag.

        2. Which classes were reused?
        I reused Soap Class created by Silva, Brush Class by De Leon, and Libag Class by Sir Capunpon.

        3. How does composition reduce coupling?
        Composition reduces coupling because each component class has its own function and it works independently.

        4. How is high cohesion implemented?
        The high cohesion is implemented since each class have their own responsibility. Soap acts as a cleaning product, Brush serves as a scrubbing tool, 
        and Libag represents dirt. The carwash composed class manages the process of cleaning.

        5. Why is inheritance NOT appropriate here?
        Carwash is not a soap, brush, or libag so inheritance is not appropriate to use here. 
        */

    }
}