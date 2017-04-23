package org.hcm.jfbench.benchmarks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

public class SortingBenchmark {

	@State(Scope.Thread)
	public static class Sort {
		List<String> list;

		@Setup
		public void setup() {
			this.list = new ArrayList<>(StringsBenchmark.STRING_LIST);
		}
	}

	@Benchmark
	public void testStringListSort(Sort sortList, Blackhole blackhole) {
		sortList.list.sort(String::compareToIgnoreCase);
		blackhole.consume(sortList.list);
	}

	@Benchmark
	public void testCollectionsStringListSort(Sort sortList, Blackhole blackhole) {
		Collections.sort(sortList.list, String::compareToIgnoreCase);
		blackhole.consume(sortList.list);
	}

	@Benchmark
	public void testStreamStringListSort(Sort sortList, Blackhole blackhole) {
		final List<String> sorted = sortList.list.stream().sorted(String::compareToIgnoreCase).collect(Collectors.toList());
		blackhole.consume(sorted);
	}

	@Benchmark
	public void testParallelStreamStringListSort(Sort sortList, Blackhole blackhole) {
		final List<String> sorted = sortList.list.parallelStream().sorted(String::compareToIgnoreCase).collect(Collectors.toList());
		blackhole.consume(sorted);
	}
}