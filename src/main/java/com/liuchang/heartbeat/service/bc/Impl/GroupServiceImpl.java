package com.liuchang.heartbeat.service.bc.Impl;

import com.liuchang.heartbeat.dao.bc.GroupDao;
import com.liuchang.heartbeat.entity.bc.GroupEntity;
import com.liuchang.heartbeat.pojo.bc.GroupPojo;
import com.liuchang.heartbeat.service.bc.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 14:26 2019/9/24
 * @ Description：
 * @ Modified By：
 */
@Service
@Transactional
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupDao groupDao;
    @Override
    public void addGroup(GroupEntity groupEntity) {
        GroupPojo groupPojo = new GroupPojo();
        groupPojo.setGroupName(groupEntity.getGroupName());
        groupPojo.setUserId(groupEntity.getUserId());
        groupPojo.setCreateTime(new Timestamp(System.currentTimeMillis()));
        groupPojo.setEditTime(new Timestamp(System.currentTimeMillis()));
        groupDao.save(groupPojo);
    }

    @Override
    public void editGroup(GroupEntity groupEntity) {
        GroupPojo groupPojo = groupDao.findOne(groupEntity.getGroupId());
        groupPojo.setEditTime(new Timestamp(System.currentTimeMillis()));
        groupPojo.setGroupName(groupEntity.getGroupName());
        groupPojo.setUserId(groupEntity.getUserId());
        groupDao.save(groupPojo);
    }

    @Override
    public void deleteGroup(GroupEntity groupEntity) {
        groupDao.delete(groupEntity.getGroupId());
    }

    @Override
    public GroupPojo getOne(GroupEntity groupEntity) {
        return groupDao.getOne(groupEntity.getGroupId());
    }
}
