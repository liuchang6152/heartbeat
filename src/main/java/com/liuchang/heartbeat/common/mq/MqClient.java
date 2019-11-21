package com.liuchang.heartbeat.common.mq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 10:55 2019/11/21
 * @ Description：
 * @ Modified By：
 */
public class MqClient {
    //生产消息
    public static void produce(String message) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(),BrokerServer.SERVICE_PORT);
        try(PrintWriter out = new PrintWriter(socket.getOutputStream())){
            out.println(message);
            out.flush();
        }
    }
    //消费消息
    public static String consume() throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(),BrokerServer.SERVICE_PORT);
        try(
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                ){
            out.println("CONSUME");
            out.flush();
            String message = in.readLine();
            return message;
        }
    }

}
