/**************************************************************
 *Name: Saving Account
 *Input:Name and account number
 *Output: none
 *Description: asks the user for account number and name. Later, it adds the interest and return the balance with interest. 
 **************************************************************/
public class SavingAccount extends BankAccount
//Private Instance Variables
{
	private double dInterest = .1;
//Constructor
public SavingAccount(String sName) 
{
	super(sName);	
}
//Method to count interest 
//Deposits money and takes balance times the interest as a parameters
	public void interest()
	{
		super.deposit(dInterest*super.getBalance()); 
	}
}
