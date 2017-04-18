package org.hcm.jfbench;

import org.openjdk.jmh.annotations.Benchmark;

public class StreamBenchmark {

	@Benchmark
	public void testMethod() {
		int a = 1;
		int b = 2;
		int sum = a + b;
	}
}
