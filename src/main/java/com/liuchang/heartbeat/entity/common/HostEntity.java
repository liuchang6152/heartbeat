package com.liuchang.heartbeat.entity.common;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 13:33 2019/7/4
 * @ Description：
 * @ Modified By：
 */
public class HostEntity {
    //主机IP
    private String hostIp;


    public HostEntity() {
        this.hostIp = "127.0.0.1";

    }

    public HostEntity(String hostIp) {
        this.hostIp = hostIp;

    }

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

}
