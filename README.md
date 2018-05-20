# java-feature-bench

```
# JMH version: 1.19
# VM version: JDK 1.8.0_162, VM 25.162-b12
# VM invoker: c:\workspaces\DevTools\jdk1.8.0_162_x64\jre\bin\java.exe
# VM options: <none>

Benchmark                                              Mode  Cnt       Score       Error  Units
IntAdderBenchmark.basicThreadsServiceResultLong       thrpt  100  484220.530 ± 14439.499  ops/s
IntAdderBenchmark.executorServiceResultLong           thrpt  100    4283.453 ±   124.660  ops/s
IntAdderBenchmark.forkJoinResultLong                  thrpt  100    3729.094 ±   190.985  ops/s
IntAdderBenchmark.testForEachArrayLong                thrpt  100   10093.142 ±   218.909  ops/s
IntAdderBenchmark.testForEachAtomicLong               thrpt  100    1259.436 ±    12.323  ops/s
IntAdderBenchmark.testForEachResultLongClass          thrpt  100    9596.248 ±   283.350  ops/s
IntAdderBenchmark.testForEachResultTemplateClass      thrpt  100    1817.693 ±    42.304  ops/s
IntAdderBenchmark.testForEachSyncLong                 thrpt  100    3350.969 ±   103.761  ops/s
IntAdderBenchmark.testMTStreamReduceMethod            thrpt  100   11767.660 ±  1034.242  ops/s
IntAdderBenchmark.testSimpleLoop                      thrpt  100   11493.174 ±   246.321  ops/s
IntAdderBenchmark.testSimpleLoopResultLongInnerClass  thrpt  100   11248.614 ±   349.815  ops/s
IntAdderBenchmark.testSimpleLoopResultTemplateClass   thrpt  100    2181.235 ±    90.780  ops/s
IntAdderBenchmark.testStreamReduceMethod              thrpt  100   10554.986 ±   124.006  ops/s

PrimesESBenchmark.testEratosthenesSieveV1             thrpt  100      68.824 ±     1.508  ops/s
PrimesESBenchmark.testEratosthenesSieveV2             thrpt  100     185.767 ±     3.547  ops/s
PrimesESBenchmark.testEratosthenesSieveV3             thrpt  100     220.727 ±     6.750  ops/s
PrimesESBenchmark.testEratosthenesSieveV3a            thrpt  100     238.908 ±     2.847  ops/s
PrimesESBenchmark.testEratosthenesSieveV4             thrpt  100     144.264 ±     3.583  ops/s

SortingBenchmark.testCollectionsStringListSort        thrpt  100     132.726 ±     2.212  ops/s
SortingBenchmark.testParallelStreamStringListSort     thrpt  100      18.643 ±     0.504  ops/s
SortingBenchmark.testStreamStringListSort             thrpt  100      19.463 ±     0.246  ops/s
SortingBenchmark.testStringListSort                   thrpt  100     130.822 ±     4.334  ops/s

StringConcatZipLoop.testLoopWithConcat                thrpt  100       0.335 ±     0.013  ops/s
StringConcatZipLoop.testLoopWithDoubleWrite           thrpt  100       0.340 ±     0.009  ops/s

StringsBenchmark.testSimpleIteratorLoop               thrpt  100     288.351 ±     3.776  ops/s
StringsBenchmark.testSimpleIteratorLoopStringBuilder  thrpt  100   30448.398 ±   435.241  ops/s
StringsBenchmark.testSimpleLoop                       thrpt  100     284.308 ±     3.748  ops/s
StringsBenchmark.testSimpleLoopStringBuilder          thrpt  100   30906.397 ±   651.853  ops/s

# JMH version: 1.19
# VM version: JDK 10.0.1, VM 10.0.1+10
# VM invoker: C:\Program Files\Java\jre-10.0.1\bin\java.exe
# VM options: <none>

Benchmark                                              Mode  Cnt       Score      Error  Units
IntAdderBenchmark.basicThreadsServiceResultLong       thrpt  200  147539,126 ? 1303,501  ops/s
IntAdderBenchmark.executorServiceResultLong           thrpt  200    1625,646 ?   11,254  ops/s
IntAdderBenchmark.forkJoinResultLong                  thrpt  200    1387,670 ?   19,934  ops/s
IntAdderBenchmark.testForEachArrayLong                thrpt  200    9988,254 ?  129,475  ops/s
IntAdderBenchmark.testForEachAtomicLong               thrpt  200    1209,106 ?    5,085  ops/s
IntAdderBenchmark.testForEachResultLongClass          thrpt  200   10957,586 ?  168,127  ops/s
IntAdderBenchmark.testForEachResultTemplateClass      thrpt  200    1419,492 ?   26,860  ops/s
IntAdderBenchmark.testForEachSyncLong                 thrpt  200   11285,578 ?  268,839  ops/s
IntAdderBenchmark.testMTStreamReduceMethod            thrpt  200   17588,225 ?   39,268  ops/s
IntAdderBenchmark.testSimpleLoop                      thrpt  200   13535,661 ?  178,087  ops/s
IntAdderBenchmark.testSimpleLoopResultLongInnerClass  thrpt  200   13793,452 ?  120,398  ops/s
IntAdderBenchmark.testSimpleLoopResultTemplateClass   thrpt  200    1928,898 ?   25,481  ops/s
IntAdderBenchmark.testStreamReduceMethod              thrpt  200   10359,634 ?   42,650  ops/s

PrimesESBenchmark.testEratosthenesSieveV1             thrpt  200      70,321 ?    0,466  ops/s
PrimesESBenchmark.testEratosthenesSieveV2             thrpt  200     192,674 ?    1,410  ops/s
PrimesESBenchmark.testEratosthenesSieveV3             thrpt  200     192,015 ?    1,097  ops/s
PrimesESBenchmark.testEratosthenesSieveV3a            thrpt  200     238,155 ?    1,137  ops/s
PrimesESBenchmark.testEratosthenesSieveV4             thrpt  200     153,425 ?    1,313  ops/s

SortingBenchmark.testCollectionsStringListSort        thrpt  200     125,630 ?    1,206  ops/s
SortingBenchmark.testParallelStreamStringListSort     thrpt  200      81,117 ?    0,607  ops/s
SortingBenchmark.testStreamStringListSort             thrpt  200      19,265 ?    0,190  ops/s
SortingBenchmark.testStringListSort                   thrpt  200     128,746 ?    0,546  ops/s

StringConcatZipLoop.testLoopWithConcat                thrpt  200       0,343 ?    0,003  ops/s
StringConcatZipLoop.testLoopWithDoubleWrite           thrpt  200       0,347 ?    0,002  ops/s

StringsBenchmark.testSimpleIteratorLoop               thrpt  200     534,586 ?    3,540  ops/s
StringsBenchmark.testSimpleIteratorLoopStringBuilder  thrpt  200   45552,046 ?  219,595  ops/s
StringsBenchmark.testSimpleLoop                       thrpt  200     533,320 ?    3,078  ops/s
StringsBenchmark.testSimpleLoopStringBuilder          thrpt  200   47118,996 ?  370,870  ops/s
```