/*
* This subclass is created by Plantilla and the component class is created by Silva
*/

package composition_lab;

public class LiquidSoap extends Soap {

    // attributes for LiquidSoap
    private String containerType; // bottle, pump
    private double amount; // in mL 

     // Constructor
    public LiquidSoap(String brand, String scent, int cleaningPower, String containerType, double amount) {
        super(brand, scent, cleaningPower);
        this.containerType = containerType;
        this.amount = amount;
    }

    // Getters
    public String getContainerType() {
        return containerType;
    }

    public double getAmount() {
        return amount;
    }

    // Setters
    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public void setAmount(double amount) {
        if (amount >= 0){
            this.amount = amount;
        }else{
            System.out.println("The container is empty!");
        }
    }

    // Override method
    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Container: " + containerType);
        System.out.println("Amount: " + amount + " mL");
    }

    // New behavior
    public void pumpSoap() {
        if (amount > 0) {
            System.out.println("Pumping liquid soap...");
            amount -= 5; // reduce by 5 mL per pump
        } else {
            System.out.println("No more liquid soap left!");
        }
    }
}