package com.liuchang.heartbeat.pojo.bc;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 14:10 2019/9/24
 * @ Description：
 * @ Modified By：
 */
@Entity
@DynamicUpdate
@Table(name = "t_BC_Group")
public class GroupPojo {
    /**
     * 主键
     */
    @Id
    @Column(name = "groupId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;
    /**
     * 组名称
     */
    @Column(name = "groupName")
    private String groupName;
    /**
     * 所属人
     */
    @Column(name = "userId")
    private Long userId;
    /**
     *创建时间
     */
    @Column(name = "createTime")
    private Timestamp createTime;
    /**
     *修改时间
     */
    @Column(name = "editTime")
    private Timestamp editTime;

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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getEditTime() {
        return editTime;
    }

    public void setEditTime(Timestamp editTime) {
        this.editTime = editTime;
    }
}
