package com.tyy.stu.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@Table(name = "user_info")
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    private Integer id;

    @Column(name = "")
    private String name;
    private Integer age;
    private String phoneNum;
    private String address;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
