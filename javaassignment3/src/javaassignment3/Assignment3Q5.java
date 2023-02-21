package javaassignment3;

import java.util.HashMap;
import java.util.Map;

class Employee {
	private String name;
	private int id;

	public Employee(String name, int id) {
		this.name = name;
		this.id = id;
	}

	@Override
	public int hashCode() {
		return 100;
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + "]";
	}
}

public class Assignment3Q5 {
	public static void main(String[] args) {

		Map<String, Integer> empMap = new HashMap<>();
		Employee e1 = new Employee("Sam", 1001);
		Employee e2 = new Employee("Ram", 1002);
		Employee e3 = new Employee("Jam", 1003);
		empMap.put(e1.getName(), e1.getId());
		empMap.put(e2.getName(), e2.getId());
		empMap.put(e3.getName(), e3.getId());
		System.out.println(empMap);
		System.out.println(empMap.get("Sam"));

	}

}
