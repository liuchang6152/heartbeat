package com.liuchang.heartbeat.pojo.bc;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 10:39 2019/9/24
 * @ Description：主机pojo
 * @ Modified By：
 */
@Entity
@DynamicUpdate
@Table(name = "T_BC_HOST")
public class HostPojo {
    /**
     * 主键
     */
    @Id
    @Column(name = "hostId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hostId;
    /**
     * 名字
     */
    @Column(name = "hostName")
    private String hostName;

    /**
     * 主机IP
     */
    @Column(name = "hostIp")
    private String hostIp;
    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private Timestamp createTime;
    /**
     * 修改时间
     */
    @Column(name = "editTime")
    private Timestamp editTime;

    public Long getHostId() {
        return hostId;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
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

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }
}
