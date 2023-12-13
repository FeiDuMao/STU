package com.tyy.stu.designPatterns.proxy.prepare;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


/**
 * 方法拦截器: 对需要增强的方法，进行处理
 */
@Data
@AllArgsConstructor
public class DynamicProxyHandler implements InvocationHandler {


    //增强方法
    private TransactionService transactionService;

    //被代理的对象
    private Object object;


    /**
     * @param proxy : jdk动态生成的对象 Prox.newInstance(...)
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result;
        if ("save".equals(method.getName())) {

            transactionService.before();
            System.out.println(proxy.getClass().getSimpleName());
            result = method.invoke(object, args);
            transactionService.after();

        } else {
            result = method.invoke(object, args);
        }

        return result;
    }
}
