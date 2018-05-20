package org.hcm.jfbench.hr;

import java.util.Scanner;

public class CaesarCipher {
	final static char MAX_DIST = 'z' - 'a' + 1;
	// Complete the caesarCipher function below.
	static String caesarCipher(String s, int k) {
		final StringBuilder ccStr = new StringBuilder(s.length());
		char nextChar;
		for (char c : s.toCharArray()) {
			if (c >= 'a' && c<= 'z') {
				nextChar = (char) ('a' + ((c - 'a') + k) % MAX_DIST);
			} else if (c >= 'A' && c<= 'Z') {
				nextChar = (char) ('A' + ((c - 'A') + k) % MAX_DIST);
			} else {
				nextChar = c;
			}
			ccStr.append(nextChar);
		}
		return ccStr.toString();
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String s = scanner.nextLine();

		int k = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String result = caesarCipher(s, k);

		System.out.println(result);

		scanner.close();
	}
}
