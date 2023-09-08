package com.user;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {
	public void sendEmail(List<User> users) {
        // Configure email properties
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587"); // Your SMTP port
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Create a Session with authentication
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("sreelekhals587@gmail.com", "Sree27@532");
            }
        });

        try {
            // Create a MimeMessage object
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sreelekhals587@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("desinenisreelekha27@gmail.com"));
            message.setSubject("List of Users Created in the Last 12 Hours");

            // Build email content with the list of users
            StringBuilder content = new StringBuilder();
            for (User user : users) {
                content.append("Name: ").append(user.getName()).append("\n");
                content.append("Email: ").append(user.getEmail()).append("\n");
                content.append("Creation Time: ").append(user.getCreationTime()).append("\n\n");
            }
            message.setText(content.toString());

            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
