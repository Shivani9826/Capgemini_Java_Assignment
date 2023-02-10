package javaproject;

import java.util.Scanner;

class ArmstrongOrNot {
	public boolean armstrongCheck(int num) {
		int Num = num;
		int r, sum = 0;
		while (Num != 0) {
			r = Num % 10;
			int ans = r * r * r;
			sum = sum + ans;
			Num = Num / 10;
		}
		if (sum == num) {
			return true;
		} else {
			return false;
		}
	}
}

public class Assignment1Q1 {

	public static void main(String[] args) {
		ArmstrongOrNot ab = new ArmstrongOrNot();
	    Scanner a=new Scanner(System.in);
		System.out.println("Enter a number:");
		int num=a.nextInt();
		if (ab.armstrongCheck(num)) {
			System.out.println(num+ " is a armstrong number.");
		}
		else {
			System.out.println(num+ " is not a armstrong number.");
		}
		}

	}


