package com.felixfan.learn.config;

import com.felixfan.learn.job.DataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author felix.fan
 * @Date 2019/2/9 22:04
 */
@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail dataSyncJobDetail() {
        return JobBuilder.newJob(DataSyncJob.class)
                .withIdentity("dataSyncJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger dataSyncTrigger() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("/5 * * * * ? ");
        return TriggerBuilder.newTrigger()
                .forJob(dataSyncJobDetail())
                .withIdentity("dataSyncTrigger")
                .withSchedule(cronScheduleBuilder)
                .build();
    }
}