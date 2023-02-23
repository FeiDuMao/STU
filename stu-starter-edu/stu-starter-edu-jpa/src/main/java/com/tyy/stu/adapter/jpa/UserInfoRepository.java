package com.tyy.stu.adapter.jpa;

import com.tyy.stu.adapter.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfoEntity, String> {
}
