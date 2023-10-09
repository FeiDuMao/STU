package com.tyy.stu.reflect;

public class R1 {


    public String name;
    private Integer age;


    private String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPubAge(String age) {
        this.setAge(Integer.valueOf(age));
    }

    private void setAge(Integer age) {
        this.age = age;
    }

    public R1(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void r1PubMethod(String arg) {
        System.out.println("r1 pub method: " + arg);
    }


    private void r1PriMethod(String arg) {
        System.out.println("r1 pri method: " + arg);
    }


}
