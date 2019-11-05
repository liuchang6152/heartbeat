package com.liuchang.heartbeat.service.bc;

import com.liuchang.heartbeat.common.result.CommonResult;
import com.liuchang.heartbeat.entity.bc.UserEntity;
import com.liuchang.heartbeat.pojo.bc.UserPojo;

import java.util.List;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 14:22 2019/8/12
 * @ Description：用户逻辑层接口
 * @ Modified By：
 */
public interface UserService {
    /**
     * 增加一个用户
     * @return
     */
    public CommonResult addUser(UserEntity userEntity);
    /**
     * 修改一个用户
     * @return
     */
    public CommonResult updateUser(UserEntity userEntity);

    /**
     * 删除用户
     * @param userEntity
     * @return
     */
    public CommonResult delUser(UserEntity userEntity);

    /**
     * 根据用户ID获取用户
     * @param userId
     * @return
     */
    public UserEntity getUserById(Long userId);

    /**
     * 根据用户信息分页获取用户
     * @param userEntity
     * @return
     */
    public List<UserEntity> getUserPage(UserEntity userEntity);

    public void test();

}
