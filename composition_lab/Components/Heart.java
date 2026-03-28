/**
 * This class represents the heart component for the Bulldogs Markethub system
 * Created by Kenneth R. Saan
 */

package composition_lab;

public class Heart {

 // Core heart state fields
 private int bpm; 
 private String heartHealth; 
 boolean isHeartbeat;  
 private int Caffein;
 
 // Default constructor initializes an inactive/critical heart state
 Heart() { 
	 this.bpm = 0; 
	 this.heartHealth = "bad"; 
	 this.isHeartbeat = false; 
	 this.Caffein = 0; 
 }
	
 // Parameterized constructor for creating a custom heart profile
 Heart(int bpm, String heartHealth, boolean isHeartbeat, int caffeine) { 
	 this.bpm = bpm; 
	 this.heartHealth = heartHealth; 
	 // Pulse is derived from bpm value
	 if(bpm > 0) { 
		 isHeartbeat = true; 
	 } 
	 else { isHeartbeat = false; }
	 
	 this.Caffein = caffeine;
	 } 
	 

	 public void setBpm(int bpm) {
	        // Update beats-per-minute
	        this.bpm = bpm;
	        // Logic: if there's a pulse, heartbeat is true
	        this.isHeartbeat = (bpm > 0);
	        
	        // Update health text based on bpm range
	        if (bpm > 60 && bpm < 100) {
	            this.heartHealth = "Healthy";
	        } else if (bpm == 0) {
	            this.heartHealth = "Critical/Stopped";
	        }
	    }

	 public void setcaffein(int Caffein) { 
	 
	 	 // Reject invalid caffeine values
	 
		 if(Caffein <0) { 
			System.out.print("invalid");
			return; 
		 }
		 
		 // Save caffeine amount and adjust bpm feedback
		 this.Caffein = Caffein;
		 
		 if(Caffein <35) { 
			  System.out.println("Low Caffein");
			  this.bpm = 60;
              this.heartHealth = "Healthy";
              this.isHeartbeat = true;
		  }
			 
		  else { System.out.println("high Caffein");
		  this.bpm = 100;
            this.heartHealth = "Stressed";
            this.isHeartbeat = true;
	 }  
		  }
	 
	 
	 
	    public int getBpm() {
	        return bpm;
	    }

	    public String getHeartHealth() {
	        return heartHealth;
	    }

	    // Returns true when a pulse is present
	    public boolean hasPulse() {
	        return isHeartbeat;
	    }
	    
	    // Compact status string for quick logs/debugging
	    public String toString() {
	        return String.format("Heart Status: [BPM: %d, Health: %s, Active: %b]", 
	                             bpm, heartHealth, isHeartbeat);
	    }
	    
	    /**
	     * Prints a formatted dashboard of the heart's current state.
	     */
	    public void displayHeartStats() {
	        System.out.println("\n************************************");
	        System.out.println("      HEART COMPONENT DASHBOARD      ");
	        System.out.println("************************************");
	        
	        // Use an if-else to show a "visual" rhythm status
	        if (isHeartbeat) {
	            System.out.println("  Status: [ ACTIVE ]  <3 <3 <3");
	        } else {
	            System.out.println("  Status: [ INACTIVE ]  ----------");
	        }

	        System.out.println("  Current BPM:    " + this.bpm);
	        System.out.println("  Health Rating:  " + this.heartHealth);
	        System.out.println("  Caffeine Load:  " + this.Caffein + " mg");
	        
	        // Adding a logical warning inside the display
	        if (this.bpm > 120) {
	            System.out.println("  !! ALERT: Tachycardia Detected !!");
	        } else if (this.bpm > 0 && this.bpm < 50) {
	            System.out.println("  !! ALERT: Bradycardia Detected !!");
	        }
	        
	        else {System.out.println("Normal heartbeat");}
            
	        System.out.println("************************************\n");
	    }
	
}
 
