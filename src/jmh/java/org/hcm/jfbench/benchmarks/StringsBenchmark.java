package org.hcm.jfbench.benchmarks;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

public class StringsBenchmark {

	static final int STRING_ARRAY_LENGTH = 1_000;
	static List<String> STRING_LIST = new ArrayList<>();
	static {
		for (int i = 0; i < STRING_ARRAY_LENGTH; i++) {
			STRING_LIST.add(UUID.randomUUID().toString());
		}
	}

	@Benchmark
	public void testSimpleLoop(Blackhole blackhole) {
		String result = "";
		for (int i = 0; i < STRING_ARRAY_LENGTH; i++) {
			result += STRING_LIST.get(i);
		}
		blackhole.consume(result);
	}

	@Benchmark
	public void testSimpleIteratorLoop(Blackhole blackhole) {
		String result = "";
		for (String part : STRING_LIST) {
			result += part;
		}
		blackhole.consume(result);
	}

	@Benchmark
	public void testSimpleLoopStringBuilder(Blackhole blackhole) {
		final StringBuilder result = new StringBuilder();
		for (int i = 0; i < STRING_ARRAY_LENGTH; i++) {
			result.append(STRING_LIST.get(i));
		}
		blackhole.consume(result.toString());
	}

	@Benchmark
	public void testSimpleIteratorLoopStringBuilder(Blackhole blackhole) {
		final StringBuilder result = new StringBuilder();
		for (String part : STRING_LIST) {
			result.append(part);
		}
		blackhole.consume(result.toString());
	}
}