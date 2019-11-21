package com.liuchang.heartbeat.service.bc;

import com.liuchang.heartbeat.entity.bc.GroupEntity;
import com.liuchang.heartbeat.pojo.bc.GroupPojo;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 14:19 2019/9/24
 * @ Description：
 * @ Modified By：
 */
public interface GroupService {
    public void addGroup(GroupEntity groupEntity);

    public void editGroup(GroupEntity groupEntity);

    public void deleteGroup(GroupEntity groupEntity);

    public GroupPojo getOne(GroupEntity groupEntity);
}
