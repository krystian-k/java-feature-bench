package org.hcm.jfbench.hr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MinMax {
	// https://www.hackerrank.com/challenges/angry-children

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int K = Integer.parseInt(in.readLine());
		int[] list = new int[N];

		for (int i = 0; i < N; i++)
			list[i] = Integer.parseInt(in.readLine());

		int unfairness = Integer.MAX_VALUE;

		/*
		* Write your code here, to process numPackets N, numKids K, and the packets of candies
		* Compute the ideal value for unfairness over here
		*/
		Arrays.sort(list);
		int distance;
		for (int i = 0; i < list.length - K; i++) {
			distance = list[i + K - 1] - list[i];
			if (distance < unfairness) {
				unfairness = distance;
			}
		}

		System.out.println(unfairness);
	}

}
