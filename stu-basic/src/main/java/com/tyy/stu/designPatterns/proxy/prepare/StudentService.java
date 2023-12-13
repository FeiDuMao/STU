package com.tyy.stu.designPatterns.proxy.prepare;

import java.util.List;

public class StudentService implements StudentUseCase {

    @Override
    public void save() {
        System.out.println("save stu ok !");
    }

    @Override
    public List<String> queryAllStuName() {
        return List.of("a1", "a2");
    }
}
