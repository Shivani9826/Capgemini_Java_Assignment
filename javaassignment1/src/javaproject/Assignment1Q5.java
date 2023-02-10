package javaproject;

import java.util.Scanner;

class TaxAmount {

	public double calculateTaxAmount(int ctc) {

		double res = 0;

		if (ctc >= 0 && ctc <= 180000)

			res = 0;

		if (ctc >= 181001 && ctc <= 300000)

			res = ctc * (0.1);

		if (ctc >= 300001 && ctc <= 500000)

			res = ctc * (0.2);

		if (ctc >= 500001 && ctc <= 1000000)

			res = ctc * (0.3);

		return res;

	}

}

public class Assignment1Q5 {

	public static void main(String[] args) {

		TaxAmount t = new TaxAmount();

		Scanner sc = new Scanner(System.in);
		System.out.println("Accept CTC from user:");
		int ctc = sc.nextInt();
		System.out.println("Tax amount:");
		System.out.println(t.calculateTaxAmount(ctc));

	}

}
