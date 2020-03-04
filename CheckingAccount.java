/**************************************************************
 *Name: Checking Account
 *Input:Name and account number
 *Output: none
 *Description: asks the user for account number and name. Later, it adds the Transaction fee if user have used 
 *all the free transactions and return the balance with fee if necessary. 
 **************************************************************/
public class CheckingAccount  extends BankAccount
{
	//Private Instance Variable
	private double dTransFee;
	private int iFreeCheckPerMonth;
	private int iNumChecks;
	//Constructor
	public CheckingAccount(String sName)
	{
		super(sName);
		dTransFee = 10;
		iFreeCheckPerMonth = 2;
		iNumChecks=0;
	}
	/**************************************************************
	 *Name: bWithdrawl
	 *Input:Amount
	 *Output: none
	 *Description: asks the user for amount that needs to be withdraw. Later, it adds the Transaction fee if user have used 
	 *all the free transactions and return the balance with fee if necessary. 
	 * @return 
	 **************************************************************/
	//Overriding method from the Bank Account Class and adding fee
	public boolean bWithdrawl (double dMoney)
	{
		//Check if we need to add fee or not 
		if (iNumChecks<iFreeCheckPerMonth)
		{
			//Checks If the transaction is successful or not
			//if it is successful, it will increment the number of checks
			//and it will decrement the number of free checks
			if (super.bWithdrawl(dMoney))
			{
				iNumChecks++;
				return true;
			}
			else 
				return false;
		}
		else 
		{
			if(super.bWithdrawl(dMoney + dTransFee))
			{
				iNumChecks++;
				return true;
			}
			else 
				return false; 
		}
	}
	//Prints how many checks are left
	public int FreeChecksLeft ()
	{		
		return iFreeCheckPerMonth; 
	}	
	//Prints how many checks have been used
	public int CheckUsed ()
	{
		return iNumChecks;
	}
}
