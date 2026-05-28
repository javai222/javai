//child class created by Casapao, parent class made by Tismo

public class MilkChocolate extends Chocolate {
    public MilkChocolate(String flavor, String type, String shape) {
        super(flavor, type, shape);
    }

    // behavior 
    public void sweetLevel() {
        System.out.println("This milk chocolate is sweeter and creamier.");
    }

    // Overridden method
    @Override
    public void packaging() {
        System.out.println("The milk chocolate is wrapped in pink foil.");
    }
}