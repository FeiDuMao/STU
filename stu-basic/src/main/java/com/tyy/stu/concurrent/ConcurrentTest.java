package com.tyy.stu.concurrent;

import com.tyy.stu.utils.TExecutor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConcurrentTest {


    @SneakyThrows
    @Test
    public void test3() {

        CompletableFuture.runAsync(() -> SyncTest.test1());
        CompletableFuture.runAsync(() -> SyncTest.test2());

        Thread.sleep(15000);

    }

    @SneakyThrows
    @Test
    public void test2() {
        Future<String> execute = TExecutor.execute(() -> {
            Thread.sleep(10000);
            return "A";
        });
        execute.get();
    }


    @SneakyThrows
    @Test
    public void test() {

        ThreadPoolExecutor executor = TExecutor.getExecutor();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("aaa");
            }
        }, 1000);

        List<String> result = new ArrayList<>();

        Future<List<String>> future = executor.submit(() -> {
            result.add("aaa");
            result.add("bbb");
            result.add("ccc");
            System.out.println("add success");
        }, result);
        Future<String> result1 = executor.submit(() -> "null");
        result1.get();
        List<String> strings = future.get();
        System.out.println(strings.toString());


    }


    public static void main(String[] args) {


        Stream<Integer> integerStream1 = IntStream.range(0, 100).boxed();
        Stream<Integer> integerStream2 = IntStream.range(0, 100).boxed();
        Stream<Integer> integerStream3 = IntStream.range(0, 100).boxed();
        Stream<Integer> integerStream4 = IntStream.range(0, 100).boxed();
        long m1 = System.currentTimeMillis();


        Map<Integer, List<String>> result1 = integerStream1.collect(Collectors.toMap(Function.identity(), ConcurrentTest::fun));
        long m2 = System.currentTimeMillis();


        long m3 = System.currentTimeMillis();

        Map<Integer, List<String>> result2 = integerStream2.parallel().collect(Collectors.toMap(Function.identity(), ConcurrentTest::synFun));

        long m4 = System.currentTimeMillis();

        System.out.println("=====================\n");

        long m5 = System.currentTimeMillis();

        Map<Integer, List<String>> result3 = integerStream3.parallel().collect(Collectors.toMap(Function.identity(), ConcurrentTest::fun));

        long m6 = System.currentTimeMillis();

        Map<Integer, List<String>> result4 = integerStream4.parallel().collect(Collectors.toConcurrentMap(Function.identity(), ConcurrentTest::fun));
        long m7 = System.currentTimeMillis();


        System.out.println(m2 - m1);
        System.out.println(m4 - m3);
        System.out.println(m6 - m5);
        System.out.println(m7 - m6);

        Assertions.assertEquals(result1, result2);
        Assertions.assertEquals(result1, result3);
        Assertions.assertEquals(result2, result3);
        Assertions.assertEquals(result3, result4);

    }

    private static synchronized List<String> synFun(Integer integer) {
        System.out.println(Thread.currentThread().getName() + " : " + integer);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return List.of(integer.toString(), integer.toString());
    }

    private static List<String> fun(Integer integer) {
        System.out.println(Thread.currentThread().getName() + " : " + integer);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return List.of(integer.toString(), integer.toString());
    }


}
