package org.hcm.jfbench.hr;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BigSorting {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<String> unsortedInts = new ArrayList<>(n);
		for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
			 unsortedInts.add(in.next());
		}
		// your code goes here
		unsortedInts.sort((o1, o2) -> o1.length() != o2.length() ? o1.length() - o2.length() : new BigInteger(o1).compareTo(new BigInteger(o2)));

		for (int i=0; i<n; i++) {
			System.out.println(unsortedInts.get(i));
		}
	}
}
