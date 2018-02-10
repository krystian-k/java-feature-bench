package org.hcm.jfbench.hr;

import java.util.Scanner;

public class Insertion2 {
	private static void insertionSortPart2(int[] ar) {
		int swap, j;
		for (int i = 1; i < ar.length; i++) {
			j = i;
			swap = ar[j];
			while (j > 0 && swap < ar[j - 1]) {
				ar[j] = ar[j - 1];
				j -= 1;
			}
			ar[j] = swap;
			printArray(ar);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for(int i=0;i<s;i++){
			ar[i]=in.nextInt();
		}
		insertionSortPart2(ar);

	}
	private static void printArray(int[] ar) {
		for(int n: ar){
			System.out.print(n+" ");
		}
		System.out.println("");
	}

}
