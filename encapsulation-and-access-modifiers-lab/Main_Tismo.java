public class Main_Tismo {
    public static void main(String[] args) {
        /*
        Object created by Tismo, Class created by Silva and Casapao
        This was created with a bit of help from AI
        */

		System.out.println("============== S I L V A ' S  C L A S S ==============\n");
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
		//trying the validations and invalid inputs
		System.out.println("**Updating Account 1**");
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
		
		System.out.println();
		System.out.println("============== C A S A P A O ' S  C L A S S ==============\n");
		//object created using default constructor
		Productt p1 = new Productt();
		//object created using overloaded constructor
		Productt p2 = new Productt("Tennis Ball", 100);
		//object created using parameterized constructor
		Productt p3 = new Productt("Backpack", 200, "Jansport", 5);
		
		//display product 1
		System.out.println("***** Product 1 *****");
		p1.displayProduct();
		System.out.println();
		
		//display product 2
		System.out.println("***** Product 2 *****");
		p2.displayProduct();
		System.out.println();
		
		//display product 3 and trying sellProduct method
		System.out.println("***** Product 3 *****");
		p3.displayProduct();
		p3.sellProduct(2);
		System.out.println();
		
		//trying the validations and invalid inputs
		System.out.println("**Updating Product 3**");
		p3.setName("");
		p3.setPrice(1);
		p3.setBrand("");
		p3.setStock(-1);
		p3.sellProduct(7);
		System.out.println();
		
		p3.displayProduct();
		
		//display total no. of objects created
		System.out.println("__________________________________________");
		Productt.printTotalObjects();
	}
}