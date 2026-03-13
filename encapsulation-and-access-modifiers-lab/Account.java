/*
	 * This class represents an account with a name, owner, and type.
	 * It also keeps track of the total number of accounts created.
	 * Created by Vinz Silva 
	 */

public class Account {
    // attributes
    private String AccountName;
    private String AccountOwner;
    private String AccountType;
    private String AccountPassword;
    boolean isActive;
    static int TotalAccount = 0;

    // default constructor
    public Account() {
        AccountName = "Unknown";
        AccountOwner = "Unknown";
        AccountType = "Unknown";
        AccountPassword = "Unknown";
        isActive = false;
        TotalAccount++;
    }

    // parameterized constructors
    public Account(String AccountName, String AccountOwner, String AccountType, String AccountPassword) {
        this.AccountName = AccountName;
        this.AccountOwner = AccountOwner;
        this.AccountType = AccountType;
        this.AccountPassword = AccountPassword;
        this.isActive = isActive;
        TotalAccount++;
    }

    // overloaded constructor
    public Account(String AccountName, String AccountOwner, String AccountPassword){
        this.AccountName = AccountName;
        this.AccountOwner = AccountOwner;
        this.AccountType = "NU Account";
        this.AccountPassword = AccountPassword;
        this.isActive = false;
        TotalAccount++;
    }
    // getter methods

    public String getAccountName () {
        return this.AccountName;
    }
    public String getAccountOwner () {
        return this.AccountOwner;
    }
    public String getAccountType () {
        return this.AccountType;
    }

    public String getAccountPassword () {
        return this.AccountPassword;
    }

    public boolean getisActive () {
        return this.isActive;
    }

    // setter methods with validation 

    public void setAccountName (String AccountName) {
        if (AccountName != "" ) 
        this.AccountName = AccountName;
    }

    public void setAccountOwner (String AccountOwner ) {
        if (AccountOwner != "")
        this.AccountOwner = AccountOwner;
    }

    public void setAccountType (String AccountType) {
        // object invariant = NU account is the only accepted account
        if (AccountType.equals ("NU Account")) {
         this.AccountType = AccountType;
        } else {
        System.out.println("Please use your NU Account!");
        }
    }

    public void setAccountPassword(String AccountPassword) {
        if (AccountPassword != "")
        this.AccountPassword = AccountPassword;
    }

    public void setisActive(Boolean isActive) {
        if (AccountPassword == "" && AccountName == ""){
            this.isActive = true;
        } else {
            this.isActive = false;
        }
    }
    // static method
    public static void displayTotalAccount () {
        System.out.println("Total Accounts: " + TotalAccount);
    }

}

// This code is made with the help of AI





    