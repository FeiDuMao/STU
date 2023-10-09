package com.tyy.stu.concurrent;

public class SyncTest {


    public static synchronized void test1() {
        System.out.println("sync test1!  ");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static synchronized void test2() {
        System.out.println("sync test2!  ");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}
