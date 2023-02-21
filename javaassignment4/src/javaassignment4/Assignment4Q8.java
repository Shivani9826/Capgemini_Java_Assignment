package javaassignment4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Assignment4Q8 {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		Consumer<Integer> consumer = i -> System.out.println(Thread.currentThread().getName() + " : " + i);
		Thread t = new Thread(() -> numbers.forEach(consumer));
		t.start();
	}
}