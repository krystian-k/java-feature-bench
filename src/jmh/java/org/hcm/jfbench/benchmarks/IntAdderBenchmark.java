package org.hcm.jfbench.benchmarks;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import javax.validation.constraints.NotNull;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

public class IntAdderBenchmark {

	private static final int INT_ARRAY_LENGTH = 100_000;
	private static List<Integer> INTEGER_LIST = new ArrayList<>();
	static {
		for (int i = 0; i < INT_ARRAY_LENGTH; i++) {
			INTEGER_LIST.add(i);
		}
	}
	private static final long ARRAY_SUM = INTEGER_LIST.stream().mapToLong(Integer::intValue).reduce(0L, Long::sum);

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

	static class ResultSyncLong {
		long result;

		ResultSyncLong() {
			result = 0L;
		}

		long get() {
			return result;
		}

		long getAndAdd(long delta) {
			synchronized (this) {
				return result += delta;
			}
		}
	}

	@Benchmark
	public void testSimpleLoop(Blackhole blackhole) {
		long result = 0L;
		for (int v : INTEGER_LIST) {
			result += v;
		}
		assert result == ARRAY_SUM;
		blackhole.consume(result);
	}

	@Benchmark
	public void testSimpleLoopResultLongInnerClass(Blackhole blackhole) {
		ResultLong result = new ResultLong();
		for (int v : INTEGER_LIST) {
			result.result += v;
		}
		assert result.result == ARRAY_SUM;
		blackhole.consume(result.result);
	}


	@Benchmark
	public void testSimpleLoopResultTemplateClass(Blackhole blackhole) {
		final Result<Long> result = new Result<>(0L);
		for (Integer v : INTEGER_LIST) {
			result.result += v;
		}
		assert result.result == ARRAY_SUM;
		blackhole.consume(result.result);
	}

	@Benchmark
	public void testStreamReduceMethod(Blackhole blackhole) {
		long result;
		result = INTEGER_LIST.stream().mapToLong(Integer::intValue).reduce(0L, Long::sum);
		assert result == ARRAY_SUM;
		blackhole.consume(result);
	}

	@Benchmark
	public void testMTStreamReduceMethod(Blackhole blackhole) {
		long result;
		result = INTEGER_LIST.parallelStream().mapToLong(Integer::intValue).reduce(0L, Long::sum);
		assert result == ARRAY_SUM;
		blackhole.consume(result);
	}

	@Benchmark
	public void testForEachAtomicLong(Blackhole blackhole) {
		final AtomicLong result = new AtomicLong();
		INTEGER_LIST.forEach(result::getAndAdd);
		assert result.get() == ARRAY_SUM;
		blackhole.consume(result.get());
	}

	@Benchmark
	public void testForEachSyncLong(Blackhole blackhole) {
		final ResultSyncLong result = new ResultSyncLong();
		INTEGER_LIST.forEach(result::getAndAdd);
		assert result.get() == ARRAY_SUM;
		blackhole.consume(result.get());
	}

	@Benchmark
	public void testForEachArrayLong(Blackhole blackhole) {
		final long[] result = new long[1];
		INTEGER_LIST.forEach(v -> result[0] += v);
		assert result[0] == ARRAY_SUM;
		blackhole.consume(result[0]);
	}

	@Benchmark
	public void testForEachResultTemplateClass(Blackhole blackhole) {
		final Result<Long> result = new Result<>(0L);
		INTEGER_LIST.forEach(v -> result.result += v);
		assert result.result == ARRAY_SUM;
		blackhole.consume(result.result);
	}

	@Benchmark
	public void testForEachResultLongClass(Blackhole blackhole) {
		final ResultLong result = new ResultLong();
		INTEGER_LIST.forEach(v -> result.result += v);
		assert result.result == ARRAY_SUM;
		blackhole.consume(result.result);
	}

	static class SumRunnable implements Runnable {
		private final List<Integer> arrayList;
		private final long[] results;
		private final int low;
		private final int high;
		private long result;
		private int resultId;

