package com.liuchang.heartbeat.service.bc.Impl;

import com.liuchang.heartbeat.common.timerUtil.DefaultSchedulingConfigurer;
import com.liuchang.heartbeat.dao.bc.HostGroupDao;
import com.liuchang.heartbeat.entity.bc.HostGroupEntity;
import com.liuchang.heartbeat.pojo.bc.HostGroupPojo;
import com.liuchang.heartbeat.service.bc.HostGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.TriggerTask;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 15:04 2019/9/24
 * @ Description：
 * @ Modified By：
 */
@Transactional
@Service
public class HostGroupServiceImpl implements HostGroupService {
    @Autowired
    private DefaultSchedulingConfigurer defaultSchedulingConfigurer;
    @Autowired
    private HostGroupDao hostGroupDao;
    @Override
    public void addHostGroup(HostGroupEntity hostGroupEntity) {
        HostGroupPojo hostGroupPojo = new HostGroupPojo();
        hostGroupPojo.setGroupId(hostGroupEntity.getGroupId());
        hostGroupPojo.setTelnetId(hostGroupEntity.getTelnetId());
        hostGroupPojo.setTimeCron(hostGroupEntity.getTimeCron());
        hostGroupDao.save(hostGroupPojo);
        try
        {
            // 等待任务调度初始化完成
            while (!defaultSchedulingConfigurer.inited())
            {
                Thread.sleep(100);
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("任务调度初始化完成，添加任务");
        defaultSchedulingConfigurer.addTriggerTask("task", new TriggerTask(new Runnable() {

            @Override
            public void run()
            {
                System.out.println("run job..." + Calendar.getInstance().get(Calendar.SECOND));

            }
        }, new CronTrigger("0/"+hostGroupEntity.getTimeCron()+" * * * * ? ")));
    }

    @Override
    public void editHostGroup(HostGroupEntity hostGroupEntity) {

    }

    @Override
    public void deleteHostGroup(HostGroupEntity hostGroupEntity) {

    }

    @Override
    public HostGroupPojo findOne(HostGroupEntity hostGroupEntity) {
        return null;
    }
}
