package com.tyy.stu.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder
@Getter
@ToString
public class UserInfo {


    private final String userName;
    private final String nickName;
    private final String password;
    private final String phone;
    private final String deptName;
    private final String status;
    private final Boolean subscribeUpdateNote;
    private final LocalDateTime createTime;
    private final LocalDateTime updateTime;

    public UserInfo.UserInfoBuilder copyBuilder() {
        return UserInfo.builder()
                .userName(userName)
                .nickName(nickName)
                .password(password)
                .phone(phone)
                .deptName(deptName)
                .status(status)
                .subscribeUpdateNote(subscribeUpdateNote)
                .createTime(createTime)
                .updateTime(updateTime);
    }

}
