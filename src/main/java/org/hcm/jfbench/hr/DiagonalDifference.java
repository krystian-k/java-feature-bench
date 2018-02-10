package org.hcm.jfbench.hr;

import java.util.Scanner;

public class DiagonalDifference {

	private static int calculateDiff(int[][] arr) {
		int d1 = 0;
		int d2 = 0;
		for (int i = 0; i< arr.length; i++) {
			d1 += arr[i][i];
			d2 += arr[arr.length - i - 1][i];
		}
		return Math.abs(d1 - d2);
	}

	private static int checkConstraint(int v) {
		if (v < -100 || v > 100) {
			throw new IllegalArgumentException("invalid value of element in the matrix");
		}
		return v;
	}

	public static void main(String[] args) {
		final Scanner in = new Scanner(System.in);
		final int arraySize = in.nextInt();

		if (arraySize <= 0) {
			throw new IllegalArgumentException("invalid array size");
		}
		int[][] array = new int[arraySize][arraySize];
		for (int i = 0; i < arraySize; i++) {
			for (int j = 0; j < arraySize; j++) {
				array[i][j] = checkConstraint(in.nextInt());
			}
		}
		System.out.println(calculateDiff(array));
	}
}
