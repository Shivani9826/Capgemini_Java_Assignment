package javaassignment3;

import java.util.Set;
import java.util.TreeSet;

class Person implements Comparable<Person> {
	private String name;
	private int height;
	private double weight;

	// Creating constructor
	public Person(String name, int height, double weight) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	void display() {
		System.out.println("name = " + getName() + ", height = " + getHeight() + ", weight = " + getWeight());
	}

	public int compareTo(Person p) {
		if (this.weight == p.getWeight()) {
			if (this.height == p.getHeight()) {
				return 0;
			} else if (this.height > p.getHeight()) {
				return 1;
			} else {
				return -1;
			}
		} else if (this.weight > p.getWeight()) {
			return 1;
		} else {
			return -1;
		}
	}

}

public class Assignment3Q1 {
	public static void main(String[] args) {
		Set<Person> obj = new TreeSet<Person>();

		Person p1 = new Person("Monu", 5, 25);
		Person p2 = new Person("Pino", 6, 55);
		Person p3 = new Person("Golu", 4, 35);
		Person p4 = new Person("Raj", 5, 55);

		obj.add(p1);
		obj.add(p2);
		obj.add(p3);
		obj.add(p4);

		for (Person p : obj) {
			p.display();
		}
	}
}
