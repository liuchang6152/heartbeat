package com.liuchang.heartbeat.dao.bc;

import com.liuchang.heartbeat.pojo.bc.HostPojo;
import com.liuchang.heartbeat.pojo.bc.UserPojo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 10:44 2019/9/24
 * @ Description：
 * @ Modified By：
 */
public interface HostDao extends JpaRepository<HostPojo, Long> {
}
