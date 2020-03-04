/**************************************************************
 *Name: Checking Account Tester
 *Input:None
 *Output: none
 *Description: asks the user for account number and name. Prints out different results according to the method called by user and 
 * charges extra money if transactions are over the free limit. 
 **************************************************************/
public class CheckingTester
{

	public static void main(String[] args)
	{

		//Create Checking account
		CheckingAccount ca1 = new CheckingAccount ("Raj");

		//Make deposit
		ca1.deposit(500);

		//Verify that it worked
		System.out.println("After deposit the balance is: " + ca1.getBalance()+" Expected:500");

		//Check #1
		//Test a withdrawal
		ca1.bWithdrawl(100);

		//Verify that it worked
		System.out.println("After withdrawal the balance is : " + ca1.getBalance()+ " Expected 400");

		//Check how many checks have been used 
		ca1.CheckUsed();
		System.out.println("The number of check used are: "+ ca1.CheckUsed()+(" Expected 1"));

		//Check #2
		ca1.bWithdrawl(100);
		System.out.println("After withdrawal the balance is : " + ca1.getBalance()+ " Expected 300");

		//Check 3
		ca1.bWithdrawl(100);
		System.out.println("After withdrawal the balance is : " + ca1.getBalance()+ " Expected 190");

		//Check 4
		ca1.bWithdrawl(100);
		System.out.println("After withdrawal the balance is : " + ca1.getBalance()+ " Expected 80");
		//Check how many checks have been used a
		ca1.CheckUsed();
		System.out.println("The number of check used are: "+ ca1.CheckUsed()+(" Expected 4"));
		//Check 5
		ca1.bWithdrawl(100);
		System.out.println("After withdrawal the balance is : " + ca1.getBalance()+ " Expected 80");

		//Check how many checks have been used 
		ca1.CheckUsed();
		System.out.println("The number of check used are: "+ ca1.CheckUsed()+(" Expected 4"));
	}
}
