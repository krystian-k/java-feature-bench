# java-feature-bench

```
# JMH 1.18
# VM version: JDK 1.8.0_102, VM 25.102-b14
# VM invoker: C:\jdk1.8.0_102_x64\jre\bin\java.exe
# VM options: -Dfile.encoding=windows-1250 -Duser.country=US -Duser.language=en -Duser.variant
# Warmup: 20 iterations, 1 s each
# Measurement: 20 iterations, 1 s each
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Throughput, ops/time

Benchmark                                              Mode  Cnt       Score     Error  Units
IntAdderBenchmark.testForEachAtomicLong               thrpt  200   13240.082 ±  47.542  ops/s
IntAdderBenchmark.testForEachResultLongClass          thrpt  200  126327.765 ± 613.013  ops/s
IntAdderBenchmark.testForEachResultTemplateClass      thrpt  200   23276.377 ±  76.353  ops/s
IntAdderBenchmark.testMTStreamReduceMethod            thrpt  200   31330.278 ± 121.301  ops/s
IntAdderBenchmark.testSimpleLoop                      thrpt  200  140468.985 ± 741.820  ops/s
IntAdderBenchmark.testSimpleLoopResultLongInnerClass  thrpt  200  141803.716 ± 485.884  ops/s
IntAdderBenchmark.testSimpleLoopResultTemplateClass   thrpt  200   25425.013 ± 119.071  ops/s
IntAdderBenchmark.testStreamReduceMethod              thrpt  200   23640.805 ±  74.032  ops/s

StringsBenchmark.testSimpleIteratorLoop               thrpt  200    269,519 ?   2,998  ops/s
StringsBenchmark.testSimpleIteratorLoopStringBuilder  thrpt  200  29247,184 ? 644,364  ops/s
StringsBenchmark.testSimpleLoop                       thrpt  200    256,275 ?   5,488  ops/s
StringsBenchmark.testSimpleLoopStringBuilder          thrpt  200  34027,070 ?  94,363  ops/s

SortingBenchmark.testCollectionsStringListSort     thrpt  200  93667,494 ? 813,331  ops/s
SortingBenchmark.testParallelStreamStringListSort  thrpt  200   3270,214 ?  49,580  ops/s
SortingBenchmark.testStreamStringListSort          thrpt  200   4234,420 ?  30,394  ops/s
SortingBenchmark.testStringListSort                thrpt  200  92498,277 ? 502,763  ops/s
```