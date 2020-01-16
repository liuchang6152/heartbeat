package com.liuchang.heartbeat.sjjg.tree.expection;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 13:44 2020/1/14
 * @ Description：
 * @ Modified By：
 */
public class NodeNotContainExpection extends Exception{
    private String message;
    public NodeNotContainExpection(String message) {
        super(message);
        this.message = message;
    }
}
