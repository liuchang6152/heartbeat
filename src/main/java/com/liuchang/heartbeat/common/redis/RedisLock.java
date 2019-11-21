package com.liuchang.heartbeat.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
@Component
public class RedisLock implements Lock {
    @Autowired
    private  RedisTemplate redisTemplate ;

    private String key = "123";

    private static final Long SUCCESS = 1L;

    public RedisLock(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void lock() {
        Long waitMax = TimeUnit.MILLISECONDS.toMillis(300);
        Long waitAlready = 0L;
        while (redisTemplate.opsForValue().setIfAbsent(key, Thread.currentThread().getId()) != true && waitAlready < waitMax) {
            try {
                Thread.sleep(300);
                waitAlready += 300;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        redisTemplate.opsForValue().set(key, Thread.currentThread().getId(), 300, TimeUnit.SECONDS);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        Boolean locked = redisTemplate.opsForValue().setIfAbsent(key, Thread.currentThread().getId());
        if (locked) {
            redisTemplate.expire(key, 300, TimeUnit.SECONDS);
        }
        return locked;

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
//        if(redisTemplate.opsForValue().get(key)!=null){
//            if(redisTemplate.opsForValue().get(key).equals(Thread.currentThread().getId())){
//                redisTemplate.delete(key);
//            }
//        }
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        //使用Lua脚本：先判断是否是自己设置的锁，再执行删除
        RedisScript<String> redisScript = new DefaultRedisScript<>(script, String.class);
        redisTemplate.execute(redisScript, Collections.singletonList(key), Thread.currentThread().getId());

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
