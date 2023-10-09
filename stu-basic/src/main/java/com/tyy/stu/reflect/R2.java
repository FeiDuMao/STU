package com.tyy.stu.reflect;

public class R2 {


    public String r2Name;
    private Integer r2Age;


    public void setr2Name(String r2Name) {
        this.r2Name = r2Name;
    }

    public void setPubr2Age(String r2Age) {
        this.setr2Age(Integer.valueOf(r2Age));
    }

    private void setr2Age(Integer r2Age) {
        this.r2Age = r2Age;
    }

    public R2(String r2Name, Integer r2Age) {
        this.r2Name = r2Name;
        this.r2Age = r2Age;
    }


}
