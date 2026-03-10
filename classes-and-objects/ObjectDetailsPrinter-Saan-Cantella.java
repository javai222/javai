public class ObjectDetailsPrinter {
    public static void main(String[] args) {
        
        Admin superAdmin = new Admin("JuanDev", "Pass123!", "juan@laguna.edu", true); // // create an Admin using the constructor that sets all fields
     
        Admin moderator = new Admin("Maria_Mod", "SecureHash99"); // // create an Admin with only username/password (status defaults false)
        
        Admin tempAdmin = new Admin(); // default Admin object (all fields default values)

        System.out.println("--- Testing Admin Logins ---"); // test login behavior for each admin
        superAdmin.login();
        moderator.login();
        
        System.out.println("\n--- Displaying Admin Info ---"); // print information for all objects
        superAdmin.displayInfo();
        moderator.displayInfo();
        tempAdmin.displayInfo();

        System.out.println("\n--- Global Statistics ---");// show the static counter of created Admin objects
        Admin.printCounter();
    }
}

