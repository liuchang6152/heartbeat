package com.liuchang.heartbeat.dao.bc;

import com.liuchang.heartbeat.pojo.bc.GroupPojo;
import com.liuchang.heartbeat.pojo.bc.HostGroupPojo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 15:01 2019/9/24
 * @ Description：
 * @ Modified By：
 */
public interface HostGroupDao extends JpaRepository<HostGroupPojo, Long> {
}
