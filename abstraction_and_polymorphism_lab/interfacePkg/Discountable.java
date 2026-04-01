//created by Cantela, Chris Nelson B.
package interfacePkg;

interface Discountable {
    //Abstract method to apply a discount to the amount
    public double applyDiscount(double amount);

    
    //Default method to calculate the amount saved from the original price
    default double calculateSave(double amount) {
        return amount - applyDiscount(amount);
    }
}