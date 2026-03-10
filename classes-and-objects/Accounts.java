Class Accounts{
    Static String Account

    String AccountName;
    String AccountOwner;
    String AccountType;
}

Accounts(){
    String AccountName = "Unknown";
    String AccountOwner = "Unknown";
    String AccountType = "Unknown";
    
}

Accounts (String AccountName, String AccountOwner, String AccountType){
    this.AccountName = AccountName;
    this.AccountOwner = AccountOwner;
    this.AccountType = AccountType;
}

Accounts (String AccountName, String AccountOwner){
    this.AccountName = AccountName;
    this.AccountOwner = AccountOwner;
    this.AccountType = "NU Account";
}

Void AccountDisplay(){
    System.out.println ("Account Name: " + AccountName);
    System.out.println ("Name of the Owner: " + AccountOwner);
    System.out.println ("Account Type: " + AccountType);
}

Void AccountAdd (String AddedAccount){
    Add = AddedAccount
    System.out.println("Your account " + Add +  "has been added ");
}





