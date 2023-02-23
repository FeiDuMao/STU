package com.tyy.stu.adapter.jpa;

import com.tyy.stu.adapter.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfoEntity, String> {

    Optional<UserInfoEntity> findByUserName(String userName);
}
