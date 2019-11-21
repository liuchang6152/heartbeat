package com.liuchang.heartbeat.service.bc.Impl;

import com.liuchang.heartbeat.common.timerUtil.DefaultSchedulingConfigurer;
import com.liuchang.heartbeat.dao.bc.HostDao;
import com.liuchang.heartbeat.dao.bc.TelnetDao;
import com.liuchang.heartbeat.entity.common.TelnetEntity;
import com.liuchang.heartbeat.pojo.bc.HostPojo;
import com.liuchang.heartbeat.pojo.bc.TelnetPojo;
import com.liuchang.heartbeat.service.bc.TelnetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.TriggerTask;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 10:52 2019/9/24
 * @ Description：
 * @ Modified By：
 */
@Service
@Transactional
public class TelnetServiceImpl implements TelnetService {
    @Autowired
    private TelnetDao telnetDao;

    @Override
    public void addTelnet(TelnetEntity telnetEntity) {
        TelnetPojo telnetPojo = new TelnetPojo();
        telnetPojo.setTelnetName(telnetEntity.getTelnetName());
        telnetPojo.setTelnetPort(telnetEntity.getPort());
        telnetPojo.setCreateTime(new Timestamp(System.currentTimeMillis()));
        telnetPojo.setHostId(telnetEntity.getHostId());
        telnetPojo.setEditTime(new Timestamp(System.currentTimeMillis()));
        telnetDao.save(telnetPojo);

    }

    @Override
    public void editTelnet(TelnetEntity telnetEntity) {
        TelnetPojo telnetPojo = telnetDao.findOne(telnetEntity.getTelenetId());
        telnetPojo.setHostId(telnetEntity.getHostId());
        telnetPojo.setTelnetPort(telnetEntity.getPort());
        telnetPojo.setTelnetName(telnetEntity.getTelnetName());
        telnetPojo.setEditTime(new Timestamp(System.currentTimeMillis()));
        telnetDao.save(telnetPojo);
    }

    @Override
    public void deleteTelnet(TelnetEntity telnetEntity) {
        telnetDao.delete(telnetEntity.getTelenetId());
    }

    @Override
    public TelnetPojo findOne(TelnetEntity telnetEntity) {
        return telnetDao.findOne(telnetEntity.getTelenetId());
    }
}
