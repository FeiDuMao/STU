package solution;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class soluton01 {


    @Test
    public void test() {
        solve();
    }

    //起点
    private int start = 22220222;
    //每个线程计算分片的大小
    private final int gap = 2000;

    private List<PrimeInfo> solve() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                availableProcessors,//cpu密集型
                availableProcessors * 2,
                10,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(10),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        long startTime = System.currentTimeMillis();

        //用来存放任务队列和最终结果
        Set<PrimeInfo> result = new HashSet<>(1000);
        List<Future<Set<PrimeInfo>>> futureList = new ArrayList<>(availableProcessors);

        //添加任务到线程池中
        for (int i = 0; i < availableProcessors; i++) {
            Future<Set<PrimeInfo>> submit = executor.submit(() -> {
                int startNum = getStartNum();
                return getResult(startNum, startNum + gap);
            });
            futureList.add(submit);
        }
        //获取结果
        futureList.forEach(future -> {
            try {
                result.addAll(future.get());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });


        System.out.println("================");
        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println("================");

        return result.stream()
                .sorted(PrimeInfo::compareTo)
                .limit(1000)
                .peek(System.out::println)
                .toList();
    }


    /**
     * 通过多线程并行调用该方法，可以最快得到结果，
     * 根据结果大小的不同，需要注意分片的大小
     *
     * @param start 起点
     * @param end   终点
     * @return 区间内的所有质数信息
     */
    private Set<PrimeInfo> getResult(int start, int end) {
        Set<PrimeInfo> result = new HashSet<>(end - start);
        long startTime = System.currentTimeMillis();
        for (int i = start; i < end; i++) {
            if (isPrime(i)) {
                result.add(new PrimeInfo(i, Thread.currentThread().getId(), System.currentTimeMillis() - startTime));
            }
        }
        return result;
    }


    private boolean isPrime(int num) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    private synchronized int getStartNum() {
        start += gap;
        return start;
    }



}
