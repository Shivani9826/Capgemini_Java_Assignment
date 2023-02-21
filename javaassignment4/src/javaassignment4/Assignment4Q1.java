package javaassignment4;

public class Assignment4Q1 {

	interface ArithmeticOperations {
		public void operation(int a, int b);
	}

	public double addition(int num1, int num2) {
		return (double) num1 + num2;
	}

	public double subtraction(int num1, int num2) {
		return (double) num1 - num2;
	}

	public double division(int num1, int num2) {
		return (double) num1 / num2;
	}

	public double multiplication(int num1, int num2) {
		return (double) num1 * num2;
	}

	public static void main(String[] args) {
		Assignment4Q1 d = new Assignment4Q1();

		// Lambda expression
		ArithmeticOperations obj1 = (int a, int b) -> {
			System.out.println("Addition:" + d.addition(a, b));
			System.out.println("Subtraction:" + d.subtraction(a, b));
			System.out.println("Multiplication:" + d.multiplication(a, b));
			System.out.println("Division:" + d.division(a, b));

		};
		obj1.operation(13, 5);

	}

}