public class ObjectDetailsPrinter {
    public static void main(String[] args) {
        
        Admin superAdmin = new Admin("JuanDev", "Pass123!", "juan@laguna.edu", true);
        
        Admin moderator = new Admin("Maria_Mod", "SecureHash99");
        
        Admin tempAdmin = new Admin();

        System.out.println("--- Testing Admin Logins ---");
        superAdmin.login();
        moderator.login();
        
        System.out.println("\n--- Displaying Admin Info ---");
        superAdmin.displayInfo();
        moderator.displayInfo();
        tempAdmin.displayInfo();

        System.out.println("\n--- Global Statistics ---");
        Admin.printCounter();
    }
}

