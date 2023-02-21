package javaassignment3;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Assignment3Q2 {

	private static LinkedHashSet ordered(LinkedHashSet linkedHashSet) {

		LinkedHashSet<Integer> linkedhash = new LinkedHashSet<>();

		linkedhash.add(6);
		linkedhash.add(4);
		linkedhash.add(5);
		linkedhash.add(8);
		linkedhash.add(1);

		return linkedhash;

	}

	private static HashSet unordered(HashSet hashSet) {

		HashSet<Integer> hash = new HashSet<>();

		hash.add(6);
		hash.add(4);
		hash.add(5);
		hash.add(8);
		hash.add(1);

		return hash;

	}

	public static void main(String[] args) {

		System.out.println("HashSet:" + unordered(null));

		System.out.println("LinkedHashSet:" + ordered(null));

	}

}
