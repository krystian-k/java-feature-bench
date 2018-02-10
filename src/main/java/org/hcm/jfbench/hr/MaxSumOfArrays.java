package org.hcm.jfbench.hr;

import java.util.Scanner;

public class MaxSumOfArrays {

	static long maximumSum(long[] a, long m) {
		// Complete this function
		return m - 1;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for(int a0 = 0; a0 < q; a0++){
			int n = in.nextInt();
			long m = in.nextLong();
			long[] a = new long[n];
			for(int a_i = 0; a_i < n; a_i++){
				a[a_i] = in.nextLong();
			}
			long result = maximumSum(a, m);
			System.out.println(result);
		}
		in.close();
	}
}
