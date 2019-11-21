package com.liuchang.heartbeat.entity.bc;

import java.sql.Timestamp;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 14:14 2019/9/24
 * @ Description：
 * @ Modified By：
 */
public class GroupEntity {
    /**
     * 主键
     */
    private Long groupId;
    /**
     * 组名称
     */
    private String groupName;
    /**
     * 所属人
     */
    private Long userId;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
