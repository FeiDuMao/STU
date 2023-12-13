package com.tyy.stu.designPatterns.proxy;

import com.tyy.stu.designPatterns.proxy.prepare.DynamicProxyHandler;
import com.tyy.stu.designPatterns.proxy.prepare.StudentService;
import com.tyy.stu.designPatterns.proxy.prepare.StudentUseCase;
import com.tyy.stu.designPatterns.proxy.prepare.TransactionService;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;


/**
 *
 * jdk动态代理： 被代理的类需要实现某个接口
 *
 */
public class DynamicProxy {


    @Test
    public void test01() {

        StudentService studentService = new StudentService();
        TransactionService transactionService = new TransactionService();
        DynamicProxyHandler handler = new DynamicProxyHandler(transactionService, studentService);

        //此时java动态生成了一个代理类,通过反射初始化里面的变量；
        //在这个代理中，通过调用方法拦截器进行处理，所以并且不会因为StudentUseCase中新增了方法而导致报错
        StudentUseCase StudentServiceProxy = (StudentUseCase) Proxy.newProxyInstance(
                studentService.getClass().getClassLoader(),
                studentService.getClass().getInterfaces(),
                handler
        );

        StudentServiceProxy.save();

    }


}
