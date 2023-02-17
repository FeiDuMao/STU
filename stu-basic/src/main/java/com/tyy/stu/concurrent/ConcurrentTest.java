package com.tyy.stu.concurrent;

import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConcurrentTest {



    public static void main(String[] args) {


        Stream<Integer> integerStream1 = IntStream.range(0, 100).boxed();
        Stream<Integer> integerStream2 = IntStream.range(0, 100).boxed();
        Stream<Integer> integerStream3 = IntStream.range(0, 100).boxed();
        long m1 = System.currentTimeMillis();


        Map<Integer, List<String>> result1 = integerStream1.collect(Collectors.toMap(
                Function.identity(),
                ConcurrentTest::fun
        ));
        long m2 = System.currentTimeMillis();


        long m3 = System.currentTimeMillis();

        Map<Integer, List<String>> result2 = integerStream2.parallel().collect(Collectors.toMap(
                Function.identity(),
                ConcurrentTest::synFun
        ));

        long m4 = System.currentTimeMillis();

        System.out.println("=====================\n");

        long m5 = System.currentTimeMillis();

        Map<Integer, List<String>> result3 = integerStream3.parallel().collect(Collectors.toMap(
                Function.identity(),
                ConcurrentTest::fun
        ));

        long m6 = System.currentTimeMillis();

        System.out.println(m2 - m1);
        System.out.println(m4 - m3);
        System.out.println(m6 - m5);

        Assertions.assertEquals(result1,result2);
        Assertions.assertEquals(result1,result3);
        Assertions.assertEquals(result2,result3);

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
