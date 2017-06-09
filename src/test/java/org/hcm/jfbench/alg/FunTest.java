package org.hcm.jfbench.alg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class FunTest {

	@Test
	public void computeIfAbsentTest() {
		List<String> strings = Arrays.asList("one", "two", "three", "four", "five", "six", "seven");
		Map<String, String> map = new HashMap<>();
		strings.forEach(
				s-> map.computeIfAbsent("" + s.charAt(0), s::concat).concat(", ").concat(s)
		);
		System.out.println("f: " + map.get("f"));
	}

	@Test
	public void confusingTest() {
		int i = (byte) + (char) - (int) + (long) - 1;
		System.out.println(i);
	}

	@Test
	public void timingTest() throws InterruptedException {
		Set<Long> sleepy = new TreeSet<>();
		for (int i = 0; i < 10_000; i++) {
			long start = System.currentTimeMillis();
			Thread.sleep(2);
			long timeSpent = System.currentTimeMillis() - start;
			sleepy.add(timeSpent);
		}
		System.out.println(sleepy);
	}
}
