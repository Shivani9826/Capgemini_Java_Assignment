package javaproject;

import java.util.Scanner;

class ResultDeclaration {

	public String declareResults(double subject1Marks, double subject2Marks, double subject3Marks) {

		String result = "";

		if ((subject1Marks > 60) || subject2Marks > 60 || subject3Marks > 60) {

			if (subject1Marks + subject2Marks < 60 || subject2Marks + subject3Marks < 60

					|| subject3Marks + subject1Marks < 60) {

				result = "failed";

				return result;

			}

		}

		if (subject1Marks + subject2Marks > 60 || subject2Marks + subject3Marks > 60

				|| subject3Marks + subject1Marks > 60) {

			result = ("passed" + " " + "promoted");

			return result;

		}
		if (subject1Marks + subject2Marks + subject3Marks > 60) {
			result = "passed";
			return result;

		}

		result = "failed";

		return result;

	}

}

public class Assignment1Q4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number:");

		int t = sc.nextInt();

		while (t != 0) {
			System.out.println("Enter a");
			double a = sc.nextDouble();
			System.out.println("Enter b");
			double b = sc.nextDouble();
			System.out.println("Enter c");
			double c = sc.nextDouble();

			ResultDeclaration obj = new ResultDeclaration();

			System.out.println(obj.declareResults(a, b, c));

			t--;

		}

	}

}
