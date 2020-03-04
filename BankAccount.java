
/**************************************************************
 *Name: BankAccount
 *Input:Name and account number. Deposit and withdrawal amount for methods
 *Output: None
 *Description:
 **************************************************************/
public class BankAccount implements TrackableAccount
{
	//Private Instance Variable
	private double dBalance;
	private int iAccountNum;
	private String sOwnerName;
	public static int iMaxAccount = 0;
	private String sURL;
	private String sPassword; 
	//Constructor
	public BankAccount (String sName)
	{
		iMaxAccount++;
		iAccountNum = iMaxAccount;
		sOwnerName = sName;
		sURL = "www.bankofpc.com";
		sPassword = "pcistheman";
	}
	/**************************************************************
	 *Name: deposit
	 *Input:amount of money
	 *Output: none
	 *Description: takes the amount of money and add the amount to the balance. 
	 **************************************************************/
	//Method for deposit
	public void deposit(double dMoney)
	{
		dBalance += dMoney;
	}
	/**************************************************************
	 *Name: Withdrawal
	 *Input:amount of money
	 *Output: none
	 *Description: takes the amount of money and subtracts the amount from the balance. 
	 **************************************************************/
	//Method for Withdrawal
	public boolean bWithdrawl (double dMoney)
	{
		if (dMoney <= dBalance)
		{
			dBalance -= dMoney;
			return true;
		}
		else
			return false;
	}
	//Method to get balance
	public double getBalance()
	{
		return dBalance;
	}
	//Method to get Account Number
	public int getNum()
	{
		return iAccountNum;
	}
	//Method to get the name of the owner
	public String getName()
	{
		return sOwnerName;
	}
	//Interface Method to get URL
	public String getURL()
	{
		return sURL;
	}
	//Interface Method to get user name
	public String getUsername()
	{
		String sUsername = Integer.toString(iAccountNum);
		return sUsername;
	}
	//Interface Method to get password
	public String getPassword() 
	{
		return sPassword;		
	}
}











