/*
* 
* Created by Dustin Elijah Mercado
*/
public class BankorantKaisen {
    public static void main(String[] args) {

        // Create one Bank object
        Bank acc1 = new Bank("Chris Nelson", 1234, true);

        // Create one Sorcerer object
        sorcerer s1 = new sorcerer("Kozth", 120, 80, 90, 110);

        // Display Bank details
        System.out.println("===== Bank Account =====");
        System.out.println("Name: " + acc1.getName());
        System.out.println("Account Number: " + acc1.getAccountNumber());
        System.out.println("Bank ID: " + acc1.getBankID());
        System.out.println("Status: " + acc1.getStatus());

        // Deposit example
        acc1.deposit();
        System.out.println("Balance: " + acc1.getBalance());

        // Display Sorcerer details
        System.out.println("\n===== Sorcerer Info =====");
        s1.updateSchool("Calamba Jujutsu High");
        s1.displayStatus();
    }
}
// This code is made with help of AI