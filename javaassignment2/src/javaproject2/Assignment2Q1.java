package javaproject2;

class SingletonInheritanceCheck {
	private static SingletonInheritanceCheck Obj;

	private SingletonInheritanceCheck() {
	}

	public static SingletonInheritanceCheck getInstance() {
		// create object if it's not already created
		if (Obj == null) {
			Obj = new SingletonInheritanceCheck();
		}
		// returns the singleton object
		return Obj;
	}

	public void getConnection() {
		System.out.println("You are now connected to the SingletonInheritanceCheck.");
	}
}

public class Assignment2Q1 {
	public static void main(String[] args) {
		SingletonInheritanceCheck SingletonInheritanceCheck1;

		// refers to the only object of SingletonInheritanceCheck
		SingletonInheritanceCheck1 = SingletonInheritanceCheck.getInstance();
		SingletonInheritanceCheck1.getConnection();
	}
}