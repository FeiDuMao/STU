package com.tyy.stu.designPatterns.proxy.prepare;

public class TransactionService {


    public void before() {
        System.out.println("========  transaction start =========");
    }

    public void after() {
        System.out.println("========  transaction end =========");
    }


}
