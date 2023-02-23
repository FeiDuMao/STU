package com.tyy.stu.adapter;


import com.tyy.stu.adapter.entity.UserInfoEntity;
import com.tyy.stu.adapter.jpa.UserInfoRepository;
import com.tyy.stu.domain.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserInfoJpaAdapter {

    private final UserInfoRepository userInfoRepository;


    public Optional<UserInfo> queryByUserName(String userName) {
        return userInfoRepository.findById(userName).map(UserInfoEntity::convert);
    }


}
