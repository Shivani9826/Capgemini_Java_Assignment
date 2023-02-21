package javaassignment4;

import java.util.HashMap;
import java.util.Map;

public class Assignment4Q7 {
	public static void main(String[] args) {
		// create a HashMap
		HashMap<String, Integer> map = new HashMap<>();
		map.put("apple", 3);
		map.put("banana", 5);
		map.put("cherry", 1);

		// call the convertKeyValueToString method and print the result
		String result = convertKeyValueToString(map);
		System.out.println(result);
	}

	public static String convertKeyValueToString(HashMap<String, Integer> map) {

		// create a StringBuilder to construct the result string
		StringBuilder sb = new StringBuilder();

		// iterate over the key-value pairs in the map using Map.entrySet()
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			// convert the key-value pair to a string and append it to the StringBuilder
			sb.append(entry.getKey());
			sb.append("=");
			sb.append(entry.getValue());
			sb.append(" ");
		}

		// convert the StringBuilder to a string and return it
		return sb.toString();
	}
}