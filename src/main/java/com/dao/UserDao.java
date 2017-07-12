package com.dao;

import com.pojo.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by weber on 2017/7/11.
 */

@Repository
public interface UserDao extends JpaRepository<UserEntity,String> {
    UserEntity findByUsername(String username);
}
