import java.util.ArrayList;
import java.util.Scanner;
/**************************************************************
 *Name: Branch Class
 *Input:None
 *Output: None
 *Description: Prompts the Branch menu and functions according to the options selected by user from branch menu.
 **************************************************************/
public class BranchClass
{
	//Arraylist for bank account which will store all the bank accounts
	ArrayList<BankAccount> ba1 = new ArrayList<BankAccount>();
	Scanner scConsole = new Scanner (System.in);
	//Method for Menu
	public void branchMenu()
	{
		boolean bContinue = true;
		//prompts user with multiple options from bank menu
		while (bContinue)
		{			
			System.out.println ("Welcome to State Bank of India!");
			System.out.println ("1. Open an Account");
			System.out.println ("2. Deposit Money");
			System.out.println ("3. Withdrawal");
			System.out.println ("4. Apply Interest to one specific Savings Account");
			System.out.println ("5. Apply Interest to all Savings accounts");
			System.out.println ("6. Get Balance");
			System.out.println ("7. Remove an Account");
			System.out.println ("8. Number of Free Checks Left");
			System.out.println ("9. Number of checks used for Checking Account");
			System.out.println ("10. Information of specific Account");
			System.out.println ("11. Information of all Accounts");
			System.out.println("12. Exit");
			//Takes your choice and according it will give output
			System.out.println("\n\n Enter your Choice please:");
			//Takes the response and converts it to integer
			String sResponse = scConsole.nextLine();
			int iResponse = Integer.parseInt(sResponse);
			//Create new Checking and/or Saving Account
			if (iResponse == 1)
			{
				System.out.println("What type of account do you wants to open? ");
				System.out.println("       1. Checking");
				System.out.println("       2. Savings");
				String sAccountType = scConsole.nextLine();
				int iResponse1 = Integer.parseInt(sAccountType);
				//Creates Saving Account
				if (iResponse1 == 2)
				{
					System.out.println("Please enter the name of the owner");
					String sName = scConsole.nextLine();
					//Creates Saving account instance and adds it to the array list
					SavingAccount sa1= new SavingAccount(sName);
					ba1.add(sa1);
					System.out.println(sName+" your Savings account has been created successfully!");
					System.out.println (("Your account number is ")+sa1.getNum());
					System.out.println("");
					continue;
				}
				//Creates Checking Account
				if (iResponse1 == 1)
				{
					System.out.println("Please enter the name of the owner");
					String sName = scConsole.nextLine();
					//Creates Checking account instance and adds it to the array list
					CheckingAccount ca1= new CheckingAccount(sName);
					ba1.add(ca1);
					System.out.println(sName+" Your checking account has been created successfully");
					System.out.println (("Your account number is ")+ca1.getNum());
					System.out.println("");
				}
				continue;
			}
			//Deposits the money in the account and prints out the updated balance
			else if (iResponse == 2)
			{
				//Converts the account number to integer
				System.out.println("Please enter the account number ");
				String sResponseNum = scConsole.nextLine();
				int iResponseNum = Integer.parseInt(sResponseNum);
				//Checks if account exists using find account number method
				int iAccount=findAccountNumber(iResponseNum);
				//If account doesn't exist, it will return the error
				if (iAccount == -1)
				{
					System.out.println(("The entered account number does not exist"));
				}
				else 
				{
				//if account does exists, it will ask for the amount
				System.out.println("How much money would you like to deposit?");
				String sResponse1 =  scConsole.nextLine();
				double dAmount = Double.parseDouble(sResponse1);
				//deposits the money in the account
				ba1.get(iAccount).deposit(dAmount);
				//prints out the success of the transaction
				System.out.println("Your Money has been successfully deposited to account Number " + iResponseNum);
				System.out.println("");
				System.out.println(" Your current balance is " + ba1.get(iAccount).getBalance());
				System.out.println("");
				continue;
				}
			}
			//Withdraws the money from the account and prints out the updated balance
			else if (iResponse == 3)	
			{
				//Converts the account number to integer
				System.out.println(("Please enter the account number to withdraw money: "));
				String sResponseNum = scConsole.nextLine();
				int iResponseNum = Integer.parseInt(sResponseNum);
				//Checks if account exists using find account number method
				int iAccount=findAccountNumber(iResponseNum);
				//If account doesn't exist, it will return the error
				if (iAccount == -1)
				{
					System.out.println(("The entered account number does not exist"));
				}
				//if account exists asks for the amount
				else
				{
				System.out.println("How much money would you like to Withdraw?");
				String sResponse1 =  scConsole.nextLine();
				double dAmount = Double.parseDouble(sResponse1);
				//Withdraws the money from the account
				ba1.get(iAccount).bWithdrawl(dAmount);
				System.out.println("Your current balance is " + ba1.get(iAccount).getBalance());
				System.out.println("");
				}
				continue;
			}
			//Applies the interest to the SPECIFIC Savings Account and prints out updated balance
			else if (iResponse == 4)
			{
				//Asks and Converts the account number to integer
				System.out.println("Please enter the account number");
				String sResponseNum = scConsole.nextLine();
				int iResponseNum = Integer.parseInt(sResponseNum);
				//Checks if account exists using find account number method
				int iAccount=findAccountNumber(iResponseNum);
				//if account exists applies the interest rate
				((SavingAccount)ba1.get(iAccount)).interest();
				//prints out the success of the transaction
				System.out.println("The interest has been successfully applied to your account number: " + iResponseNum);
				System.out.println("Your current balance is " + ba1.get(iAccount).getBalance());
				System.out.println("");
				continue;
			}
			//Applies interest to EVERY savings account in the system of branch class
			else if (iResponse == 5)
			{
				//Loops through the array list and for every instance of
				//savings account, it applies the interest
				for (int i = 0; i<ba1.size();i++)
				{
					if (ba1.get(i) instanceof SavingAccount)
					{
						((SavingAccount)ba1.get(i)).interest();
					}
				}
				System.out.println("The interest has been successfully applied to all the savings account! " );
				System.out.println("");
				continue;
			}
			//Prints out the current balance
			else if (iResponse == 6)
			{
				//Asks for the account number
				System.out.println("Please enter the account number");
				String sResponseNum = scConsole.nextLine();
				int iResponseNum = Integer.parseInt(sResponseNum);
				int iAccount=findAccountNumber(iResponseNum);
				//call the method get balance from bank account class
				ba1.get(iAccount).getBalance();
				//prints out the balance
				System.out.println("Your balance for account number " + iResponseNum + " is " + ba1.get(iAccount).getBalance());
				System.out.println("");
				continue;
			}
			//Removes an account 
			else if(iResponse == 7)
			{
				//asks for the account number 
				System.out.println("Please enter the account number");	
				String sResponseNum = scConsole.nextLine();
				int iResponseNum = Integer.parseInt(sResponseNum);
				//calls the method remove account
				RemoveAccount(iResponseNum);
				//prints out the success of removing account
				System.out.println("Your Account has been removed. ");
				System.out.println("");
			}
			//Prints out total free checks left in Checking account
			else if(iResponse == 8)
			{
				//asks for the account number 
				System.out.println("Please enter the account number");
				String sResponseNum = scConsole.nextLine();
				int iResponseNum = Integer.parseInt(sResponseNum);
				//Checks if account exists
				int iAccount=findAccountNumber(iResponseNum);
				//calls free check left method from checking class
				int iCheck = ((CheckingAccount)ba1.get(iAccount)).FreeChecksLeft();
				System.out.println("Your Checking Account has "+ iCheck +" free checks");
				System.out.println("");
			}
			//Prints out total checks used in Checking account
			else if(iResponse == 9)
			{
				//asks for the account number 
				System.out.println("Please enter the account number");
				String sResponseNum = scConsole.nextLine();
				int iResponseNum = Integer.parseInt(sResponseNum);
				//Checks if account exists
				int iAccount=findAccountNumber(iResponseNum);
				//calls check used method from checking class
				int iCheck = ((CheckingAccount)ba1.get(iAccount)).CheckUsed();
				System.out.println("Your Checking Account has used "+ iCheck +" checks");
				System.out.println("");
			}
			//Prints out information about specific bank account number
			else if(iResponse == 10)
			{
				printAccount();
				System.out.println("");
			}
			//Prints out information about all the account numbers
			else if (iResponse == 11)
			{
				printAllAccount();
				System.out.println("");
			}
			//Pressing any other number will end the loop
			else 
			{
				bContinue = false;
			}
		}
	}
	/**************************************************************
	 *Name: Find Account Number
	 *Input:Account Number
	 *Output: Index of the account number
	 *Description: Tries to find an account number and return index of the account number if account exists. 
	 **************************************************************/
	public int findAccountNumber (int iNum)
	{
		//if account number matches the number received from get number method it will return its index
		for (int i = 0; i<ba1.size();i++)
		{
			if (ba1.get(i).getNum()==iNum)
			{
				return (i);
			}
		}	
		return -1;
	}
	/**************************************************************
	 *Name: Remove account
	 *Input:Account Number
	 *Output:None
	 *Description: Find the account and removes the account from array list
	 **************************************************************/
	//Method to remove the account from the Arraylist/record
	public void RemoveAccount (int iNum)
	{
		int iIndex = findAccountNumber(iNum);
		{	
			ba1.remove(iIndex);
		}
	}
	/**************************************************************
	 *Name: print all account
	 *Input:None
	 *Output:None
	 *Description: Prints out the list of every account with its detail from the array list
	 **************************************************************/
	public void printAllAccount ()
	{
		for (int i = 0; i<ba1.size();i++)
		{
			System.out.println("Account number is " + ba1.get(i).getNum());
			System.out.println("The name of the account's owner is " + ba1.get(i).getName());
			System.out.println("Balance for this account number is " + ba1.get(i).getBalance());
			if (ba1.get(i) instanceof CheckingAccount)
			{
				int iCheck = ((CheckingAccount)ba1.get(i)).FreeChecksLeft();
				System.out.println("Your Checking Account has "+ iCheck +" free checks");
				int iCheck1 = ((CheckingAccount)ba1.get(i)).CheckUsed();
				System.out.println("Your Checking Account has used "+ iCheck1 +" checks");
				System.out.println("");
			}
		}
	}
	/**************************************************************
	 *Name: Print account
	 *Input:none
	 *Output: None
	 *Description:Prints details about one specific bank account 
	 **************************************************************/
	//Method to print out information about one specific account
	public void printAccount()
	{
		System.out.println("Please enter the account number");
		String sResponseNum = scConsole.nextLine();
		int iResponseNum = Integer.parseInt(sResponseNum);
		//Checks if account exists
		int iAccount=findAccountNumber(iResponseNum);
		//prints out the balance
		String sOwnerName =  ba1.get(iAccount).getName();
		System.out.println("Your account number is " + iResponseNum);
		//System.out.println("The type of the account is "+)
		System.out.println("The name of the account's owner is " + sOwnerName);
		System.out.println("Your balance for account number " + iResponseNum + " is " + ba1.get(iAccount).getBalance());
		if (ba1.get(iAccount) instanceof CheckingAccount)
		{
			int iCheck = ((CheckingAccount)ba1.get(iAccount)).FreeChecksLeft();
			System.out.println("Your Checking Account has "+ iCheck +" free checks");
			int iCheck1 = ((CheckingAccount)ba1.get(iAccount)).CheckUsed();
			System.out.println("Your Checking Account has used "+ iCheck1 +" checks");
		}	
	}
}