package org.hcm.jfbench.hr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class TwoCharacters {

	// Complete the twoCharaters function below.
	static int twoCharaters(String s) {
		Map<Character, Integer> freq = new HashMap<>();
		final char characters[] = s.toCharArray();
		for (char c : characters) {
			freq.put(c, freq.containsKey(c) ? freq.get(c) + 1 : 1);
		}
		List<Map.Entry<Character, Integer>> topFreq = new ArrayList<>();
		topFreq.addAll(freq.entrySet());
		topFreq.sort((l, r) -> r.getValue() - l.getValue());
		int maxSize = 0;
		do {
			Map.Entry<Character, Integer> firstChar = topFreq.remove(0);
			for (Map.Entry<Character, Integer> scndChar : topFreq) {
				if (scndChar.getValue().equals(firstChar.getValue()) || (scndChar.getValue().equals(firstChar.getValue() - 1))) {
					char curChar = 0;
					int size = 0;
					for (char c : characters) {
						if (c == firstChar.getKey() || c == scndChar.getKey()) {
							if (curChar != c) {
								curChar = c;
							} else {
								size = 0;
								break;
							}
							size += 1;
						}
					}
					if (size > maxSize) {
						maxSize = size;
					}
				} else {
					break;
				}
			}
		} while (!topFreq.isEmpty());
		return maxSize;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int l = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String s = scanner.nextLine();


		System.out.println(twoCharaters(s));

		scanner.close();
	}

}
