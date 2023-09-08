package com.user;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzSchedulerExample {

	public static void main(String[] args) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();

            // Create and configure the user creation job
            JobDetail createUserJob = JobBuilder.newJob(CreateUserJob.class)
                    .withIdentity("createUserJob", "group1")
                    .build();

            Trigger createUserTrigger = TriggerBuilder.newTrigger()
                    .withIdentity("createUserTrigger", "group1")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.repeatMinutelyForever(30))
                    .build();

            // Create and configure the email sending job
            JobDetail sendEmailJob = JobBuilder.newJob(SendEmailJob.class)
                    .withIdentity("sendEmailJob", "group2")
                    .build();
            Trigger sendEmailTrigger = TriggerBuilder.newTrigger()
                    .withIdentity("sendEmailTrigger", "group2")
                    .startNow()
                    .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(0, 0))
                    .build();

            // Schedule the jobs
            scheduler.scheduleJob(createUserJob, createUserTrigger);
            scheduler.scheduleJob(sendEmailJob, sendEmailTrigger);

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
