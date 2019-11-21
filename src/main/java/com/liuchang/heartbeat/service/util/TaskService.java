package com.liuchang.heartbeat.service.util;

import com.liuchang.heartbeat.common.telnetutil.TelnetUtil;
import com.liuchang.heartbeat.entity.common.HostEntity;
import com.liuchang.heartbeat.entity.common.TelnetEntity;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 15:46 2019/9/19
 * @ Description：
 * @ Modified By：
 */
@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class TaskService {
    @Scheduled(fixedRate = 5*1000)
    public void getServer() {
        HostEntity hostEntity = new HostEntity();
        hostEntity.setHostIp("10.163.224.117");
       // TelnetEntity telnetEntity = new TelnetEntity("8093",hostEntity);
        //System.out.println(TelnetUtil.telnet(telnetEntity));

    }
}
