package com.tyy.stu.inherit;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassA implements InterfaceA {

    private Integer a1;
    protected Integer a2;
    public Integer a3;


    @Override
    public String getAResult() {
        return "A";
    }
}
