package javaproject2;

//Abstract class
abstract class Animals {

	// Abstract method
	abstract void typeOfAnimals();

	// Simple method without abstract
	public void withoutAbstract() {

	}

	Animals() {
		System.out.println("This is an constructor.");
	}
}

class Mammals extends Animals {

	@Override
	void typeOfAnimals() {
		System.out.println("This is Mammal.");
	}
}

class Birds extends Animals {

	@Override
	void typeOfAnimals() {
		System.out.println("This is Birds.");

	}
}

public class Assignment2Q4 {
	public static void main(String[] args) {
		Mammals m = new Mammals();
		m.typeOfAnimals();
		Birds b = new Birds();
		b.typeOfAnimals();
	}
}