public class Engine {
    private int horsepower;
    private String type;
    private boolean isRunning;

    public Engine(int horsepower, String type) {
        setHorsepower(horsepower);
        setType(type);
        this.isRunning = false;
    }
    
   //Getters and setters 
   public void setHorsepower(int horsepower) {
    if (horsepower > 0) {
        this.horsepower = horsepower;
    } else {
        System.out.println("Invalid Horsepower.");
    }
    
   } 

   public int getHorsepower() {
    return horsepower;
   }

    public void setType(String type) {
        if (type != null && !type.isEmpty()) {
            this.type = type;
        } else {
            System.out.println("Invalid Engine Type.");
        }
   }

   public boolean isRunning() {
    return isRunning;
   }

   public String getType() {
    return type;
   }

   //Behaviors
   public void startEngine() {
    isRunning = true;
    System.out.println("Engine brooming.");
   }

   public void stopEngine() {
    isRunning = false;
    System.out.println("Engine broomed out.");
   }
}