// this object is created by Torrefranca and class by Mercado
public class PrintGPUObj {
    public static void main(String[] args) {

        // Object using default constructor
        GPU gpu1 = new GPU();
        gpu1.displayDetails();

        System.out.println();

        // Object using overloaded constructor
        GPU gpu2 = new GPU("ASUS");
        gpu2.setModel("RTX 4060");
        gpu2.displayDetails();

        System.out.println();

        // Object using parameterized constructor
        GPU gpu3 = new GPU("MSI", "RTX 4070");
        gpu3.displayDetails();

        System.out.println();

        // Display total products created
        GPU.displayTotalProducts();
    }
}