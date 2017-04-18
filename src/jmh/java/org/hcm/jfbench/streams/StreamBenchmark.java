package org.hcm.jfbench.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

public class StreamBenchmark {

	@State(Scope.Benchmark)
	public static class IntegerList {
		List<Integer> integerList = Arrays.asList(0, 100, 200, 300, 400, 500, 600, 700, 800, 900);
	}

	@Benchmark
	public void testSimpleLoop(IntegerList list, Blackhole blackhole) {
		long result = 0L;
		for (int v : list.integerList) {
			result += v;
		}
		blackhole.consume(result);
	}

	@Benchmark
	public void testStreamReduceMethod(IntegerList list, Blackhole blackhole) {
		long result;
		result = list.integerList.stream().reduce(0, Integer::sum);
		blackhole.consume(result);
	}
}
