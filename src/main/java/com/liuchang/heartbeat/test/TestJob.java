package com.liuchang.heartbeat.test;

import com.liuchang.heartbeat.common.timerUtil.DefaultSchedulingConfigurer;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.TriggerTask;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Calendar;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 16:35 2019/9/24
 * @ Description：
 * @ Modified By：
 */
//@Component
public class TestJob implements InitializingBean {
    @Autowired
    private DefaultSchedulingConfigurer defaultSchedulingConfigurer;
    @Override
    public void afterPropertiesSet() throws Exception {
        new Thread() {
            public void run()
            {

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
                }, new CronTrigger("0/5 * * * * ? ")));
            };
        }.start();
        new Thread() {
            public void run()
            {

                try
                {
                    Thread.sleep(30000);
                }
                catch (Exception e)
                {
                }
                System.out.println("重置任务............");
                defaultSchedulingConfigurer.resetTriggerTask("task", new TriggerTask(new Runnable() {

                    @Override
                    public void run()
                    {
                        System.out.println("run job..." + Calendar.getInstance().get(Calendar.SECOND));

                    }
                }, new CronTrigger("0/10 * * * * ? ")));
            };
        }.start();
    }
}
