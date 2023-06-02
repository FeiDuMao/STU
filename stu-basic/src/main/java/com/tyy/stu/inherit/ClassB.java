package com.tyy.stu.inherit;


public class ClassB extends ClassA implements InterfaceB {

    private Integer b1;
    private Integer b2;


    @Override
    public void step1() {
        super.step1();
    }

    @Override
    public void step2() {
        System.out.println("class b step2");
    }

    public ClassB(Integer b1, Integer b2) {
        this.b1 = b1;
        this.b2 = b2;
    }

    public ClassB(Integer a1, Integer a2, Integer a3, Integer b1, Integer b2) {
        super(a1, a2, a3);
        this.b1 = b1;
        this.b2 = b2;
    }

    public ClassB(Integer a1, Integer a2, Integer a3) {
        super(a1, a2, a3);
    }


    public Integer getB1() {
        return b1;
    }

    public Integer getB2() {
        return b2;
    }


    public void setB1(Integer b1) {
        this.b1 = b1;
    }

    public void setB2(Integer b2) {
        this.b2 = b2;
    }

    @Override
    public String getBResult() {
        return "B";
    }
}
