package javaassignment4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Assignment4Q3 {

	static class Product {
		private String name;
		private int price;

		public Product(String name, int price) {
			this.name = name;
			this.price = price;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}
	}

	static void modifyValue() {
		// Example usage the supplier functional interface to get the random integer
		// between 1 and 100
		Supplier<Integer> randomIntSupplier = () -> (int) (Math.random() * 100) + 1;
		// use the Supplier to generate and print random number
		for (int i = 0; i < 5; i++) {
			int randomInt = randomIntSupplier.get();
			System.out.println(randomInt);
		}
	}

	static void test() {

		// Example usage of the predicate functional interface to test if string is
		// empty
		Predicate<String> isEmpty = String::isEmpty;
		System.out.println(isEmpty.test(""));
		System.out.println(isEmpty.test("Hello"));
		// Example usage of the Function functional interface to get the square of
		// number
		Function<Integer, Integer> square = x -> x * x;
		System.out.println(square.apply(5));
	}

	static void display() {
		// Example usage of Consumer functional interface to print the element of list
		List<String> name = new ArrayList<>();
		name.add("Shivam");
		name.add("Sakshi");
		name.add("Nikhil");
		Consumer<String> printName = System.out::println;
		name.forEach(printName);
	}

	public static void main(String[] args) {
		System.out.println("Supplier:");
		modifyValue();
		System.out.println("Consumer:");
		display();
		System.out.println("Predicate:");
		test();
	}
}