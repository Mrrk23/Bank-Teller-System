/**************************************************************
 *Name: Saving Tester
 *Input:None
 *Output: none
 *Description: asks the user for account number and name. Prints out different results according to the method called by user
 **************************************************************/
public class SavingsTester 
{
	public static void main(String[] args)
	{
	//Create Saving Account
	SavingAccount sa1 = new SavingAccount ("Raj");

	//Test Deposit
	sa1.deposit(500);

	//Verify that it worked
	System.out.println("After deposit the balance is: " + sa1.getBalance()+"Expected:500");

	//Test a withdrawal
	sa1.bWithdrawl(100);

	//Verify that it worked
	System.out.println("After withdrawal the balance is : " + sa1.getBalance()+ "Expected 400");

	//Apply Interest
	sa1.interest();

	//Verify that it worked
	System.out.println ("After Applyinterest the balance is " + sa1.getBalance()+ "Expected 440.0");
	}

}