		@Override public void run() {
			result = 0L;
			for (int i = low; i <= high; i++) {
				result += arrayList.get(i);
			}
			if (results != null) {
				results[resultId] = result;
			}
		}

		SumRunnable(final List<Integer> arrayList, int low, int high, long[] results, int resultId) {
			this.arrayList = arrayList;
			this.low = low;
			this.high = Math.min(high, arrayList.size() - 1);
			this.results = results;
			this.resultId = resultId;
		}

		long get() {
			return result;
		}
	}

	@Benchmark
	public void executorServiceResultLong(Blackhole blackhole) {
		int parallelism = Runtime.getRuntime().availableProcessors() >>> 1;
		long result = 0L;
		final int arrayLastIndex = INTEGER_LIST.size() -1 ;
		final int sumSetLen = arrayLastIndex / parallelism;
		final SumRunnable[] sumTasks = new SumRunnable[parallelism];
		ExecutorService executorService = new ThreadPoolExecutor(parallelism, parallelism,
				5, TimeUnit.MINUTES, new ArrayBlockingQueue<>(100));
		for (int i = 0, start = 0; i < parallelism; i++, start += sumSetLen) {
			sumTasks[i] = new SumRunnable(INTEGER_LIST, start, start + sumSetLen - 1, null, i);
			executorService.execute(sumTasks[i]);
		}
		try {
			executorService.shutdown();
			executorService.awaitTermination(5, TimeUnit.MINUTES);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		for (int i = 0; i < parallelism; i++) {
			result += sumTasks[i].get();
		}
		assert result == ARRAY_SUM;
		blackhole.consume(result);
	}

	@Benchmark
	public void basicThreadsServiceResultLong(Blackhole blackhole) {
		int parallelism = Runtime.getRuntime().availableProcessors() >>> 1;
		long result = 0L;
		final int arrayLastIndex = INTEGER_LIST.size() -1 ;
		final int sumSetLen = arrayLastIndex / parallelism;
		final Thread[] sumTasks = new Thread[parallelism];
		final long[] partialResults = new long[parallelism];

		for (int i = 0, start = 0; i < parallelism; i++, start += sumSetLen) {
			sumTasks[i] = new Thread(new SumRunnable(INTEGER_LIST, start, start + sumSetLen - 1, partialResults, i));

		}
		try {
			for (int i = 0; i < parallelism; i++) {
				sumTasks[i].join();
			}
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		for (int i = 0; i < parallelism; i++) {
			result += partialResults[i];
		}
		assert result == ARRAY_SUM;
		blackhole.consume(result);
	}


	static class SumRecursiveTask extends RecursiveTask<Long> {
		private final List<Integer> arrayList;
		private final int low;
		private final int high;
		private static final long THRESHOLD = 20_000;

		SumRecursiveTask(final List<Integer> arrayList, int low, int high) {
			this.arrayList = arrayList;
			this.low = low;
			this.high = Math.min(high, arrayList.size() - 1);
		}

		@Override public Long compute() {
			long result = 0L;
			if (high - low <= THRESHOLD) {
				for (int i = low; i <= high; i++) {
					result += arrayList.get(i);
				}
			} else {
				int mid = (low + high) >>> 1;
				final SumRecursiveTask taskLo = new SumRecursiveTask(arrayList, low, mid);
				taskLo.fork();
				final SumRecursiveTask taskHi = new SumRecursiveTask(arrayList, mid, high);
				result = taskHi.compute() + taskLo.join();
			}
			return result;
		}
	}

	@Benchmark
	public void forkJoinResultLong(Blackhole blackhole) {
		final int parallelism = Runtime.getRuntime().availableProcessors() >>> 1;
		ForkJoinPool forkJoinPool = new ForkJoinPool(parallelism);
		final long result = forkJoinPool.invoke(new SumRecursiveTask(INTEGER_LIST, 0, INT_ARRAY_LENGTH));
		forkJoinPool.shutdownNow();
		assert result == ARRAY_SUM;
		blackhole.consume(result);
	}
}
