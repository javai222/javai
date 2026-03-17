import java.util.*;
/*
* Created by Cantela, Chris Nelson B.
* Sample subclasses Buyer/Seller
* this class represents a system user, handling basic authentication
 */

public class User {
    static Scanner in = new Scanner(System.in);
    Random ran = new Random();

    // Important attributes for user
    private String userID;
    private String userName;
    private String password;
    private String email;           // cantelacb@students.nu-laguna.edu.ph
    private boolean status;
    private String userType;

    //Getter Methods
    public String getUserName() {
       return this.userName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getStatus() {
        return (this.status ? "Active" : "Inactive");
    }

    public String getType() {
        return this.userType;
    }

    public String getUserID() {
        return this.userID;
    }

    //Setter Methods
    public void setUsername(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    //Behavioral methods
    /*
    * Handles account creattion, with password authentication
    * email-based type verification
     */
    public void register ()  {
        System.out.println("\nRegister Account");
        userID = "USXR" + (ran.nextInt(1000) + 1);

        System.out.print("Enter username You would like to use: ");
        userName = in.nextLine();

        System.out.print("Enter Password: ");
        password = in.nextLine();

        //Loop until password matched
        while (true) {
            System.out.print("Confirm Password: ");
            String checkPass = in.nextLine();

            if (checkPass.equals(password)) {
                System.out.println("Password matched!");
                break;
            } else
                System.out.println("Password mismatched. Try again.");
        }

        //Ensure that email is valid
        while(true) {
            System.out.print("\nEnter Email: ");
            email = in.nextLine();

            if (verifyEmail(email)) {
                System.out.println("Email accepted");
                break;
            } else
                System.out.println("Invalid Email. Try again.");
        }

        // Assign user type based on the emaiil
        verifyUser(email);

    }

    //logic methods
    private boolean verifyEmail(String email) {
       return email.contains("@");
    }

    /*
    *Gets the domain from the email to identify the user type
    * student/staff/vendor
     */
    private void verifyUser (String email) {
        String domain;

        String studentEmail = "@students.nu-laguna.edu.ph";
        String staffEmail = "@nu-laguna.edu.ph";
        domain = email.substring(email.indexOf("@"));

        if (domain.equals(studentEmail))
            userType = "Student";
        else if (domain.equals(staffEmail))
            userType = "Staff";
        else
            userType = "Vendor";

        System.out.println("User: " + userType);
    }

    //Behavioral Methods
    //Checks the user credentials if matched it logs in the user
    public void login () {
        System.out.println("\nLogging in");


        while (true) {
            System.out.print("\nEnter Username: ");
            String enteredUsername = in.nextLine();

            System.out.print("Enter Password: ");
            String  enteredPassword = in.nextLine();

            if (userName.equals(enteredUsername) && password.equals(enteredPassword)) {
                status = true;
                System.out.println(userName + " Successfully logged in.");
                break;
            } else
                System.out.println("Invalid password of username. Login failed");
        }

    }

    //logs out the user
    public void logout () {
        status = false;
        System.out.println(userName + " logged out.");
    }

    // Overridable methods for subclasses
    public void displayRole () {          //can be overridden
        System.out.println("this method displays role and can be overridden.");
        System.out.println("Roles:  Buyer/Seller");
    }

    public void showInfo () {             //can be overridden
        System.out.println("\nName: " + userName
                        +  "\nUser ID: " + userID
                        +  "\nUser Type: " + userType
                        +  "\nStatus: " + (status ? "Active" : "Inactive")
                        +  "\nRole: Buyer");
    }


}


