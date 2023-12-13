package com.tyy.stu.designPatterns.proxy;

import com.tyy.stu.designPatterns.proxy.prepare.StudentService;
import com.tyy.stu.designPatterns.proxy.prepare.StudentUseCase;
import com.tyy.stu.designPatterns.proxy.prepare.TransactionService;
import lombok.Data;

import java.util.List;


/**
 * java 静态代理
 * 缺点： 当被代理的接口新加了方法时，所有的代理类都要跟着修改
 *       并且在代理对象中需要创建各种对象，随着业务变化，需要创建不同的增强对象
 */
@Data
public class StaticProxy implements StudentUseCase {


    private StudentService studentService;
    private TransactionService transactionService;


    @Override
    public void save() {
        //增强方法
        transactionService.before();
        //调用被代理的对象，执行操作
        studentService.save();
        //增强方法
        transactionService.after();
    }


    @Override
    public List<String> queryAllStuName() {
        return studentService.queryAllStuName();
    }
}
