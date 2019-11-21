package com.liuchang.heartbeat.pojo.bc;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 14:59 2019/9/24
 * @ Description：
 * @ Modified By：
 */
@Entity
@DynamicUpdate
@Table(name = "T_BC_HostGroup")
public class HostGroupPojo {
    /**
     * 主键
     */
    @Id
    @Column(name = "hostGroupId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hostGroupId;
    @Column(name = "telnetId")
    private Long telnetId;
    @Column(name = "groupId")
    private Long groupId;
    @Column(name = "timeCron")
    private Integer timeCron;
    @Column(name = "isClosed")
    private Integer isClosed;
    @Column(name = "isConnectSuccess")
    private Integer isConnectSuccess;

    public Long getHostGroupId() {
        return hostGroupId;
    }

    public void setHostGroupId(Long hostGroupId) {
        this.hostGroupId = hostGroupId;
    }

    public Long getTelnetId() {
        return telnetId;
    }

    public void setTelnetId(Long telnetId) {
        this.telnetId = telnetId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Integer getTimeCron() {
        return timeCron;
    }

    public void setTimeCron(Integer timeCron) {
        this.timeCron = timeCron;
    }

    public Integer getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Integer isClosed) {
        this.isClosed = isClosed;
    }

    public Integer getIsConnectSuccess() {
        return isConnectSuccess;
    }

    public void setIsConnectSuccess(Integer isConnectSuccess) {
        this.isConnectSuccess = isConnectSuccess;
    }
}
