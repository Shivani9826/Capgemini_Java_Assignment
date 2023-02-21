package com.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Trader {
	private String name;
	private String city;

	public Trader(String name, String city) {
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}
}

public class Assignment5Q3 {
	public static List<String> printUniqueCities(List<Trader> traders) {
		return traders.stream().map(Trader::getCity).distinct().collect(Collectors.toList());
	}

	public static List<String> tradersFromPuneSortByName(List<Trader> traders) {
		return traders.stream().filter(t -> t.getCity().equals("Pune")).map(Trader::getName).sorted()
				.collect(Collectors.toList());
	}

	public static String allTrader3Names(List<Trader> traders) {
		return traders.stream().map(Trader::getName).sorted().reduce("", (n1, n2) -> n1 + n2);
	}

	public static ArrayList<Trader> areAnyTradersFromIndore(ArrayList<Trader> traders) {
		return traders.stream().filter(t -> t.getCity().equals("Indore"))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public static void main(String[] args) {
		// Sample data
		ArrayList<Trader> traders = new ArrayList<>();
		traders.add(new Trader("Alice", "New York"));
		traders.add(new Trader("Bob", "New York"));
		traders.add(new Trader("Charlie", "London"));
		traders.add(new Trader("David", "London"));
		traders.add(new Trader("Eve", "Pune"));
		traders.add(new Trader("Frank", "Pune"));

		// 1. Unique cities
		System.out.println("Unique cities: " + printUniqueCities(traders));

		// 2. Traders from Pune sorted by name
		System.out.println("Traders from Pune sorted by name: " + tradersFromPuneSortByName(traders));

		// 3. All trader names sorted alphabetically
		System.out.println("All trader names sorted alphabetically: " + allTrader3Names(traders));

		// 4. Traders based in Indore
		System.out.println("Traders based in Indore: " + areAnyTradersFromIndore(traders));
	}
}
