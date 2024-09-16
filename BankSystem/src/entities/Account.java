package entities;

public class Account {
	private static int lastId = 0;
	private int Id;
	private String name;
	private double balance;
	private double limit;
	private String password;
	
	public Account(String name) {
		this.Id = ++Account.lastId;
		this.name = name;
		this.balance = 0.0;
		this.limit = 1000.0;
		this.password = "0000";
	}
	
	public Account() {
	}

	public int getId() {
		return Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public double getLimit() {
		return limit;
	}
	public void setLimit(double limit) {
		this.limit = limit;
	}
	
	public void deposit(double amount) {
		balance = balance + amount;
	}
	
	public void withdraw(double amount) {
		if(balance > amount) {
			balance = balance - amount;
		}
		else {
			System.out.println("Not enough balance.\n");
		}
	}
	
	public boolean checkPassword(String password) {
		if(password.equals(this.password)) {
			return true;
		}
		return false;
	}
	
	public void changePassword(String oldPassword, String newPassword) {
		if(checkPassword(oldPassword)) {
			password = newPassword;
		}
	}
	
	public String toString() {
		return "Number: "
		+ Id
		+ "\nName: "
		+ name
		+ "\nBalance: "
		+ balance
		+"\nLimit: "
		+ limit
		+ "\nPassword: "
		+ password
		+ "\n";
	}
}
