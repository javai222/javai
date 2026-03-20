//this class is created by Kenneth Saan
public class Vehicle {
	// Basic vehicle details
     private String brand; 
     private String type; 
     private int wheels; 
     private int horsePower; 
     private double fuel; 

	// Runtime state values
     private int speed; 
     private boolean engine;
     
     
	// Default constructor with placeholder values
	public Vehicle() { 
    	 
    	 this.brand = "Unknown"; 
    	 this.type = "Unknown"; 
    	 this.wheels = 0; 
    	 this.horsePower = 0; 
    	 this.fuel = 0.0;   	 
     }
   
	// Constructor for setting all core details at once
	public Vehicle(String brand, String type, int wheels, int horsePower, double fuel) { 
    	 
    	 this.brand = brand; 
    	 this.type = type; 
    	 this.wheels = wheels; 
    	 this.horsePower = horsePower; 
    	 this.fuel = fuel; 
     }
     
	// --- GETTERS (Accessors) ---
	public String getBrand() { return brand; }
     public String getType() { return type; }
     public int getWheels() { return wheels; }
     public int getHorsePower() { return horsePower; }
     public double getFuel() { return fuel; }
     public int getSpeed() { return speed; }
     public boolean isEngine() { return engine; } 
     
     // --- SETTERS (Mutators) ---
     public void setBrand(String brand) { 
         this.brand = brand; 
     }

     public void setType(String type) { 
         this.type = type; 
     }

     public void setWheels(int wheels) {
         if (wheels >= 0) { // Simple validation
             this.wheels = wheels;
         }
     }

     public void setHorsePower(int horsePower) {
         this.horsePower = horsePower;
     }
     
     public void setFuel(double fuel) { 
    	 if(fuel >= 0) { 
    		 this.fuel = fuel;
    	 } 
    	 else { 
    		 System.out.println("Fuel cannot be negative");
    	 }
     }
     public void setSpeed(int speed) { 
    	 this.speed = speed; 
    	 
     }
     
	// Starts the engine
	public void start() { 
		System.out.println("Engine start-Brrom brrom"); 
		engine = true; 
		
	}
	
	// Stops the engine
	public void stop() { 
		System.out.println("Engine off"); 
		engine = false; 
	}
	
	// Increases speed only when engine is on
	public void accelerate() { 
		if(engine) { 
		System.out.println("Engine start-Brrom brrom"); 
		speed += 10; } 
		
		else { System.out.println("Engine is off"); } 
	}
	
	// Plays horn sound if engine is on
	public void honk() { 
		if(engine) { 
			System.out.println("BEEEP BEEEEP!!!!");
		} 
		else { System.out.println("Your engine is off"); } 
	}
}
