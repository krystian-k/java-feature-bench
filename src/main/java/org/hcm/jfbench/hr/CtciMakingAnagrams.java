package org.hcm.jfbench.hr;

import java.util.Scanner;

public class CtciMakingAnagrams {

	public static int numberNeeded(String first, String second) {
		int totalLength = first.length() + second.length();
		StringBuilder firstClean = new StringBuilder();
		int[] pos = new int[255];
		int idx;
		for (char c : first.toCharArray()) {
			if ((idx = second.substring(pos[c]).indexOf(c)) >= 0) {
				firstClean.append(c);
				pos[c] = pos[c] + idx + 1;
			} else {
				pos[c] = second.length();
			}
		}
		return totalLength - 2 * firstClean.toString().length();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		System.out.println(numberNeeded(a, b));
	}
}
