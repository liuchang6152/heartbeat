package com.liuchang.heartbeat.common.telnetutil;

import com.liuchang.heartbeat.entity.common.HostEntity;
import com.liuchang.heartbeat.entity.common.TelnetEntity;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 13:26 2019/7/4
 * @ Description：
 * @ Modified By：
 */
public class TelnetUtil {
    public static Boolean telnet(TelnetEntity telnetEntity){
        Boolean result = false;
        try {
            Socket s = new Socket();
            SocketAddress add = new InetSocketAddress(telnetEntity.getHostEntity().getHostIp(),telnetEntity.getPort());
            s.connect(add,5000);
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
            result = false;
        } finally {
            return result;
        }
    }

//    public static void main(String[] args) {
//        HostEntity hostEntity = new HostEntity();
//        hostEntity.setHostIp("10.163.224.117");
//        TelnetEntity telnetEntity = new TelnetEntity("8093",hostEntity);
//        System.out.println(telnet(telnetEntity));
//    }

}
