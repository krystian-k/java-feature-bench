package org.hcm.jfbench.hr;

import java.util.Scanner;

public class Insertion1 {

	public static void insertIntoSorted(int[] ar) {
		int toInsert = ar[ar.length - 1];
		int pos = ar.length - 2;
		while ( pos >= 0 ) {
			if (toInsert < ar[pos]) {
				ar[pos + 1] = ar[pos];
				pos -= 1;
			} else {
				break;
			}
			printArray(ar);
		}

		ar[pos + 1] = toInsert;
		printArray(ar);
	}


	/* Tail starts here */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for(int i=0;i<s;i++){
			ar[i]=in.nextInt();
		}
		insertIntoSorted(ar);
	}


	private static void printArray(int[] ar) {
		for(int n: ar){
			System.out.print(n+" ");
		}
		System.out.println("");
	}
}
