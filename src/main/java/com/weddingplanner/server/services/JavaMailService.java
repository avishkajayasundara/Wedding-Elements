package com.weddingplanner.server.services;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class JavaMailService {
    public static void sendMail(String recepient, String subject, String body) {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myAccount = "as.jayasundara23@gmail.com";
        String password = "adwJLIadw123!@#";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccount, password);

            }
        });

        Message message = prepareMessage(session, myAccount, recepient, subject, body);
        try {
            Transport.send(message);
            System.out.println("Mail Sent Successfully");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private static Message prepareMessage(Session session, String myAccount, String recepient, String subject, String body) {
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(myAccount));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject(subject);
            message.setText("Hello,\n" + body);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }
}
