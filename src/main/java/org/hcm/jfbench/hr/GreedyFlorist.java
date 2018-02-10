package org.hcm.jfbench.hr;

import java.util.Arrays;
import java.util.Scanner;

public class GreedyFlorist {
	// https://www.hackerrank.com/challenges/greedy-florist

	static int getMinimumCost(int n, int k, int[] c){
		int cost = 0;
		int[] costPerFriend = new int[k];

		Arrays.sort(c);

		int friend = 0;
		int weight = 1;
		for (int i = n - 1; i >= 0; i--) {
			costPerFriend[friend++] += c[i] * weight;
			if (friend == k) {
				Arrays.sort(costPerFriend);
				friend = 0;
				weight += 1;
			}
		}

		for (int cpf : costPerFriend) {
			cost += cpf;
		}

		return cost;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] c = new int[n];
		for(int c_i=0; c_i < n; c_i++){
			c[c_i] = in.nextInt();
		}
		int minimumCost = getMinimumCost(n, k, c);
		System.out.println(minimumCost);
	}
}
