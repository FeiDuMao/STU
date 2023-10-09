package com.tyy.stu.designPatterns.stragey;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SRequest {


    private Integer type;
    private String arg1;
    private String arg2;
    private String arg3;


}
