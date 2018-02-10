package org.hcm.jfbench.hr;

import java.util.Scanner;

public class CtciArrayLeftRotation {
	// https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
	/*
	5 4
	1 2 3 4 5

	5 1 2 3 4
	 */

	private static void rotateLeft(int[] array, int places) {
		int[] temp = new int[places];
		System.arraycopy(array, 0, temp, 0, places);
		System.arraycopy(array, places, array, 0, array.length - places);
		System.arraycopy(temp, 0, array, array.length - places, places);
	}

	private static void rotateLeft2(int[] array, int places) {
		int[] temp = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			temp[i] = array[(i + places) % array.length];
		}
		System.arraycopy(temp, 0, array, 0, array.length );
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int a[] = new int[n];
		for(int a_i=0; a_i < n; a_i++){
			a[a_i] = in.nextInt();
		}
		rotateLeft2(a, k % n);
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
