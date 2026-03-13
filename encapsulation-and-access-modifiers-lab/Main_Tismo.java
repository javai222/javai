public class Main_Tismo {
    public static void main(String[] args) {
        /*
        Object created by Tismo, Class created by Silva
        This was created with a bit of help from AI
        */

		//object created using default constructor
		Account acc1 = new Account();
		//object created using overloaded constructor
		Account acc2 = new Account ("tismoye@students.nu-laguna.edu.ph", 
				"Yvette Tismo", "MaineVet_0725");
		//object created using parameterized constructor
		Account acc3 = new Account ("MaineYvee", "Yvette Tismo", 
			"GitHub Account", "MaineVet_0725", true);
		
		//display for account 1
		System.out.println("***** ACCOUNT 1 *****");
		System.out.println("Account name: " + acc1.getAccountName());
		System.out.println("Owner's name: " + acc1.getAccountOwner());
		System.out.println("Account type: " +	acc1.getAccountType());
		System.out.println("Password: " + acc1.getAccountPassword());
		System.out.println("Active status: " + acc1.getisActive());
		System.out.println();
		//trying the validations and invalid inputs in account 1
		acc1.setAccountName("");
		acc1.setAccountType("NU Account");
		acc1.setAccountPassword("");
		acc1.setisActive(true);
		System.out.println("Account name: " + acc1.getAccountName());
		System.out.println("Account type: " +	acc1.getAccountType());
		System.out.println("Password: " + acc1.getAccountPassword());
		System.out.println("Active status: " + acc1.getisActive());
		System.out.println();
		
		//display for account 2
		System.out.println("***** ACCOUNT 2 *****");
		System.out.println("Account name: " + acc2.getAccountName());
		System.out.println("Owner's name: " + acc2.getAccountOwner());
		System.out.println("Account type: " +	acc2.getAccountType());
		System.out.println("Password: " + acc2.getAccountPassword());
		System.out.println("Active status: " + acc2.getisActive());
		
		System.out.println();
		
		//display for account 3
		System.out.println("***** ACCOUNT 3 *****");
		System.out.println("Account name: " + acc3.getAccountName());
		System.out.println("Owner's name: " + acc3.getAccountOwner());
		System.out.println("Account type: " +	acc3.getAccountType());
		System.out.println("Password: " + acc3.getAccountPassword());
		System.out.println("Active status: " + acc3.getisActive());
		
		//display total no. of accounts created
		System.out.println("__________________________________________");
		Account.displayTotalAccount();
	}
}