package application;

import java.util.Scanner;
import java.util.ArrayList;

import entities.Account;

public class Teste {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mainSelection, loggedSelection = 1;
		boolean logged = false;
		Account acc = null;
		String name = "";
		ArrayList<Account> accounts = new ArrayList<>();

		do {

			do {
				main_menu();
				mainSelection = sc.nextInt();
				sc.nextLine();

				switch (mainSelection) {
				case 1:
					// create new account
					acc = create_account(name, sc, accounts);
					System.out.println("Your id is: " + acc.getId());
					System.out.println("Your password is '0000'\n");
					break;

				case 2:
					// sign in account
					System.out.printf("Type your account Id: ");
					int id = sc.nextInt();
					sc.nextLine();
					acc = signin_account(sc, accounts, id);
					if (acc != null) {
						logged = true;
					}

					break;

				}
			} while (mainSelection != 0 && logged == false);

			while (logged == true) {
				logged_menu();
				loggedSelection = sc.nextInt();
				sc.nextLine();

				switch (loggedSelection) {
				case 1:
					// print account informations
					System.out.println(acc);
					break;

				case 2:
					// deposit
					System.out.printf("Type the amount of the deposit: R$");
					acc.deposit(sc.nextDouble());
					sc.nextLine();
					break;

				case 3:
					// withdraw
					System.out.printf("Type the amount of the withdraw: R$");
					acc.withdraw(sc.nextDouble());
					sc.nextLine();
					break;
				case 4:
					// change password
					System.out.printf("Type your current password: ");
					String current_password = sc.nextLine();
					System.out.printf("Type your new password: ");
					String new_password = sc.nextLine();
					acc.changePassword(current_password, new_password);
					break;
				case 0:
					// logout
					logged = false;
					break;
				}
			}
		} while (mainSelection != 0);

		sc.close();
	}

	public static void main_menu() {
		System.out.println("	BANK\n");
		System.out.println("[1] New Account");
		System.out.println("[2] Sign in");
		System.out.println("\n[0] EXIT");
	}

	public static void logged_menu() {
		System.out.println("	BANK\n");
		System.out.println("[1] Account Info");
		System.out.println("[2] Deposit");
		System.out.println("[3] Withdraw");
		System.out.println("[4] Change Password");
		System.out.println("\n[0] Sign out");
	}

	public static Account create_account(String name, Scanner sc, ArrayList<Account> accounts) {
		Account acc;
		System.out.println("\n	NEW ACCOUNT\n");
		System.out.printf("Account Name: ");
		name = sc.nextLine();
		acc = new Account(name);
		accounts.add(acc);
		return acc;
	}

	public static Account find_account(ArrayList<Account> accounts, int Id) {
		for (Account acc : accounts) {
			if (acc.getId() == Id) {
				return acc;
			}
		}
		return null;
	}

	public static Account signin_account(Scanner sc, ArrayList<Account> accounts, int id) {
		Account acc;

		acc = find_account(accounts, id);

		System.out.printf("Type your account password: ");
		if (acc.checkPassword(sc.nextLine())) {
			System.out.println("Hello " + acc.getName());
			return acc;
		} else {
			return null;
		}
	}
}
