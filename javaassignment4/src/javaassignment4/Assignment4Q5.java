package javaassignment4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Assignment4Q5 {
	private List<String> list = Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot");

	public static void main(String[] args) {
		List<String> list = Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot");
		String result = processWords(list);
		System.out.println(result);
	}

	public static String processWords(List<String> list) {
		StringBuilder sb = new StringBuilder();
		Consumer<String> consumer = s -> sb.append(s.charAt(0));
		list.forEach(consumer);
		return sb.toString();
	}
}