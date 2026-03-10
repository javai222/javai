public class Accounts{
    
    String AccountName;
    String AccountOwner;
    String AccountType;
    static int TotalAccount = 0;


Accounts(){
    AccountName = "Unknown";
    AccountOwner = "Unknown";
    AccountType = "Unknown";
    TotalAccount++;
}

Accounts (String AccountName, String AccountOwner, String AccountType){
    this.AccountName = AccountName;
    this.AccountOwner = AccountOwner;
    this.AccountType = AccountType;
    TotalAccount++;
}

Accounts (String AccountName, String AccountOwner){
    this.AccountName = AccountName;
    this.AccountOwner = AccountOwner;
    this.AccountType = "NU Account";
    TotalAccount++;
}

void AccountDisplay(){
    System.out.println ("Account Name: " + AccountName);
    System.out.println ("Name of the Owner: " + AccountOwner);
    System.out.println ("Account Type: " + AccountType);
}

void AccountAdd (String AddedAccount){
    Add = AddedAccount;
    System.out.println("Your account " + Add +  "has been added ");
}

static void displayTotalAccount(){
    System.out.println("Total Accounts: " + TotalAccount);
}

}