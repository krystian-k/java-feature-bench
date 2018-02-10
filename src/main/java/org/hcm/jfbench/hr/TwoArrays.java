package org.hcm.jfbench.hr;

import java.util.Arrays;
import java.util.Scanner;

public class TwoArrays {
	public static void main(String[] args) {
		final Scanner in = new Scanner(System.in);
		int q = in.nextInt();

		for (int i = 0; i < q; i++) {
			int n = in.nextInt();
			int k = in.nextInt();

			int[][] tabs = new int[2][n];

			for (int j = 0; j < 2; j++) {
				for (int l = 0; l < n; l++) {
					tabs[j][l] = in.nextInt();
				}
				Arrays.sort(tabs[j]);
			}

			int l = 0;
			while (l < n) {
				long sum = (long) tabs[0][l] + tabs[1][n - l - 1];
				if (sum < k) {
					System.out.println("NO");
					break;
				}
				l++;
			}
			if (l == n) {
				System.out.println("YES");
			}
		}
	}
}
