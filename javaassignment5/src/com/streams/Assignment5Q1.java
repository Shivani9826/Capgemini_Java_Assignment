package com.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Fruit {
	private String name;
	private int calories;
	private int price;
	private String color;

	public Fruit(String name, int calories, int price, String color) {
		this.name = name;
		this.calories = calories;
		this.price = price;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public int getCalories() {
		return calories;
	}

	public int getPrice() {
		return price;
	}

	public String getColor() {
		return color;
	}
}

public class Assignment5Q1 {

	public static List<String> reverseSort(ArrayList<Fruit> fruits) {
		return fruits.stream().filter(fruit -> fruit.getCalories() < 100)
				.sorted(Comparator.comparing(Fruit::getCalories).reversed()).map(Fruit::getName)
				.collect(Collectors.toList());
	}

	public static ArrayList<Fruit> sort(ArrayList<Fruit> fruits) {
		return fruits.stream().sorted(Comparator.comparing(Fruit::getColor).thenComparing(Fruit::getName))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public static ArrayList<Fruit> filterRedSortPrice(ArrayList<Fruit> fruits) {
		return fruits.stream().filter(fruit -> fruit.getColor().equals("RED"))
				.sorted(Comparator.comparing(Fruit::getPrice)).collect(Collectors.toCollection(ArrayList::new));
	}

	public static void main(String[] args) {
		ArrayList<Fruit> fruits = new ArrayList<>();
		fruits.add(new Fruit("Apple", 95, 50, "RED"));
		fruits.add(new Fruit("Banana", 105, 30, "YELLOW"));
		fruits.add(new Fruit("Cherry", 80, 80, "RED"));
		fruits.add(new Fruit("Durian", 150, 120, "GREEN"));
		fruits.add(new Fruit("Elderberry", 70, 60, "PURPLE"));
		fruits.add(new Fruit("Fig", 90, 70, "PURPLE"));
		fruits.add(new Fruit("Grape", 110, 40, "GREEN"));
		fruits.add(new Fruit("Honeydew", 95, 90, "GREEN"));
		fruits.add(new Fruit("Kiwi", 75, 60, "BROWN"));

		System.out.println("Low calorie fruits (calories < 100) in descending order of calories:");
		reverseSort(fruits).forEach(System.out::println);

		System.out.println("\nFruit names color-wise:");
		sort(fruits).forEach(fruit -> System.out.println(fruit.getColor() + " - " + fruit.getName()));

		System.out.println("\nRed color fruits sorted by price in ascending order:");
		filterRedSortPrice(fruits).forEach(fruit -> System.out.println(fruit.getName() + " - " + fruit.getPrice()));
	}
}