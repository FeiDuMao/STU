package com.tyy.stu.designPatterns.stragey;

public class StrageyHandler1 implements StrageyUseCase {


    @Override
    public void handle(SRequest request) {
        System.out.println("handler1 ：" + request.getArg1());
    }


}
