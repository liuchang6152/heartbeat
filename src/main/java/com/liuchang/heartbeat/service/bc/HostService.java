package com.liuchang.heartbeat.service.bc;

import com.liuchang.heartbeat.entity.common.HostEntity;
import com.liuchang.heartbeat.entity.common.TelnetEntity;
import com.liuchang.heartbeat.pojo.bc.HostPojo;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 11:31 2019/9/24
 * @ Description：
 * @ Modified By：
 */
public interface HostService {
    public void addHost(HostEntity hostEntity);

    public void editHost(HostEntity hostEntity);

    public void deleteHost(HostEntity hostEntity);

    public HostPojo getOne(HostEntity hostEntity);
}
