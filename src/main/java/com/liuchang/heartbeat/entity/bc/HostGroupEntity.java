package com.liuchang.heartbeat.entity.bc;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 14:42 2019/9/24
 * @ Description：
 * @ Modified By：
 */
public class HostGroupEntity {
    private Long hostGroupId;
    private Long telnetId;
    private Long groupId;
    private Integer timeCron;
    private Integer isClosed;
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
