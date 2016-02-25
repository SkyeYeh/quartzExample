package com.skyeyeh.quartzExample.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * Created by TV6015 on 2016/2/24.
 * 我的 Job。
 */
public class MyJob implements Job {
    /**
     * 執行排程。
     *
     * @param jobExecutionContext Job 主體
     * @throws JobExecutionException Job 錯誤
     */
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Hello World! - " + new Date());
    }
}
