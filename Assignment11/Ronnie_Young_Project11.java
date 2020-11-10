// Project Eleven Account Classes
// Purpose: The	purpose	for	this project is	to reinforce the knowledge learned in
// Chapter 11.
// Objectives:
// 1. Write	base class and derived classes
// 2. Apply	theory of polymorphism

/*
* @author: Ronnie Young
* @version 11.10.20
*/

public class Ronnie_Young_Project11{
    public static void main(String[] args){
        // Create Account, SavingsAccount and Checking Account objects
		Account account = new Account(1122, 20000);
		SavingsAccount savings = new SavingsAccount(1001, 20000);
		CheckingAccount checking = new CheckingAccount(1004, 20000);
		// Set interest rate of 4.5%
		account.setInterestRate(4.5);
		savings.setInterestRate(4.5);
		checking.setInterestRate(4.5);

		// Withdraw $2,500
		account.withdraw(2500);
		savings.withdraw(2500);
		checking.withdraw(2500);

		// Deposit $3,000
		account.deposit(3000);
		savings.deposit(3000);
		checking.deposit(3000);

		// Invoke toString methods
		System.out.println(account.toString());
		System.out.println(savings.toString());
		System.out.println(checking.toString());

    }
}

class Account {
	// Data fields
	private int id;
	private double balance;
	private static double InterestRate;

	//Create a default account
	Account() {
		this(0, 0);
	}

    //Create an account
	Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
		InterestRate = 0;
	}



	// set interest rate
    // Set balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Return balance
    public double getBalance() {
        return balance;
    }

    // Set id
    public void setId(int id) {
        this.id = id;
    }

    // Return id
    public int getId() {
        return id;
    }

    //Increase balance by deposit amount
    public void deposit(double amount) {
        balance += amount;
    }

    //Decrease balance by withdrawl amount
    public void withdraw(double amount) {
        balance -= amount;
    }

    //Return a string description of account class
    public String toString() {
        return "\nAccount ID: " + id
            + "\nBalance: $" + String.format("%.2f", balance) +
            "\nInterest: $" + String.format("%.2f", getInterestRate());
    }
	public void setInterestRate(double InterestRate) {
        this.InterestRate = (1 + (InterestRate / 100));
	}



	// return interest rate
	public double getInterestRate() {
        return InterestRate;
    }
}







class CheckingAccount
	extends Account {
    // Create a default checking account object.
	public CheckingAccount() {
		super();
	}

    //Create a checking account with id and balance.
	public CheckingAccount(int id, double balance) {
		super(id, balance);
	}

    //Withdraw amount
	public void withdraw(double amount) {
		if (getBalance() - amount > 0) {
			setBalance(getBalance() - amount);
		}
		else
			return;
	}

    // Return a string of checking account class
	public String toString() {
		return super.toString();
	}
}

class SavingsAccount
	extends Account {

	// Create a default savings account object
	public SavingsAccount() {
		super();
	}

    //Create a savings account with id and balance.
	public SavingsAccount(int id, double balance) {
		super(id, balance);
	}

    //Verify amount does not break withdrawl rules and withdraw
	public void withdraw(double amount) {
		if (getBalance() - amount > 500 && amount < getBalance()) {
			setBalance(getBalance() - amount);
		}
		else
			return;
    }

}