package javaproject2;
import java.util.Scanner;

abstract class DesertItem {

	abstract public int getCost();
}

class Candy extends DesertItem {
	int items = 0;

	public int addCandies(int candies) {
		return items += candies;
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return items * 60;
	}
}

class Cookie extends DesertItem {
	int items = 0;

	public int addCookies(int candies) {
		return items += candies;
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return items * 70;
	}
}

class IceCream extends DesertItem {
	int items = 0;

	public int addIceCreams(int candies) {
		return items += candies;
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return items;
	}
}

public class Assignment2Q7 {
	public static void main(String[] args) {
		Assignment2Q7 run = new Assignment2Q7();
		run.selectRoles();
	}

	private void selectRoles() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Owner /Customer ?");

		String value = sc.nextLine();
		roles(value);
	}

	private void roles(String role) {
		if (role.equals("Owner")) {
			addItems();
		} else if (role.equals("Customer")) {
			placeOrder();
		} else {
			System.out.println("Wrong Input!");
		}
	}

	private void addItems() {
		System.out.println("press 1 for Candy.");
		System.out.println("press 2 for Cookie.");
		System.out.println("press 3 for Ice-Cream.");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		addItemsOperation(a);

	}

	Candy can = new Candy();
	Cookie coo = new Cookie();
	IceCream ice = new IceCream();

	private void addItemsOperation(int choice) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of DesertItem want to add:");
		int a = sc.nextInt();
		if (choice == 1) {
			can.addCandies(a);
			selectRoles();
		} else if (choice == 2) {

			coo.addCookies(a);
			selectRoles();
		} else if (choice == 3) {

			ice.addIceCreams(a);
			selectRoles();
		}
	}

	private void placeOrder() {
		System.out.println("press 1 for Candy.");
		System.out.println("press 2 for Cookie.");
		System.out.println("press 3 for Ice-Cream.");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		placeOrderOperation(a);
	}

	private void placeOrderOperation(int choice) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of DesertItem want to place:");
		int a = sc.nextInt();
		if (choice == 1) {
			if (can.items > a) {
				System.out.println("Order Place!");
				
				} else {
				System.out.println(a + " Candy is not avalaible!");
			}
			selectRoles();
		} else if (choice == 2) {
			if (coo.items > a) {
				System.out.println("Order Place!");
				
			} else {
				System.out.println(a + " Cookie is not avalaible!");
			}
			selectRoles();
		} else if (choice == 3) {
			if (ice.items > a) {
				System.out.println("Order Place!");
			} else {
				System.out.println(a + " IceCream is not avalaible!");
			}
			selectRoles();
		}
	}
}