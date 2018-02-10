package org.hcm.jfbench.hr;

import java.util.Scanner;

public strictfp class PlusMinus {

	private static int plusMinusIndex(int i) {
		int idx = 0;
		if (i < 0) {
			idx = 1;
		} else if (i == 0) {
			idx = 2;
		}
		return idx;
	}

	private static int[] countPlusMinus(int[] arr) {
		int[] result = {0 , 0, 0};
		for (int v : arr) {
			result[plusMinusIndex(v)] += 1;
		}
		return result;
	}

	private static void printStaircase(int size) {
		char[] level = { ' ', ' ', ' ', ' ', ' ', ' ' };
		for (int i = size; i > 0; i--) {
			level[i - 1] = '#';
			System.out.println(new String(level));
		}
	}

	public static void main(String[] args) {
		final Scanner in = new Scanner(System.in);
		final int numbersCount = in.nextInt();
		int[] arr = new int[numbersCount];

		printStaircase(numbersCount);

		for (int i = 0; i<numbersCount; i++) {
			arr[i] = in.nextInt();
		}

		for (int i : countPlusMinus(arr)) {
			System.out.println(String.format("%.6f", (1f * i)/numbersCount));
		}
	}
}
