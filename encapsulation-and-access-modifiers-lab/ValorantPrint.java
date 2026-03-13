public class ValorantPrint {
    public static void main(String[] args) {
       
       ValorantAccount account1 = new ValorantAccount("PlayerOne", "ID1234", "password123", 1000, 10, "Gold", true);


        System.out.println("Username: " + account1.getUserName());
        System.out.println("Valorant ID: " + account1.getValorantID());
        System.out.println("Valorant Points: " + account1.getValorantPoints());


        ValorantAccount newAccount = new ValorantAccount("PlayerTwo", "ID5678", "pass456", 500, 5, "Silver", true);
        System.out.println("Username: " + newAccount.getUserName());
        System.out.println("Valorant ID: " + newAccount.getValorantID());
        System.out.println("Valorant Points: " + newAccount.getValorantPoints());

        // Update the password for the new account
        newAccount.setPassWord("dustinkennethpogi");
        System.out.println("Updated Password: " + newAccount.getPassWord());

        // Prints the updated password and total accounts
        System.out.println("password: " + newAccount.getPassWord());
        System.out.println("Total Valorant Accounts Created: " + ValorantAccount.getAccountCount());
        

    }
}

