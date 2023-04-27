package com.tyy.stu.benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.*;


/**
 * 测试list与set在contains上的性能差别
 *
 */
@State(Scope.Thread)
@Warmup(iterations = 1)
@Measurement(iterations = 2)
@BenchmarkMode(Mode.Throughput)
public class BenchMarkTest3 {

    @Param({"100000"})
    int n;

    List<Integer> list1;
    Set<Integer> set1;
    Random random;


    @Setup
    public void init() {
        list1 = new LinkedList<>();
        set1 = new HashSet<>();
        for (int i = 0; i < n; i++) {
            list1.add(i);
            set1.add(i);
        }
        random = new Random();
    }

    @Benchmark
    public void list_contains() {
        for (int i = 0; i < n; i++) {
            list1.contains(random.nextInt(n));
        }

    }

    @Benchmark
    public void set_contains() {
        for (int i = 0; i < n; i++) {
            set1.contains(random.nextInt(n));
        }
    }


    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(BenchMarkTest3.class.getSimpleName())
                .forks(4)
                .build();
        new Runner(options).run();

    }


}
