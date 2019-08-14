package com.liuchang.heartbeat.pojo.bc;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 14:08 2019/8/12
 * @ Description：用户表
 * @ Modified By：
 */
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getUserRole() {
        return userRole;
    }

    public void setUserRole(Long userRole) {
        this.userRole = userRole;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getEditTime() {
        return editTime;
    }

    public void setEditTime(Timestamp editTime) {
        this.editTime = editTime;
    }
}
