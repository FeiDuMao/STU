package com.tyy.stu.designPatterns.stragey;


import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * 策略模式： 利用java的多态特性 根据传入的 type 选择不同的处理方法 。
 * 解决了传统开发中的大量if-else的判断，并且更加符合开闭原则的开发思想（尽量增加代码而不是修改原有代码）
 * 和工厂模式的区别在于： 工厂模式是一个创建模式（关注重点是对象），而策略模式是一个行为模式（关注重点是方法）,
 */
@AllArgsConstructor
public class StrageyPattern {


    /**
     * 在configuration中配置相应的bean, 即可实现依赖注入
     */
    private Map<Integer, StrageyUseCase> strageyUseCaseMap;


    /**
     * spring自动将实现了该接口的bean注入进来,但是实现类需要实现判断类型的接口，然后通过该接口筛选到对应的Service
     */
    private List<StrageyUseCase> strageyUseCaseList;


    public void handleRequest(SRequest request) {

        //根据传入的类型选择不同的处理方法，这样如果出现新的处理方式，只需要再实现一次StrageyUseCase即可，而不用改动这里的代码
        StrageyUseCase strageyUseCase = strageyUseCaseMap.get(request.getType());
        if (strageyUseCase == null) throw new IllegalArgumentException("");
        strageyUseCase.handle(request);

        //do other

    }


}
