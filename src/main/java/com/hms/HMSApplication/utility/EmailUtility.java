package com.hms.HMSApplication.utility;

import com.hms.HMSApplication.dto.enumlist.RoleEnum;
import com.hms.HMSApplication.exception.HMSException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.hms.HMSApplication.utility.Constants.*;

@Service
public class EmailUtility {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Value("${spring.mail.username}")
    private String fromMail;

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(String subject, String toEmail, String body, String ccMail) throws HMSException {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(fromMail);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setBcc(ccMail);
        simpleMailMessage.setText(body);
        javaMailSender.send(simpleMailMessage);
    }
    public void sendMail(String subject, String toEmail, String body) throws HMSException {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(fromMail);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setText(body);
        javaMailSender.send(simpleMailMessage);
    }

    public static String getMailBody(String userName,String password,String hostelName) {
        String message = "Hi " + userName.replace(".gmail.com", "") + "\n\n" +
                "Welcome to the " + hostelName + "\n\n" +
                "Your New user name is " + userName + "\n" +
                "Your new Password is " + password + "\n\n" +
                "Please login to " + APP_NAME + " with above user name and password\n\n" +
                "Regards\n" +
                APP_NAME;
        return message;
    }
    public static String getBedUserSubject(String userName){
       return "On boarding with " + APP_NAME + "by " + userName;
    }


}
