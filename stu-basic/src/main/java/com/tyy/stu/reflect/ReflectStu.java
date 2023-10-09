package com.tyy.stu.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectStu {


    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException {

        R1 r1 = new R1("tyy", 2);
        Class<? extends R1> r1Class = r1.getClass();

        for (Field declaredField : r1Class.getDeclaredFields()) {

            declaredField.setAccessible(true);
            if (declaredField.getType().equals(Integer.class)) {
                declaredField.set(r1, 3);
            }

            System.out.println(declaredField.getClass());
            System.out.println(declaredField.getName() + ": " + declaredField.get(r1));

        }

        Constructor<? extends R1> r1ClassConstructor = r1Class.getConstructor(String.class, Integer.class);
        r1ClassConstructor.setAccessible(true);

        R1 zzz = r1ClassConstructor.newInstance("zzz", 1);
        for (Method declaredMethod : r1Class.getDeclaredMethods()) {
            declaredMethod.setAccessible(true);
            if (declaredMethod.getName().equals("getName") && declaredMethod.getReturnType().equals(String.class)) {
                System.out.println(declaredMethod.invoke(zzz));
            }
        }


    }


}
