package com.liuchang.heartbeat.entity.common;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 13:33 2019/7/4
 * @ Description：
 * @ Modified By：
 */
public class HostEntity {
    private Long HostId;
    //主机IP
    private String hostIp;
    //主机名字
    private String name;


    public HostEntity() {
        this.hostIp = "127.0.0.1";
        this.name = "host";
    }

    public HostEntity(String hostIp) {
        this.hostIp = hostIp;
        this.name = hostIp;
    }
    public HostEntity(String hostIp, String name) {
        this.hostIp = hostIp;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public Long getHostId() {
        return HostId;
    }

    public void setHostId(Long hostId) {
        HostId = hostId;
    }
}
