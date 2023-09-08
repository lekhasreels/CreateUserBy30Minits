package com.user;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SendEmailJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// Retrieve users created in the last 12 hours and send the email
        UserManager userManager = new UserManager();
        List<User> users = userManager.getUsersCreatedWithinLast12Hours();

        EmailService emailService = new EmailService();
        emailService.sendEmail(users);
	}

}
