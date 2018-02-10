package org.hcm.jfbench.hr;

import java.util.Arrays;
import java.util.Scanner;

public class MiniMaxSum {

	private static long[] partialSums(int[] arr) {
		long[] partialSums = new long[arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < partialSums.length; j++) {
				if (j != i) {
					partialSums[j] += arr[i];
				}
			}
		}
		return partialSums;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] arr = new int[5];
		for (int arr_i=0; arr_i < 5; arr_i++){
			arr[arr_i] = in.nextInt();
		}
		long[] result = partialSums(arr);
		Arrays.sort(result);
		System.out.println(String.format("%d %d", result[0], result[result.length -1]));
	}
}
