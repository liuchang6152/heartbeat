package com.liuchang.heartbeat.controller.bc;

import com.liuchang.heartbeat.common.result.CommonResult;
import com.liuchang.heartbeat.entity.bc.HostGroupEntity;
import com.liuchang.heartbeat.entity.bc.MailEntity;
import com.liuchang.heartbeat.entity.common.TelnetEntity;
import com.liuchang.heartbeat.service.bc.HostGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 10:50 2019/9/23
 * @ Description：
 * @ Modified By：
 */
@CrossOrigin
@RestController
@RequestMapping(value = "api/telnet", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TelnetController {
    @Autowired
    private HostGroupService hostGroupService;
    @PostMapping
    public CommonResult addTelnet(@RequestBody HostGroupEntity hostGroupEntity) {
        CommonResult commonResult = new CommonResult();
        try {
            hostGroupService.addHostGroup(hostGroupEntity);
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
