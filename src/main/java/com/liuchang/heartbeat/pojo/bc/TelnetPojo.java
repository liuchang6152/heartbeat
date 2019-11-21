package com.liuchang.heartbeat.pojo.bc;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 11:15 2019/9/24
 * @ Description：
 * @ Modified By：
 */
@Entity
@DynamicUpdate
@Table(name = "T_BC_TELNET")
public class TelnetPojo {
    /**
     * 主键
     */
    @Id
    @Column(name = "telnetId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long telnetId;
    /**
     * 主机主键
     */
    @Column(name = "hostId")
    private Long hostId;
    /**
     * 连接名称
     */
    @Column(name = "telnetName")
    private String telnetName;
    /**
     * 连接端口号
     */
    @Column(name = "telnetPort")
    private Integer telnetPort;
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

    public Long getTelnetId() {
        return telnetId;
    }

    public void setTelnetId(Long telnetId) {
        this.telnetId = telnetId;
    }

    public Long getHostId() {
        return hostId;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

    public String getTelnetName() {
        return telnetName;
    }

    public void setTelnetName(String telnetName) {
        this.telnetName = telnetName;
    }

    public Integer getTelnetPort() {
        return telnetPort;
    }

    public void setTelnetPort(Integer telnetPort) {
        this.telnetPort = telnetPort;
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
