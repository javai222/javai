// This program is assisted with AI
// This object is created by Javier, Charles Justin
// Test class to test both ValorantAccount and bank
public class testobjbank {

    public static void main(String[] args) {

        // Object for ValorantAccount
        ValorantAccount acc1 = new ValorantAccount(
                "TenZ",
                "TenZ#NA1",
                "secure123",
                5000,
                45,
                "Radiant",
                true
        );

        // Object for bank
        bank b1 = new bank(
                "TenZ",
                "tenz_user",
                "bankpass123",
                100000
        );

        // Testing ValorantAccount
        System.out.println("===== VALORANT ACCOUNT =====");
        System.out.println("Username: " + acc1.getUserName());
        System.out.println("Valorant ID: " + acc1.getValorantID());
        System.out.println("VP: " + acc1.getValorantPoints());
        System.out.println("Password: " + acc1.getPassWord());
        System.out.println("Total Valorant Accounts: " + ValorantAccount.getAccountCount());

        System.out.println();

        // Testing Bank Account
        System.out.println("===== BANK ACCOUNT =====");
        System.out.println("Name: " + b1.getName());
        System.out.println("Username: " + b1.getUserName());
        System.out.println("Cash: " + b1.getCash());

        // Change bank password
        b1.setPassWord("newsecurepass");
        System.out.println("Updated Password: " + b1.getPassWord());

        System.out.println("Total Bank Accounts: " + bank.totalAccounts);
    }
}