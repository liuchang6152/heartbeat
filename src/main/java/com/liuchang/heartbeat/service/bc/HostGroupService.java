package com.liuchang.heartbeat.service.bc;

import com.liuchang.heartbeat.entity.bc.HostGroupEntity;
import com.liuchang.heartbeat.pojo.bc.HostGroupPojo;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 15:02 2019/9/24
 * @ Description：
 * @ Modified By：
 */
public interface HostGroupService {
    public void addHostGroup(HostGroupEntity hostGroupEntity);

    public void editHostGroup(HostGroupEntity hostGroupEntity);

    public void deleteHostGroup(HostGroupEntity hostGroupEntity);

    public HostGroupPojo findOne(HostGroupEntity hostGroupEntity);
}
