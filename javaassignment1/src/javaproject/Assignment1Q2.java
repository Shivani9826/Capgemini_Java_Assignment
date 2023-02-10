package javaproject;

class ArmstrongNumBetweenRange {

	public int[] armstrongNumbersInRange(int min, int max) {

		int arr[];

		arr = new int[min];

		int j = 0;

		ArmstrongOrNot a = new ArmstrongOrNot();

		for (int i = min; i < max; i++) {

			if (a.armstrongCheck(i) == true) {

				arr[j] = i;

				j++;

			}

		}

		return arr;

	}

}

public class Assignment1Q2 {

	public static void main(String[] args) {

		int min = 100;
		int max = 999;

		int[] Ans;

		ArmstrongNumBetweenRange ans = new ArmstrongNumBetweenRange();

		Ans = ans.armstrongNumbersInRange(min, max);
		System.out.println("The Armstrong numbers falling in the range of 100-999:");

		for (int i = 0; i < Ans.length; i++) {

			if (Ans[i] == 0) {

				break;

			}

			System.out.println(Ans[i]);

		}

	}
}
