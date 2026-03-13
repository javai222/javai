//obj created by dustin class created by Saan
public class printbank { 
public static void main(String[] args) { 
    // Creates a bank object with default values
    bank b1 = new bank(); 
   
    // Prints the default account details
    System.out.println("Name: " + b1.getName()); 
    System.out.println("Username: " + b1.getUserName());

    // Creates a bank object with custom values
    bank newbank = new bank("Kenneth Saan", "Kozthh", "poginaminnisirramon", 50000000); 

    // Prints the custom account details
    System.out.println("Name: " + newbank.getName()); 
    System.out.println("Username: " + newbank.getUserName());
    System.out.println("Cash: " + newbank.getCash());

    // Changes the password
    newbank.setPassWord("newpassword123");
    System.out.println("Password updated.");

    // Prints the updated password and total accounts
    System.out.println("Password: " + newbank.getPassWord());
    System.out.println("Total Accounts: " + bank.totalAccounts);
}
}