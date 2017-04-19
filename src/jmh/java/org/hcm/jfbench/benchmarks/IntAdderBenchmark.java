package org.hcm.jfbench.benchmarks;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

import javax.validation.constraints.NotNull;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

public class IntAdderBenchmark {

	public static class IntegerList {
		static List<Integer> integerList = new ArrayList<>();
		static {
			for (int i = 0; i < 10_000; i++) {
				integerList.add(i);
			}
		}
	}

	static class ResultLong {
		long result;

		ResultLong() {
			result = 0L;
		}
	}

	static class Result<T extends Number> {
		T result;

		Result(@NotNull T result) {
			this.result = Objects.requireNonNull(result);
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
	public void testSimpleLoopResultLongInnerClass(Blackhole blackhole) {
		ResultLong result = new ResultLong();
		for (int v : IntegerList.integerList) {
			result.result += v;
		}
		blackhole.consume(result.result);
	}


	@Benchmark
	public void testSimpleLoopResultTemplateClass(Blackhole blackhole) {
		final Result<Long> result = new Result<>(0L);
		for (int v : IntegerList.integerList) {
			result.result += v;
		}
		blackhole.consume(result.result);
	}

	@Benchmark
	public void testStreamReduceMethod(Blackhole blackhole) {
		long result;
		result = IntegerList.integerList.stream().reduce(0, Integer::sum);
		blackhole.consume(result);
	}

	@Benchmark
	public void testMTStreamReduceMethod(Blackhole blackhole) {
		long result;
		result = IntegerList.integerList.parallelStream().reduce(0, Integer::sum);
		blackhole.consume(result);
	}

	@Benchmark
	public void testForEachAtomicLong(Blackhole blackhole) {
		final AtomicLong result = new AtomicLong();
		IntegerList.integerList.forEach(result::addAndGet);
		blackhole.consume(result.get());
	}

	@Benchmark
	public void testForEachResultTemplateClass(Blackhole blackhole) {
		final Result<Long> result = new Result<>(0L);
		IntegerList.integerList.forEach(v -> result.result += v);
		blackhole.consume(result.result);
	}

	@Benchmark
	public void testForEachResultLongClass(Blackhole blackhole) {
		final ResultLong result = new ResultLong();
		IntegerList.integerList.forEach(v -> result.result += v);
		blackhole.consume(result.result);
	}
}
