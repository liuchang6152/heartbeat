package com.liuchang.heartbeat.common.mq;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 11:09 2019/11/21
 * @ Description：
 * @ Modified By：
 */
public class ProduceClient {
    public static void main(String[] args) throws Exception {
        MqClient.produce("Hello World");
    }
}
