package org.hcm.jfbench.benchmarks;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

import javax.validation.constraints.NotNull;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

	public class IntAdderBenchmark {

	static final int INT_ARRAY_LENGTH = 10_000;
	static List<Integer> INTEGER_LIST = new ArrayList<>();
	static {
		for (int i = 0; i < INT_ARRAY_LENGTH; i++) {
			INTEGER_LIST.add(i);
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
		for (int v : INTEGER_LIST) {
			result += v;
		}
		blackhole.consume(result);
	}

	@Benchmark
	public void testSimpleLoopResultLongInnerClass(Blackhole blackhole) {
		ResultLong result = new ResultLong();
		for (int v : INTEGER_LIST) {
			result.result += v;
		}
		blackhole.consume(result.result);
	}


	@Benchmark
	public void testSimpleLoopResultTemplateClass(Blackhole blackhole) {
		final Result<Long> result = new Result<>(0L);
		for (int v : INTEGER_LIST) {
			result.result += v;
		}
		blackhole.consume(result.result);
	}

	@Benchmark
	public void testStreamReduceMethod(Blackhole blackhole) {
		long result;
		result = INTEGER_LIST.stream().reduce(0, Integer::sum);
		blackhole.consume(result);
	}

	@Benchmark
	public void testMTStreamReduceMethod(Blackhole blackhole) {
		long result;
		result = INTEGER_LIST.parallelStream().reduce(0, Integer::sum);
		blackhole.consume(result);
	}

	@Benchmark
	public void testForEachAtomicLong(Blackhole blackhole) {
		final AtomicLong result = new AtomicLong();
		INTEGER_LIST.forEach(result::addAndGet);
		blackhole.consume(result.get());
	}

	@Benchmark
	public void testForEachResultTemplateClass(Blackhole blackhole) {
		final Result<Long> result = new Result<>(0L);
		INTEGER_LIST.forEach(v -> result.result += v);
		blackhole.consume(result.result);
	}

	@Benchmark
	public void testForEachResultLongClass(Blackhole blackhole) {
		final ResultLong result = new ResultLong();
		INTEGER_LIST.forEach(v -> result.result += v);
		blackhole.consume(result.result);
	}
}
