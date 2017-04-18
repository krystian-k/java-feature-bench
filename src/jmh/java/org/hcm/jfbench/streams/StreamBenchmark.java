package org.hcm.jfbench.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

public class StreamBenchmark {

	public static class IntegerList {
		static List<Integer> integerList = new ArrayList<>();
		static {
			for (int i = 0; i < 10_000; i++) {
				integerList.add(i);
			}
		}
	}

	@Benchmark
	public void testSimpleLoop(Blackhole blackhole) {
		long result = 0L;
		for (int v : IntegerList.integerList) {
			result += v;
		}
		blackhole.consume(result);
	}

	@Benchmark
	public void testStreamReduceMethod(Blackhole blackhole) {
		long result;
		result = IntegerList.integerList.stream().reduce(0, Integer::sum);
		blackhole.consume(result);
	}

	@Benchmark
	public void testForEachAtomicLong(Blackhole blackhole) {
		final AtomicLong result = new AtomicLong();
		IntegerList.integerList.forEach(result::addAndGet);
		blackhole.consume(result.get());
	}
}
