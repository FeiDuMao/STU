package com.tyy.stu.designPatterns.proxy.prepare;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Data
@AllArgsConstructor
public class CglibInterceptor implements MethodInterceptor {

    private TransactionService transactionService;


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        transactionService.before();
        Object result = proxy.invokeSuper(obj, args);
        transactionService.after();
        return result;
    }


}
