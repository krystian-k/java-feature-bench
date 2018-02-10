package org.hcm.jfbench.hr;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ransom {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		Map<String, Integer> magazine = new HashMap<>(m);
		String word;
		for(int magazine_i=0; magazine_i < m; magazine_i++){
			word = in.next();
			magazine.put(word, magazine.getOrDefault(word, 0) + 1);
		}
		boolean untracable = true;
		for(int ransom_i=0; ransom_i < n; ransom_i++){
			word = in.next();
			int words = magazine.getOrDefault(word, 0);
			if (words <= 0) {
				untracable = false;
				break;
			} else {
				magazine.put(word, words - 1);
			}
		}
		if (untracable) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}