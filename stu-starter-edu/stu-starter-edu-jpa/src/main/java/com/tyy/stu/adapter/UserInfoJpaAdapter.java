package com.tyy.stu.adapter;


import com.tyy.stu.adapter.entity.UserInfoEntity;
import com.tyy.stu.adapter.jpa.UserInfoRepository;
import com.tyy.stu.domain.UserInfo;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserInfoJpaAdapter {

    private final UserInfoRepository userInfoRepository;

    /**
     * 在使用jpa提供的基础查询方法时，入参不能为null
     */
    public Optional<UserInfo> queryById(@NonNull String userName) {
        return userInfoRepository.findById(userName).map(UserInfoEntity::convert);
    }

    /**
     * 使用自己写的方法时，可以传null
     */
    public Optional<UserInfo> queryByUserName(String userName) {
        return userInfoRepository.findByUserName(userName).map(UserInfoEntity::convert);
    }


}
