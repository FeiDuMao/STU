package com.tyy.stu.inherit;

import org.junit.jupiter.api.Test;

public class inheritTest {


    @Test
    public void test() {

        InterfaceA classA = new ClassA(1, 2, 3);
        InterfaceB classB = new ClassB(1, 2, 3, 4, 5);


        InterfaceA classA1 = (InterfaceA) classB;
        InterfaceB classB1 = (InterfaceB) classA;

        System.out.println(classA1);
        System.out.println(classB1);


    }


}
