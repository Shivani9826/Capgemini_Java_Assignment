package javaassignment4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class Assignment4Q6 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("apple");
		list.add("banana");
		list.add("cherry");
		System.out.println("Before conversion: " + list);

		convertToUpperCase(list);
		System.out.println("After conversion: " + list);
	}

	public static List<String> convertToUpperCase(List<String> list) {
		UnaryOperator<String> operator = s -> s.toUpperCase();
		list.replaceAll(operator);
		return list;
	}
}