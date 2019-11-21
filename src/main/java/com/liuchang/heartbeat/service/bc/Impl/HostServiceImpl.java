package com.liuchang.heartbeat.service.bc.Impl;

import com.liuchang.heartbeat.dao.bc.HostDao;
import com.liuchang.heartbeat.entity.common.HostEntity;
import com.liuchang.heartbeat.entity.common.TelnetEntity;
import com.liuchang.heartbeat.pojo.bc.HostPojo;
import com.liuchang.heartbeat.service.bc.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 11:31 2019/9/24
 * @ Description：
 * @ Modified By：
 */
@Service
@Transactional
public class HostServiceImpl implements HostService {
    @Autowired
    private HostDao hostDao;

    @Override
    public void addHost(HostEntity hostEntity) {
        HostPojo hostPojo = new HostPojo();
        hostPojo.setHostName(hostEntity.getName());
        hostPojo.setHostIp(hostEntity.getHostIp());
        hostPojo.setCreateTime(new Timestamp(System.currentTimeMillis()));
        hostPojo.setEditTime(new Timestamp(System.currentTimeMillis()));
        hostDao.save(hostPojo);
    }

    @Override
    public void editHost(HostEntity hostEntity) {
        HostPojo hostPojo = hostDao.findOne(hostEntity.getHostId());
        hostPojo.setHostIp(hostEntity.getHostIp());
        hostPojo.setHostName(hostEntity.getName());
        hostPojo.setHostId(hostEntity.getHostId());
        hostPojo.setEditTime(new Timestamp(System.currentTimeMillis()));
        hostDao.save(hostPojo);
    }

    @Override
    public void deleteHost(HostEntity hostEntity) {
        hostDao.delete(hostEntity.getHostId());
    }

    @Override
    public HostPojo getOne(HostEntity hostEntity) {
        return hostDao.getOne(hostEntity.getHostId());
    }
}
