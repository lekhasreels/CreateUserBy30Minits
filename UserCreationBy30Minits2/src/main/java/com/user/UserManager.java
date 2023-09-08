package com.user;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class UserManager {
	private List<User> users = new ArrayList<>();

    public void createUser(String name, String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setCreationTime(new Date());
        
        // Save user to the database or data storage mechanism
        users.add(user);
    }
    public List<User> getUsersCreatedWithinLast12Hours() {
        List<User> recentUsers = new ArrayList<>();
        
        // Calculate the timestamp 12 hours ago from the current time
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR_OF_DAY, -12);
        Date twelveHoursAgo = calendar.getTime();
        
        // Iterate through users and filter by creation time
        for (User user : users) {
            if (user.getCreationTime().after(twelveHoursAgo)) {
                recentUsers.add(user);
            }
        }
        
        return recentUsers;
    }
    

}
