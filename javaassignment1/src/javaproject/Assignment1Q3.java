package javaproject;

class SiCi {

	public double simpleInterest(double principalAmount, int time, double interestRate) {

		double simpleinterest = (principalAmount * interestRate * time) / 100;

		return simpleinterest;

	}

	public double compoundInterest(double principalAmount, int time, double interestRate) {

		double compoundinterest = principalAmount * (Math.pow((1 + interestRate / 100), time)) - principalAmount;

		return compoundinterest;

	}

}

public class Assignment1Q3 {

	public static void main(String[] args) {

		SiCi si = new SiCi();
		System.out.println("simpleInterest:");
		System.out.println(si.simpleInterest(1000.12, 5, 12.5));

		System.out.println("compoundInterest:");
		System.out.println(si.compoundInterest(1000.12, 5, 12.5));

	}

}
