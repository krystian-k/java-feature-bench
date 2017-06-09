package org.hcm.jfbench.benchmarks;

import org.hcm.jfbench.alg.EratosthenesSieveNaive;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

public class PrimesESBenchmark {

	@Benchmark
	public void testEratosthenesSieveV1(Blackhole blackhole) {
		blackhole.consume(EratosthenesSieveNaive.getPrimesV1(0, 1_000_000));
	}

	@Benchmark
	public void testEratosthenesSieveV2(Blackhole blackhole) {
		blackhole.consume(EratosthenesSieveNaive.getPrimesV2(0, 1_000_000));
	}

	@Benchmark
	public void testEratosthenesSieveV3(Blackhole blackhole) {
		blackhole.consume(EratosthenesSieveNaive.getPrimesV3(0, 1_000_000));
	}

	@Benchmark
	public void testEratosthenesSieveV3a(Blackhole blackhole) {
		blackhole.consume(EratosthenesSieveNaive.getPrimesV3a(0, 1_000_000));
	}
}
