package com.liuchang.heartbeat.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
@Component
public class RedisLock implements Lock {
    @Autowired
    private  RedisTemplate redisTemplate ;


    private String key = "123";

    public RedisLock(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;

    }

    @Override
    public void lock() {
        redisTemplate.opsForValue().set(key,"123");
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        if(!redisTemplate.hasKey(key)){
           return true;
        }
        if(redisTemplate.hasKey(key)){
            return false;
        }
        else{
            return true;
        }

    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        Long startTime = System.currentTimeMillis();
        while((System.currentTimeMillis()<(startTime+unit.toMillis(time)))){
             if(this.tryLock()){
                 return true;
             }
        }
        return false;
    }

    @Override
    public void unlock() {
       redisTemplate.delete(key);
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
