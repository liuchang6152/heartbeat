package com.liuchang.heartbeat.entity.common;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 13:26 2019/7/4
 * @ Description：telnet类
 * @ Modified By：
 */
public class TelnetEntity {
    //端口号
    private Integer port;
    //主机信息
    private Long hostId;
    //连接名字
    private String telnetName;
    private Long telenetId;
    private HostEntity hostEntity;


    public TelnetEntity(Integer port, String telnetName) {
        this.port = port;
        this.telnetName = telnetName;
    }

    public TelnetEntity(String telnetName) {
        this.port = 80;
        this.telnetName = telnetName;
    }

    public TelnetEntity(Integer port) {
        this.port = port;
        this.telnetName = "host";
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
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

    public Long getTelenetId() {
        return telenetId;
    }

    public void setTelenetId(Long telenetId) {
        this.telenetId = telenetId;
    }

    public HostEntity getHostEntity() {
        return hostEntity;
    }

    public void setHostEntity(HostEntity hostEntity) {
        this.hostEntity = hostEntity;
    }
}
