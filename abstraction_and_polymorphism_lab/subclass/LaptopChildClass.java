/*
*Created by Mance, John Roque R.
*This class provides the child class of Laptop
*/

package subclass;

import abstraction.Laptop;
import interfacePkg.ConnectableLaptop;

public class LaptopChildClass extends Laptop implements ConnectableLaptop {
    // Constructor
    public LaptopChildClass(String brand, int stock) {
        computer(brand, stock);
    }
    // Method Overriding
    @Override
    public void performTask() {
        System.out.println(getBrand() + " shows latest laptop model ");
    }
}