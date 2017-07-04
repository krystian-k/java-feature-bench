package org.hcm.jfbench.alg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EratosthenesSieveNaive {

	private EratosthenesSieveNaive() {}

	public static List<Integer> getPrimesV1(int from, int to) {
		int start = from > 1 ? from : 2;
		int end = to >= start ? to : start;

		if (to < 2) {
			return Collections.emptyList();
		}

		int size = end - start + 1;
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = start + i;
		}
		for (int v=2; v <= Math.sqrt(end); v++) {
			for (int i = v*v; i <= end; i+=v) {
				if (i >= start) {
					array[i - start] = 0;
				}
			}
		}
		final List<Integer> result = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			if (array[i] > 0) {
				result.add(array[i]);
			}
		}
		return result;
	}

	public static List<Integer> getPrimesV2(int from, int to) {
		int start = from > 1 ? from : 2;
		int end = to >= start ? to : start;

		if (to < 2) {
			return Collections.emptyList();
		}

		int[] array = new int[end + 1];
		array[0] = array[1] = 1;

		int limit = (int) Math.sqrt(end);

		for (int v=2; v <= limit; v++) {
			if (array[v] == 0) {
				int startIndex = v * v;
				for (int i = startIndex; i <= end; i += v) {
					array[i] = 1;
				}
			}
		}
		final List<Integer> result = new ArrayList<>();
		for (int i = start; i <= to; i++) {
			if (array[i] == 0) {
				result.add(i);
			}
		}
		return result;
	}

	public static List<Integer> getPrimesV3(int from, int to) {
		int start = from > 1 ? from : 2;
		int end = to >= start ? to : start;

		if (to < 2) {
			return Collections.emptyList();
		}
		boolean[] array = new boolean[end+1];
		array[0] = array[1] = true;

		int limit = (int) Math.sqrt(end);

		for (int i=2; i<=limit;) {
			for (int j = i * i; j <= end; j += i) {
				array[j] = true;
			}
			while (array[++i]);
		}

		final List<Integer> result = new ArrayList<>();
		for (int i = start; i <= end; i++) {
			if (!array[i]) {
				result.add(i);
			}
		}
		return result;
	}

	public static List<Integer> getPrimesV3a(int from, int to) {
		int start = from > 1 ? from : 2;
		int end = to >= start ? to : start;

		if (to < 2) {
			return Collections.emptyList();
		}

		final List<Integer> result = new ArrayList<>();
		boolean[] array = new boolean[end+1];
		array[0] = array[1] = true;

		int limit = (int) Math.sqrt(end);

		for (int i=2; i<=end; i++) {
			if (!array[i]) {
				if (i <= limit) {
					for (int j = i * i; j <= end; j += i) {
						array[j] = true;
					}
				}
				if (i >= start) {
					result.add(i);
				}
			}
		}


		return result;
	}

	public static List<Integer> getPrimesV4(int from, int to) {
		int start = from > 1 ? from : 2;
		int end = to >= start ? to : start;

		if (to < 2) {
			return Collections.emptyList();
		}

		boolean[] array = new boolean[end+1];
		array[0] = array[1] = true;
		int i = 2, j;
		long x;

		int limit = (int) Math.sqrt(end);

		while (i <= limit) {
			j = i;
			while ((x = i * j) <= end) {
				while (x > 0 && x <= end) {
					array[(int) x] = true;
					x *= i;
				}
				while (array[++j]);
			}
			while (array[++i]);
		}

		final List<Integer> result = new ArrayList<>();
		for (int ii = start; ii <= end; ii++) {
			if (!array[ii]) {
				result.add(ii);
			}
		}
		return result;
	}

	static void getDiff() {
	}
}
