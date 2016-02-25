package com.skyeyeh.quartzExample;

import com.skyeyeh.quartzExample.jobs.MyJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;

import java.text.ParseException;

/**
 * Created by TV6015 on 2016/2/24.
 * 開始工作。
 */
public class Work {
    private Scheduler scheduler;
    private JobDetail job;
    private CronTriggerImpl trigger;

    /**
     * 開始工作。
     */
    public void doWork() throws SchedulerException {
        // 建立 Scheduler。
        initScheduler();

        // JobDetail 加入 job。
        job = JobBuilder.newJob(MyJob.class).build();

        // 建立 Cron Trigger。
        trigger = getCronTrigger("myTrigger", "0/10 * * * * ?");

        // 告訴排程哪些 Job 使用哪些 Trigger。
        scheduler.scheduleJob(job, trigger);
        // 起動排程。
        scheduler.start();
    }

    /**
     * 建立 Scheduler。
     *
     * @throws SchedulerException 建立 Scheduler 例外
     */
    private void initScheduler() throws SchedulerException {
        SchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        scheduler = stdSchedulerFactory.getScheduler();
    }

    /**
     * 建立 Cron Trigger。
     *
     * @param name           Trigger 名稱
     * @param cronExpression Cron 表示式
     * @return Cron Trigger 物件
     */
    private CronTriggerImpl getCronTrigger(String name, String cronExpression) {
        CronTriggerImpl trigger = new CronTriggerImpl();
        trigger.setName(name);
        try {
            // 設定執行時間。
            trigger.setCronExpression(cronExpression);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return trigger;
    }

    public Scheduler getScheduler() {
        return scheduler;
    }

    public JobDetail getJob() {
        return job;
    }

    public CronTriggerImpl getTrigger() {
        return trigger;
    }
}
