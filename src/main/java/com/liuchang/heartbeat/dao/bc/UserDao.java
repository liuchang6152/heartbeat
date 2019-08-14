package com.liuchang.heartbeat.dao.bc;

import com.liuchang.heartbeat.pojo.bc.UserPojo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 14:24 2019/8/12
 * @ Description：用户的持久层接口
 * @ Modified By：
 */
public interface UserDao extends JpaRepository<UserPojo, Long> {
}
