package com.liuchang.heartbeat.entity.common;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 13:26 2019/7/4
 * @ Description：telnet类
 * @ Modified By：
 */
public class TelnetEntity {
    //端口号
    private String port;
    //主机信息
    private HostEntity hostEntity;

    public TelnetEntity(String port, HostEntity hostEntity) {
        this.port = port;
        this.hostEntity = hostEntity;
    }

    public TelnetEntity(HostEntity hostEntity) {
        this.port = "80";
        this.hostEntity = hostEntity;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public HostEntity getHostEntity() {
        return hostEntity;
    }

    public void setHostEntity(HostEntity hostEntity) {
        this.hostEntity = hostEntity;
    }
}
