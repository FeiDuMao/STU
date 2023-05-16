package com.tyy.stu.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    private Integer id;
    private String name;
    private Integer age;
    private String phoneNum;
    private String address;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
