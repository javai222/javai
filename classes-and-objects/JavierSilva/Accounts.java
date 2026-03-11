/*
	 * This class represents an account with a name, owner, and type.
	 * It also keeps track of the total number of accounts created.
	 * Created by Vinz Silva 
	 */

public class Accounts{
    // attributes
    String AccountName;
    String AccountOwner;
    String AccountType;
    static int TotalAccount = 0;

    // default constructor
Accounts(){
    AccountName = "Unknown";
    AccountOwner = "Unknown";
    AccountType = "Unknown";
    TotalAccount++;
}
    // parameterized constructor
Accounts (String AccountName, String AccountOwner, String AccountType){
    this.AccountName = AccountName;
    this.AccountOwner = AccountOwner;
    this.AccountType = AccountType;
    TotalAccount++;
}
    // overloaded constructor
Accounts (String AccountName, String AccountOwner){
    this.AccountName = AccountName;
    this.AccountOwner = AccountOwner;
    this.AccountType = "NU Account";
    TotalAccount++;
}
    // behavior without parameters
void AccountDisplay(){
    System.out.println ("Account Name: " + AccountName);
    System.out.println ("Name of the Owner: " + AccountOwner);
    System.out.println ("Account Type: " + AccountType);
}
    //behavior with parameters
void AccountAdd (String AddedAccount){
    AccountName = AddedAccount;
    System.out.println("Your account " + AccountName +  "has been added ");
}
    // static method
static void displayTotalAccount(){
    System.out.println("Total Accounts: " + TotalAccount);
}

}
