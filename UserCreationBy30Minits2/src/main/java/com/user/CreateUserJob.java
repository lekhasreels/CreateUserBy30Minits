package com.user;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class CreateUserJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// Call the user creation logic here
        UserManager userManager = new UserManager();
        userManager.createUser("Sree", "sreelekhals587@gmail.com");
	}

}
