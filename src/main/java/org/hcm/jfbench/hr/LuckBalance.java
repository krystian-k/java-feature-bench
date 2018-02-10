package org.hcm.jfbench.hr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LuckBalance {

	private static void oneFuncSolution() {
		final Scanner in = new Scanner(System.in);
		int contests = in.nextInt();
		int maxLoses = in.nextInt();
		assert contests >= maxLoses;

		ArrayList<Integer> important = new ArrayList<>(contests);
		int luckBalance;
		long maxLuck = 0L;

		for (int i = 0; i < contests; i++) {
			luckBalance = in.nextInt();
			if (in.nextInt() == 0) {
				maxLuck += luckBalance;
			} else {
				important.add(luckBalance);
			}
		}
		int maxWins = important.size() > maxLoses ? important.size() - maxLoses : 0;
		Collections.sort(important);
		for (int luck : important) {
			maxLuck += maxWins-- <= 0 ? luck : -luck;
		}
		System.out.println(maxLuck);
	}

	public static void main(String[] args) {
		oneFuncSolution();
	}
}
