// The child class was created by De Leon
// The parent class was created by Dolormente

/*
1. What is the IS-A relationship in your program?
ANSWER: This line of code shows the IS-A relationship because an Electric Car is a Car

2. Which method was overridden?
ANSWER: The method that was overridden is car()

3. What happens during dynamic binding?
ANSWER: During dynamic binding, the car() in the child class runs instead of the parent’ class at runtime

4. What methods were inherited from the parent class?
ANSWER: The methods inherited from the parent class are displayCarSpecs() and ignitionOn()

5. What new behavior did the subclass introduce?
ANSWER: The child class introduced the new behavior chargeBattery()

*/

// Inheritance Demo Program
    public static void main(String[] args) {
        ElectricCar ec = new ElectricCar("Tesla", "Model 3", "Alloy Wheels", "Electric Motor", "Silent Exhaust", 100);
        ec.displayCarSpecs(); // Inherited from Car Parent Class
        ec.ignitionOn();      // Inherited from Car Parent Class
        ec.car();             // Overridden in ElectricCar
        ec.chargeBattery();   // New behaviors
    }