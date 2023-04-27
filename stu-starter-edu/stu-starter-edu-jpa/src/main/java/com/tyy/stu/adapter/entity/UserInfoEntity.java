package com.tyy.stu.adapter.entity;

import com.tyy.stu.domain.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Table(name = "user_info")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoEntity implements Serializable {

    @Id
    private String userName;
    private String nickName;
    private String password;
    /**
     * @JoinColumn(name = "role")
     * @NotFound(action = NotFoundAction.IGNORE)
     * @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
     * private Role role;
     */
    private String phone;
    private String deptName;
    private String status;
    private Boolean subscribeUpdateNote;
    @Generated(GenerationTime.INSERT)
    private LocalDateTime createTime;
    @Generated(GenerationTime.ALWAYS)
    private LocalDateTime updateTime;


    public UserInfo convert() {
        return UserInfo.builder()
                .userName(userName)
                .nickName(nickName)
                .password(password)
                .phone(phone)
                .deptName(deptName)
                .status(status)
                .subscribeUpdateNote(subscribeUpdateNote)
                .createTime(createTime)
                .updateTime(updateTime)
                .build();
    }


}
