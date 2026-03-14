// This object created by Dolormente, class created by Casapao(Products) and Silva(Account)

public class Main_Dolormente {
  public static void main(String[] args) {
                                                                      // - - - - - > a1 Default constructor
  Account a1 = new Account();
                                                                      // - - - - - > a2 Overloaded constructor
  Account a2 = new Account("dolormentehs@students.nu-laguna.edu.ph", "Henry Dolormente", 
                           "NU Account", "HenryDolormente_", true);
                                                                      // - - - - - > a3 Parameterized constructor
  Account a3 = new Account("hsdolormente@students.nu-laguna.edu.ph", "Dolormente Henry", 
                           "DolormenteHenry_");
  
  System.out.println("= = = = = Account Class Stress Tester = = = = =\n"
                    + "= = = Account a1 = = ="                         // - - - - - > Displays account 1
                    + "Account name: " + a1.getAccountName()
                    + "\nAccount owner: " + a1.getAccountOwner()
                    + "\nAccount type: " + a1.getAccountType()
                    + "\nAccount password: " + a1.getAccountPassword()
                    + "\nActivity status: " + a1.getisActive());
  System.out.println("\n= = = Updating a1 Account = = =\n");            // - - - - - > Trying the validations and invalid inputs
                    a1.setAccountName("")
                    a1.setAccountOwner("")
                    a1.setAccountType("NUIS Account")
                    a1.setAccountPassword("")
                    a1.setisActive(true)
  System.out.println("\nAccount name: " + a1.getAccountName()
                    + "\nAccount owner: " + a1.getAccountOwner()
                    + "\nAccount type: " + a1.getAccountType()
                    + "\nAccount password: " + a1.getAccountPassword()
                    + "\nActivity status: " + a1.getisActive());
    
  System.out.println("\n= = = Account a2 = = =\n"                      // - - - - - > Displays account 2
                    + "Account name: " + a2.getAccountName()
                    + "\nAccount owner: " + a2.getAccountOwner()
                    + "\nAccount type: " + a2.getAccountType()
                    + "\nAccount password: " + a2.getAccountPassword()
                    + "\nActivity status: " + a2.getisActive());
  System.out.println("\n= = = Updating a2 Account = = =\n");              // - - - - - > Trying the validations and invalid inputs
                    a1.setAccountName("tismoye@students.nu-laguna.edu.ph")
                    a1.setAccountOwner("Yvette Tismo")
                    a1.setAccountType("Github account")
                    a1.setAccountPassword("2029Baby")
                    a1.setisActive(false)
  System.out.println("\nAccount name: " + a1.getAccountName()
                    + "\nAccount owner: " + a1.getAccountOwner()
                    + "\nAccount type: " + a1.getAccountType()
                    + "\nAccount password: " + a1.getAccountPassword()
                    + "\nActivity status: " + a1.getisActive());

  System.out.println("\n= = = Account a3 = = =\n"                      // - - - - - > Displays account 3
                    + "Account name: " + a3.getAccountName()
                    + "\nAccount owner: " + a3.getAccountOwner()
                    + "\nAccount type: " + a3.getAccountType()
                    + "\nAccount password: " + a3.getAccountPassword()
                    + "\nActivity status: " + a3.getisActive()
 System.out.println("\n= = = Updating a3 Account = = =\n");            // - - - - - > Trying the validations and invalid inputs
                    a1.setAccountName("")
                    a1.setAccountOwner("")
                    a1.setAccountType("")
                    a1.setAccountPassword("2029Baby")
                    a1.setisActive(true)
 System.out.println("\nAccount name: " + a1.getAccountName()
                    + "\nAccount owner: " + a1.getAccountOwner()
                    + "\nAccount type: " + a1.getAccountType()
                    + "\nAccount password: " + a1.getAccountPassword()
                    + "\nActivity status: " + a1.getisActive());
  System.out.println("__________________________________________");
  Account.displayTotalAccount();                                      // - - - - - > Displays total # of accounts created.

  Productt p1 = new Productt();                                       // - - - - - > Default constructor

  Productt p2 = new Productt("Tennis Ball", 100);                     // - - - - - > Overloaded constructor

  Productt p3 = new Productt("Backpack", 200, "Jansport", 5);         // - - - - - > Parameterized constructor

  System.out.println("= = = Product p1 = = =");                       // - - - - - > Displays product 1
  p1.displayProducttt();
  
  System.out.println("= = = Product p2 = = =");                       // - - - - - > Displays product 2
  p2.displayProduct();

  System.out.println("= = = Product p3 = = =");                        // - - - - - > Displays product 3 and trying the sellProduct method
  p3.displayProduct();
  p3.sellProduct(2);

  System.out.println("= = = = = Updating Product 3 = = = = ="          // - - - - - > Trying the validations and invalid inputs
                    + p3.setName("")
                    + p3.setPrice(1)
                    + p3.setBrand("")
                    + p3.setStock(-1)
                    + p3.sellProduct(7));
  p3.displayProduct();
    
  System.out.println("__________________________________________");    // - - - - - > Display total # of objects created.
  Productt.printTotalObjects();
    
  }
}
