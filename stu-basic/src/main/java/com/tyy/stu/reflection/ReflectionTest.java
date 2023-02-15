package com.tyy.stu.reflection;

import lombok.SneakyThrows;


public class ReflectionTest {


    @SneakyThrows
    public static void main(String[] args) {

        Class<?> clazz1 = ClassLoader.getSystemClassLoader().loadClass("com.tyy.stu.reflection.TestReflectionEntity");
//        Class<?> clazz2 = ClassLoader.getPlatformClassLoader().loadClass("com.tyy.stu.reflection.TestReflectionEntity");

        Class<?> clazz3 = Class.forName("com.tyy.stu.reflection.TestReflectionEntity");


    }


}
