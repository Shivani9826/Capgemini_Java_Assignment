package javaassignment4;

import java.util.ArrayList;

public class Assignment4Q2 {
	Assignment4Q2(int a, String b) {
		totalPrice = a;
		status = b;
	}

	private int totalPrice;
	private String status;

	// ArrayList<Assignment4Q2>=return type
	public static ArrayList<Assignment4Q2> listOfOrders(ArrayList<Assignment4Q2> orders) {
		ArrayList<Assignment4Q2> al = new ArrayList<Assignment4Q2>();
		// Assignment4Q2 demo;
		// for (int i = 0; i < orders.size(); i++) {
		// demo = orders.get(i);
		orders.forEach(order -> {
			if (order.totalPrice > 10000
					&& (order.status.equalsIgnoreCase("Accepted") || order.status.equalsIgnoreCase("Completed"))) {
				al.add(order);
			}
		});

		return al;
	}

	public static void main(String[] args) {
		ArrayList<Assignment4Q2> al = new ArrayList<Assignment4Q2>();
		Assignment4Q2 one = new Assignment4Q2(100000, "Accepted");
		Assignment4Q2 two = new Assignment4Q2(100, "Accepted");
		Assignment4Q2 three = new Assignment4Q2(200000, "Hi");
		Assignment4Q2 four = new Assignment4Q2(150000, "Completed");
		Assignment4Q2 five = new Assignment4Q2(1000, "Hello");
		al.add(one);
		al.add(two);
		al.add(three);
		al.add(four);
		al.add(five);
		ArrayList<Assignment4Q2> res = new ArrayList<Assignment4Q2>();
		res = listOfOrders(al);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i).totalPrice + " " + res.get(i).status);
		}
	}

}
