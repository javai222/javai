/*1. What is the IS-A relationship in this program?
  Buyer IS-A User because Buyer extends User.
 
 2. Which method was overridden?
  The Buyer class overrides displayRole() and showInfo() from User.
 
 3. What happens during dynamic binding?
  If a User reference points to a Buyer object, calls to overridden methods
  (such as displayRole() or showInfo()) execute the Buyer version at runtime.
 
 4. What methods were inherited from the parent class?
  Buyer inherits public methods from User, such as login(), logout(),
  getUserName(), getEmail(), getStatus(), getType(), and getUserID().
 
  What new behavior did the subclass introduce?
  Buyer adds shopping features like addToCart(), checkout(), and
  setPaymentMethod(), along with Buyer-specific fields (cart, balance, points).
 
  */
 public class Main_Saan {
    public static void Main_Saan(String[] args) {
        
        // 1. Create a generic User object (The Parent)
        // Using the manual constructor: User(username, password, email)
        User admin = new User("Systemkenneth", "pogi123", "saankr@nu-laguna.edu.ph");
        System.out.println("--- Generic User Created ---");
        admin.showInfo();

        // 2. Create a Buyer object (The Child)
        // Note: It inherits generateID() and login() from User
        Buyer studentBuyer = new Buyer("ChrisNelson", "Pass123", "cantelacb@students.nu-laguna.edu.ph");
        System.out.println("\n--- Buyer Object Created ---");
        
        // Use inherited login method
        // (In a real run, you'd type the credentials in the console)
        studentBuyer.login(); 
        
        // Use unique Buyer methods
        studentBuyer.addToCart("Scientific Calculator", 850.0);
        studentBuyer.addToCart("NU Hoodie", 1200.0);
        studentBuyer.checkout();
        studentBuyer.showInfo();

        // 3. Create a Seller object (The Child)
        // Note: This one has an extra parameter for the Store Name
        Seller schoolVendor = new Seller("NationalBookstore", "NBS2026", "nbs@vendor.com", "NBS Laguna Branch");
        System.out.println("\n--- Seller Object Created ---");
        
        // Use unique Seller methods
        schoolVendor.addProduct("Ballpen (Black)");
        schoolVendor.addProduct("Yellow Paper");
        
        // Simulate a sale
        schoolVendor.processSale("Yellow Paper", 50.0);
        schoolVendor.updateRating(4.5);
        schoolVendor.showInfo();
    }
}