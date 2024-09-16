package application;

import java.util.Scanner;
import java.util.ArrayList;

import entities.Account;

public class Teste {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int selection;
		String name = "";
		ArrayList<Account> accounts = new ArrayList<>();
		//sim
		do {
			System.out.println("	BANK\n");
			System.out.println("[1] New Account");
			System.out.println("[2] Balance");
			System.out.println("[3] Deposit");
			System.out.println("[4] Withdraw");
			System.out.println("\n[0] EXIT");
			selection = sc.nextInt();
			sc.nextLine();

			switch(selection) {
			case 1:
				create_account(name, sc, accounts);
				break;
			
			case 2:
				print_account(sc, accounts);
				break;
				
			case 3:
				System.out.printf("Type your account Id: ");
				break;
			}
		} while(selection != 0);
		
		sc.close();

	}
	
	public static void create_account(String name, Scanner sc, ArrayList<Account> accounts) {
		System.out.println("\n	NEW ACCOUNT\n");
		System.out.printf("Account Name: ");
		name = sc.nextLine();
		accounts.add(new Account(name));
	}
	
	public static Account find_account(ArrayList<Account> accounts, int Id) {
		for(Account acc : accounts) {
			if(acc.getId() == Id) {
				return acc;
			}
		}
		return null;
	}
	
	public static void print_account(Scanner sc, ArrayList<Account> accounts) {
		int id;
		Account acc;
		System.out.printf("Type your account Id: ");
		id = sc.nextInt();
		sc.nextLine();
		acc = find_account(accounts, id);
		
		System.out.printf("Type your account password: ");
		if(acc.checkPassword(sc.nextLine())) {
			System.out.println(acc);
		}
		
	}

}
