package com.jobfair.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobfair.beans.User;
import com.jobfair.dao.UserDao;

@Service
public class EmailService {
	
	@Autowired
	private UserDao userDao;
	

	public void sendMailToEmployer(long userid) {
		
		User user = userDao.findOne(userid);
		
		String msg = buildMessage(user);
		
		boolean status = sendMail(msg, "admin@jobfair.com", user.getEmail());
		
		System.out.println("Mail Status:"+status);
        
       
	}
	
	public static boolean sendMail(String msg, String userid, String to) {
		
		Properties props = new Properties();
		
		props.put("mail.host", "smtp.gmail.com");
		props.put("mail.transport.protocol.", "smtp");
		props.put("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.port", "587");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
    
        Session session = Session.getDefaultInstance(props,
        new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
        	return new PasswordAuthentication("huskiesneu@gmail.com","NEUhuskies11");
       
        }
        });

       try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(userid));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
            message.setSubject("JobFair Admin Message");
            message.setText(msg);
            Transport.send(message);
            return true;
        } 
        
        catch (MessagingException e) {
            e.printStackTrace();
             return false;
        }
       
    }

	private String buildMessage(User user) {
		
		final String status = user.getStatus();
		
		StringBuilder content = new StringBuilder();
		content.append("Dear ");
		content.append(user.getUsername());
		content.append(", Your profile status has been changed to ");
		content.append(status);
		
		if("ACTIVE".equalsIgnoreCase(status)) {
			
			content.append("\n");
			content.append("You can start using the JOBFAIR & avail the services offered by this portal.");
		
		} else if("INACTIVE".equalsIgnoreCase(status)) {
			
			content.append("\n");
			content.append("You cannot use services provided by JOBFAIR till you become an active employer.");
		}
	     
        return content.toString();
	}
}
