package com.liuchang.heartbeat.common.mq;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 10:22 2019/11/21
 * @ Description：
 * @ Modified By：
 */
public class Broker {
    //队列消息的最大数量
    private final static int MAX_SIZE=5;
    //保存消息数据的数据
    private static ArrayBlockingQueue<String> messageQueue = new ArrayBlockingQueue<>(MAX_SIZE);
    //生产消息
    public static void produce(String msg){
        if(messageQueue.offer(msg)){
            System.out.println("成功向消息处理中心投递消息："+msg+",当前暂存的消息数量是："+messageQueue.size());
        }
        else{
            System.out.println("当前的消息数量达到最大负荷，不能存储了");
        }
        System.out.println("==========================================");
    }
    public static String consume(){
        String msg = messageQueue.poll();
        if(msg!=null){
            //消费条件满足情况，从消息容器中取出一条消息
            System.out.println("已经消费消息:"+msg+",当前暂存的消息数量是，"+messageQueue.size());
        }
        else{
            System.out.println("消息处理中心没有消息可提供消费");
        }
        System.out.println("========================================");
        return msg;
    }
}
