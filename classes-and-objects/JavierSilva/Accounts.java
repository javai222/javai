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
    boolean isActive;
    static int TotalAccount = 0;

    // default constructor
    Accounts(){
        AccountName = "Unknown";
        AccountOwner = "Unknown";
        AccountType = "Unknown";
        isActive = false;
        TotalAccount++;
    }

    // parameterized constructors
    Accounts(String AccountName, String AccountOwner, String AccountType){
        this.AccountName = AccountName;
        this.AccountOwner = AccountOwner;
        this.AccountType = AccountType;
        this.isActive = true;
        TotalAccount++;
    }

    // overloaded constructor (default active)
    Accounts(String AccountName, String AccountOwner){
        this.AccountName = AccountName;
        this.AccountOwner = AccountOwner;
        this.AccountType = "NU Account";
        this.isActive = true;
        TotalAccount++;
    }

    // overloaded constructor with active flag
    Accounts(String AccountName, String AccountOwner, String AccountType, boolean isActive){
        this.AccountName = AccountName;
        this.AccountOwner = AccountOwner;
        this.AccountType = AccountType;
        this.isActive = isActive;
        TotalAccount++;
    }

    // behavior without parameters
    void AccountDisplay(){
        System.out.println("Account Name: " + AccountName);
        System.out.println("Name of the Owner: " + AccountOwner);
        System.out.println("Account Type: " + AccountType);
        System.out.println("Account Active: " + (isActive ? "Yes" : "No"));
    }

    // behavior with parameters
    void AccountAdd(String AddedAccount){
        AccountName = AddedAccount;
        System.out.println("Your account " + AccountName + " has been added");
    }

    // allow logging in (checks active state)
    void login(){
        if (isActive) {
            System.out.println("Login successful for " + AccountOwner + " (" + AccountName + ")");
        } else {
            System.out.println("Login failed: account " + AccountName + " is not active.");
        }
    }

    // display information (wrapper for AccountDisplay)
    void displayInfo() {
        AccountDisplay();
    }

    // static method
    static void displayTotalAccount(){
        System.out.println("Total Accounts: " + TotalAccount);
    }

    // alias for displayTotalAccount
    static void printCounter(){
        displayTotalAccount();
    }

}
