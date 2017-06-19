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
IntAdderBenchmark.basicThreadsServiceResultLong       thrpt  200  200727.091 ± 626.676  ops/s
IntAdderBenchmark.executorServiceResultLong           thrpt  200    2564.003 ±  17.734  ops/s
IntAdderBenchmark.forkJoinResultLong                  thrpt  200    2273.682 ±  21.688  ops/s
IntAdderBenchmark.testForEachArrayLong                thrpt  200   10847.680 ±  49.720  ops/s
IntAdderBenchmark.testForEachAtomicLong               thrpt  200    1249.866 ±   3.397  ops/s
IntAdderBenchmark.testForEachResultLongClass          thrpt  200   12167.853 ±  36.798  ops/s
IntAdderBenchmark.testForEachResultTemplateClass      thrpt  200    1850.727 ±  16.010  ops/s
IntAdderBenchmark.testForEachSyncLong                 thrpt  200   10810.852 ± 731.614  ops/s
IntAdderBenchmark.testMTStreamReduceMethod            thrpt  200   21329.150 ±  64.164  ops/s
IntAdderBenchmark.testSimpleLoop                      thrpt  200   12694.820 ±  35.281  ops/s
IntAdderBenchmark.testSimpleLoopResultLongInnerClass  thrpt  200   12685.672 ±  29.333  ops/s
IntAdderBenchmark.testSimpleLoopResultTemplateClass   thrpt  200    2338.243 ±  15.340  ops/s
IntAdderBenchmark.testStreamReduceMethod              thrpt  200   11846.520 ± 101.391  ops/s

StringsBenchmark.testSimpleIteratorLoop               thrpt  200    279.333 ±   2.099  ops/s
StringsBenchmark.testSimpleIteratorLoopStringBuilder  thrpt  200  32920.691 ± 108.614  ops/s
StringsBenchmark.testSimpleLoop                       thrpt  200    283.926 ±   2.003  ops/s
StringsBenchmark.testSimpleLoopStringBuilder          thrpt  200  33871.431 ± 324.596  ops/s

SortingBenchmark.testCollectionsStringListSort     thrpt  200  117.708 ± 0.610  ops/s
SortingBenchmark.testParallelStreamStringListSort  thrpt  200   75.243 ± 0.426  ops/s
SortingBenchmark.testStreamStringListSort          thrpt  200   19.223 ± 0.137  ops/s
SortingBenchmark.testStringListSort                thrpt  200  121.870 ± 0.841  ops/s

```