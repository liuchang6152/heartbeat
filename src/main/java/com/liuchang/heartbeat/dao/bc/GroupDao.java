package com.liuchang.heartbeat.dao.bc;

import com.liuchang.heartbeat.pojo.bc.GroupPojo;
import com.liuchang.heartbeat.pojo.bc.HostPojo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 14:16 2019/9/24
 * @ Description：
 * @ Modified By：
 */
public interface GroupDao extends JpaRepository<GroupPojo, Long> {
}
