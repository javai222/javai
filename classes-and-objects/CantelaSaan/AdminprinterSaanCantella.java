//Object created Saan, Class created Cantella
public class AdminprinterSaanCantella {
     public static void main(String[] args) {
        // create an Admin using the constructor that sets all fields
        Admin superAdmin = new Admin("JuanDev", "Pass123!", "juan@laguna.edu", true);
        
        // create an Admin with only username/password (status defaults false)
        Admin moderator = new Admin("Maria_Mod", "SecureHash99");
        
        // default Admin object (all fields default values)
        Admin tempAdmin = new Admin();

        // test login behavior for each admin
        System.out.println("--- Testing Admin Logins ---");
        superAdmin.login();   // expected success
        moderator.login();    // expected failure
        
        // print information for all objects
        System.out.println("\n--- Displaying Admin Info ---");
        superAdmin.displayInfo();
        moderator.displayInfo();
        tempAdmin.displayInfo();

        // show the static counter of created Admin objects
        System.out.println("\n--- Global Statistics ---");
        Admin.printCounter();
    }
}
