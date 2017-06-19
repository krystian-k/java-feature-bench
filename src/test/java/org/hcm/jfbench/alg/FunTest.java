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
}
