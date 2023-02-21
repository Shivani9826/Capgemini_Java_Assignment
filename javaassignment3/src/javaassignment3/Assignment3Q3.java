package javaassignment3;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Assignment3Q3 {

	public static List<Integer> traverseReverse(ArrayList<Integer> aList) {
		List<Integer> l = new ArrayList<Integer>();
		ListIterator<Integer> iterator = aList.listIterator();
		while (iterator.hasNext()) {

			iterator.next();
		}

		while (iterator.hasPrevious()) {
			l.add(iterator.previous());

		}
		return l;

	}

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);

		System.out.println("Reverse ArrayList:" + traverseReverse(list));

	}

}
