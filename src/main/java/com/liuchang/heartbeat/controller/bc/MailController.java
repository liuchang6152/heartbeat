package com.liuchang.heartbeat.controller.bc;

import com.liuchang.heartbeat.common.mail.MailSend;
import com.liuchang.heartbeat.common.result.CommonResult;
import com.liuchang.heartbeat.entity.bc.MailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 15:14 2019/8/12
 * @ Description：邮件发送接口
 * @ Modified By：
 */
@CrossOrigin
@RestController
@RequestMapping(value = "api/mail/mail", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MailController {
    @Autowired
    private MailSend mailSend;
    @PostMapping
    public CommonResult sendMail(@RequestBody MailEntity mailEntity) {
        CommonResult commonResult = new CommonResult();
        try {
            mailSend.sendMail(mailEntity.getTitle(),mailEntity.getUrl(),mailEntity.getEmail());
            commonResult.setIsSuccess(true);
        } catch (Exception e) {
            commonResult.setIsSuccess(false);
            commonResult.setMessage("send faulier");
            e.printStackTrace();
        } finally {
            return commonResult;
        }
    }
}
