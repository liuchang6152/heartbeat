package com.liuchang.heartbeat.pojo.bc;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 14:08 2019/8/12
 * @ Description：用户表
 * @ Modified By：
 */
@Data
@Entity
@DynamicUpdate
@Table(name = "T_BC_USER")
public class UserPojo {
    /**
     *  用户ID
     */
    @Id
    @Column(name = "USERID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    /**
     * 用户账号
     */
    @Column(name = "userAccount")
    private String userAccount;

    /**
     * 用户密码
     */
    @Column(name = "userPassword")
    private String userPassword;
    /**
     * 用户邮箱
     */
    @Column(name = "userEmail")
    private String userEmail;

    /**
     * 用户角色
     */
    @Column(name = "userRole")
    private Long userRole;
    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private Timestamp createTime;

    /**
     * 修改时间
     */
    @Column(name = "editTime")
    private Timestamp editTime;


}
