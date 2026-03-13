//this class is created by Saan 
public class bank { 

// Bank account details
private String name; 
private String userName; 
private String passWord; 
private int cash; 

// Counts how many bank objects were created
public static int totalAccounts = 0;

// Default constructor
bank() { 
    this.name = "Unknown"; 
    this.userName = "Unknown"; 
    this.passWord = "Unknown";
    this.cash = 0; 
    totalAccounts++;

}

// Constructor with complete account information
bank(String name, String userName, String passWord, int cash) { 
    this.name = name; 
    this.userName = userName; 
    totalAccounts++;
    if (passWord.length() < 8) { 
        System.out.println("Password must be at least 8 characters long. Setting default password.");
        this.passWord = "default123"; 
    } else { 
        this.passWord = passWord; 
    }
    if (cash < 0) { 
        System.out.println("Cash cannot be negative. Setting cash to 0.");
        this.cash = 0; 
    } else { 
        this.cash = cash;
    }
}

// Returns the account holder's name
public String getName() { 
    return this.name; 
}

// Returns the username
public String getUserName() { 
    return this.userName; 
}

// Updates the password
public void setPassWord(String passWord) { 
    this.passWord = passWord; 
}

// Returns the current password
public String getPassWord() {
    return this.passWord;
}

// Returns the current cash amount
public int getCash() {
    return this.cash;
}












}
