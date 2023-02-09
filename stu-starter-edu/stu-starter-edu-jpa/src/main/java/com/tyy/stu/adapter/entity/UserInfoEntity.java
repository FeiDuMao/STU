package com.tyy.stu.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Table(name = "user")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoEntity implements Serializable {

    @Id
    private String userName;
    private String nickName;
    private String password;
    private String phone;
    private String deptName;
    private String status;
    private Boolean subscribeUpdateNote;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
