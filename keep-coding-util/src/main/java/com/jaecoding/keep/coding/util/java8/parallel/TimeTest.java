package com.jaecoding.keep.coding.util.java8.parallel;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class TimeTest {

    public static void main(String[] args) {
        System.out.println("Sequential sum done in:" +
                measureSumPerf(TimeTest::sequentialSum, 10_000_000) + " msecs");
        System.out.println("iterativeSum sum done in:" +
                measureSumPerf(TimeTest::iterativeSum, 10_000_000) + " msecs");
        System.out.println("parallelSum sum done in:" +
                measureSumPerf(TimeTest::parallelSum, 10_000_000) + " msecs");
        System.out.println("rangedSum sum done in:" +
                measureSumPerf(TimeTest::rangedSum, 10_000_000) + " msecs");
        System.out.println("parallelRangedSum sum done in:" +
                measureSumPerf(TimeTest::parallelRangedSum, 10_000_000) + " msecs");


    }

    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            if (duration < fastest) {
                fastest = duration;
            }
        }
        return fastest;
    }

    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public static long sequentialSum(long n) {
        //用的是iterate ，会装箱拆箱
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .reduce(0L, Long::sum);
    }

    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0L, Long::sum);
    }
}
