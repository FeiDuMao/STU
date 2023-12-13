package com.tyy.stu.designPatterns.proxy;

import com.tyy.stu.designPatterns.proxy.prepare.CglibInterceptor;
import com.tyy.stu.designPatterns.proxy.prepare.StudentService;
import com.tyy.stu.designPatterns.proxy.prepare.TransactionService;
import net.sf.cglib.proxy.Enhancer;
import org.junit.jupiter.api.Test;


/**
 * cglib代理：被代理的对象可以不用实现某个接口
 *
 * 通过继承的方式获取目标对象的方法
 * 通过MethodInterceptor进行方法拦截
 *
 *
 * 注意点： 类，方法不能被final修饰
 *
 *
 *
 */
public class CglibProxy {



    @Test
    public void test(){
        TransactionService transactionService = new TransactionService();
        CglibInterceptor cglibInterceptor = new CglibInterceptor(transactionService);

        //jdk17以上会报错
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(StudentService.class);
        enhancer.setCallback(cglibInterceptor);


        StudentService cglibProxy = (StudentService)enhancer.create();

        cglibProxy.save();

    }



}
