public class Admin {
                                //main attributes of admin class
    String adminID;
   private String userName;
   private String password;
    String email;
    boolean status;
    static int counter;

    public Admin () {                                               //Default constructor to initialize admin attributes and generate unique adminID 
        this.userName = "Unknown";
        this.password = "Unknown";
        this.email = "Unknown";
        this.status = false;
        ++counter;
       this.adminID = "MGRX" + counter;
    }

    public Admin (String userName, String password, String email, boolean status) {   //Parameterized constructor to initialize admin attributes and generate unique adminID    
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.status = status;
        ++counter;
       this.adminID = "MGRX" + counter;
    }

public Admin (String userName, String password) {   //Overloaded constructor    
        this.userName = userName;
        this.password = password;
        ++counter;
       this.adminID = "MGRX" + counter;
    }

    void login () {                                                 //Log in method to check admin status and print appropriate message
        if (status) {
            System.out.println(userName + " logged in successfully.");
        } else {
            System.out.println(userName + " cannot log in. Account is inactive.");
        }
    }

    void displayInfo () {                                           //Method to display admin information
        System.out.println("\nAdmin ID: " + adminID
                        +  "\nUsername: " + userName 
                        +  "\nEmail: " + email
                        +  "\nStatus: " + (status ? "Active" : "Inactive")
        );
    }

     static void printCounter () {                                  //Static method to print total number of admins created
        System.out.println("Total Admins: " + counter);
    }

    public String getAdminID () {                                   //Getter methods from adminID... 
        return adminID;
    }

    public String getPassword () {
        return password;
    }

    public String getUsername () {
        return userName;
    }

    public String getStatus () {                                   //... to status
        return (status ? "Active" : "Inactive");
    }

    public void setPassword (String password) {                     //Setter methods for password and username
        this.password = password;
    }

     public void setUsername (String username) {
        this.userName = username;
    }
}

 class Main {
    public static void main(String[] args) {

        // Test default constructor
        Admin admin1 = new Admin();
        admin1.displayInfo();
        admin1.login();

        System.out.println();

        // Test parameterized constructor
        Admin admin2 = new Admin("Alice", "pass123", "alice@email.com", true);
        admin2.displayInfo();
        admin2.login();

        System.out.println();

        // Test setters
        admin1.setUsername("Bob");
        admin1.setPassword("newpass");

        // Test getters
        System.out.println("Updated Username: " + admin1.getUsername());
        System.out.println("Admin ID: " + admin1.getAdminID());
        System.out.println("Account Status: " + admin1.getStatus());

        System.out.println();

        // Display updated info
        admin1.displayInfo();

        System.out.println();

        // Test static counter
        Admin.printCounter();
    }
}