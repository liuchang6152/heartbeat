package com.liuchang.heartbeat.service.bc;

import com.liuchang.heartbeat.entity.common.TelnetEntity;
import com.liuchang.heartbeat.pojo.bc.HostPojo;
import com.liuchang.heartbeat.pojo.bc.TelnetPojo;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 10:56 2019/9/23
 * @ Description：
 * @ Modified By：
 */
public interface TelnetService {
    public void addTelnet(TelnetEntity telnetEntity);

    public void editTelnet(TelnetEntity telnetEntity);

    public void deleteTelnet(TelnetEntity telnetEntity);

    public TelnetPojo findOne(TelnetEntity telnetEntity);

}
