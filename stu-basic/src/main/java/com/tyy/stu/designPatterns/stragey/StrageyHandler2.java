package com.tyy.stu.designPatterns.stragey;

public class StrageyHandler2 implements StrageyUseCase {


    @Override
    public void handle(SRequest request) {
        System.out.println("handler2 ：" + request.getArg2());
    }


}
