package com.tyy.stu.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

public class TExecutor {

    private TExecutor() {
    }

    private static final Logger log = LoggerFactory.getLogger(TExecutor.class);
    private static final ThreadPoolExecutor executor;
    private static final int MAX_QUEUE_SIZE = 100;
    private static final int CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors();
    private static final long MAX_KEEP_ALIVE_TIME_MINUTES = 1;

    static {
        executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                CORE_POOL_SIZE * 2,
                MAX_KEEP_ALIVE_TIME_MINUTES,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(MAX_QUEUE_SIZE),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        log.info("executor init success ! core pool size = {}", CORE_POOL_SIZE);
    }

    public static ThreadPoolExecutor getExecutor() {
        return executor;
    }


    public static <T> T execute(Callable<T> callable,
                                Long maxWaitTime,
                                TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        Future<T> submit = executor.submit(callable);
        return submit.get(maxWaitTime, timeUnit);
    }

    public static <T> Future<T> execute(Callable<T> callable) {
        return executor.submit(callable);
    }

    public static void execute(Runnable runnable) {
        executor.execute(runnable);
    }


}
