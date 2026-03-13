import java.util.*;

/**
 * Represents a bank account with basic operations like deposit and withdrawal.
 * This class encapsulates account details and provides methods for managing balance.
 * Created by Cantela, Chris Nelson B.
 */
public class Bank {
static Scanner in = new Scanner(System.in);
Random ran = new Random();

    private String name;
    private String accountNumber;
    private  int pin;
    private double balance = 0;
    private boolean status;
    private String accountID;
    private static int counter;

    /**
     * Default constructor for Bank.
     * Initializes the account with default values.
     */
    Bank () {
        name = "Unknown";
        pin = 0;
        balance = 0;
        status = false;
        accountID = "Unknown";
        accountNumber = "Unknown";
        ++counter;
    }

    /**
     * Parameterized constructor for Bank.
     * The name of the account holder.
     * The PIN for the account.
     * The status of the account (active/inactive).
     */
    Bank (String name, int pin, boolean status) {
        ++counter;
        this.name = name;
        this.pin = pin;
         this.status = status;
         this.accountNumber = (ran.nextInt(9000) + 1000) + "";
         accountID = "BNKRX" + counter;
    }

  
     //Gets the total number of Bank accounts created.
   
     
    static int getCounter () {
        return counter;
    }

    //Gets the current balance of the account.
     
    double getBalance () {
        return this.balance;
    }

    //Gets the name of the account holder.
    
    String getName () {
        return this.name;
    }

    void setName (String name) {
        this.name = name;
    }

    void setPin () {
        System.out.print("Enter new PIN (4 digits): ");
        while (!in.hasNextInt()) {
            System.out.print("Invalid input! Please enter a number: ");
            in.next(); // discard wrong input
        }
        int pin = in.nextInt();
        while (pin < 1000 || pin > 9999) {
            System.out.print("PIN must be 4 digits (1000-9999). Try again: ");
            while (!in.hasNextInt()) {
                System.out.print("Invalid input! Please enter a number: ");
                in.next();
            }
            pin = in.nextInt();
        }
        this.pin = pin;
        System.out.println("PIN updated successfully.");
    }

    // Gets the bank ID of the account.
    
     String getBankID () {
        return this.accountID;
    }

    String getAccountNumber () {
        return this.accountNumber;
    }

    //Gets the status of the account.
    // return the status (true for active, false for inactive).
    
    String getStatus () {
        return (this.status ? "active" : "inactive");
    }

    /**
     * Validates and gets an amount entered by the user.
     * Ensures the input is a positive number.
     * return the validated positive amount.
     */
    public double validateAmount () {
        double amount = 0;
        System.out.print("\nEnter amount: ");
        while (!in.hasNextDouble()) {
            System.out.print("Invalid input! Please enter a number: ");
            in.next(); // discard wrong input
        }
        amount = in.nextDouble();
        while (amount <= 0) {
            System.out.print("Amount must be greater than 0. Try again: ");
            while (!in.hasNextDouble()) {
                System.out.print("Invalid input! Please enter a number: ");
                in.next();
            }
            amount = in.nextDouble();
        }
        return amount;
    }

    /**
     * Deposits an amount into the account.
     * Prompts the user for the amount and adds it to the balance.
     * return the new balance after deposit.
     */
    public double deposit () {
        double amount = validateAmount();
        this.balance += amount;
        return this.balance;
    }

    /**
     * Withdraws an amount from the account.
     * Prompts the user for the amount and subtracts it if sufficient balance.
     * return the new balance after withdrawal, or current balance if insufficient funds.
     */
    public double withdraw() {
        double amount = validateAmount();
        if (amount > this.balance) {
            System.out.println("Insufficient balance. Cannot withdraw more than available balance.");
            return this.balance;
        } else {
            this.balance -= amount;
            return this.balance;
        }
    }
    
    
}
