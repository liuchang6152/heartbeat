package com.liuchang.heartbeat.common.mq;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 11:12 2019/11/21
 * @ Description：
 * @ Modified By：
 */
public class ConsumeClient {
    public static void main(String[] args) throws Exception {
        String message = MqClient.consume();
        System.out.println("获取的消息为："+message);
    }
}
