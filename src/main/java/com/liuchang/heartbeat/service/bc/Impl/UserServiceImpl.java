package com.liuchang.heartbeat.service.bc.Impl;

import com.liuchang.heartbeat.common.redis.RedisLock;
import com.liuchang.heartbeat.common.result.CommonResult;
import com.liuchang.heartbeat.entity.bc.UserEntity;
import com.liuchang.heartbeat.service.bc.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 14:22 2019/8/12
 * @ Description：用户逻辑层实现类
 * @ Modified By：
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private  RedisTemplate redisTemplate ;
    @Override
    public CommonResult addUser(UserEntity userEntity) {
        return null;
    }

    @Override
    public CommonResult updateUser(UserEntity userEntity) {
        return null;
    }

    @Override
    public CommonResult delUser(UserEntity userEntity) {
        return null;
    }

    @Override
    public UserEntity getUserById(Long userId) {
        return null;
    }

    @Override
    public List<UserEntity> getUserPage(UserEntity userEntity) {
        return null;
    }
    private static int a;
    @Autowired
    private  RedisLock redisLock;

    public int add(){
        redisLock.tryLock();
        a=a+1;
        redisLock.unlock();
        return a;

    }

    public void test(){
        for(int i=0;i<100000;i++){
            new Thread(()->{
                add();
                System.out.println(a);
            }).start();
        }
    }

}
