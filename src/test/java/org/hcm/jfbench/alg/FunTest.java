package org.hcm.jfbench.alg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class FunTest {

	@Test
	public void computeIfAbsentTest() {
		List<String> strings = Arrays.asList("one", "two", "three", "four", "five", "six", "seven");
		Map<String, String> map = new HashMap<>();
		strings.forEach(
				s-> map.computeIfAbsent("" + s.charAt(0), s::concat).concat(", ").concat(s)
		);
		System.out.println(Thread.currentThread().getName() + " : f= " + map.get("f"));
	}

	@Test
	public void confusingTest() {
		int i = (byte) + (char) - (int) + (long) - 1;
		System.out.println(Thread.currentThread().getName() + " : " + i);
	}

	@Test
	public void timingTest() {
		Set<Long> sleepy = new TreeSet<>();
		for (int i = 0; i < 10_000; i++) {
			long start = System.currentTimeMillis();
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long timeSpent = System.currentTimeMillis() - start;
			sleepy.add(timeSpent);
		}
		System.out.println(Thread.currentThread().getName() + " : " + sleepy);
	}

	@Test
	public void scheduledExecutorServiceTest() throws Exception {
		final ScheduledExecutorService scheduler = new ScheduledThreadPoolExecutor(2 );
		scheduler.schedule(this::computeIfAbsentTest, 3L, TimeUnit.SECONDS);
		scheduler.schedule(this::timingTest, 1L, TimeUnit.SECONDS);
		scheduler.schedule(this::timingTest, 0L, TimeUnit.SECONDS);
		scheduler.execute(this::confusingTest);
		scheduler.shutdown();
		scheduler.awaitTermination(60, TimeUnit.SECONDS);
	}

	@Test
	public void stringHashcode() {
		System.out.println(1 * '0');
		System.out.println(1 * '9');
		System.out.println((char) 58);
		System.out.println((char) 64);
		System.out.println(1 * 'A');
		System.out.println(1 * 'a');
		System.out.println('a' - 'A');
		System.out.println(1 * 'Z');
		System.out.println(1 * 'z');
		System.out.println(31 * ('C' - 'D') == ('B' - 'a'));
		System.out.println(31 * ('B' - 'A') == ('a' - 'B'));

		assert "Aa".hashCode() == "BB".hashCode();
		assert "common_prefixDB".hashCode() == "common_prefixCa".hashCode();
	}

	@Test
	public void whatsGoingOn() {
		List<Integer> primesV3 = EratosthenesSieveNaive.getPrimesV3(0, 10_000_000);
		List<Integer> primesV4 = EratosthenesSieveNaive.getPrimesV4(0, 10_000_000);

		System.out.println(String.format("V3 vs. V4 - %d : %d ", primesV3.size(), primesV4.size()));
		Map<Integer, Boolean> nums = new HashMap<>(primesV3.size());
		primesV3.forEach(i -> nums.put(i, false));
		primesV4.forEach(i -> nums.computeIfPresent(i, (a, b) -> true));
		assert nums.entrySet().stream().filter(e -> !e.getValue()).map(Map.Entry::getKey).reduce(0, Integer::sum) == 0;
	}
}
