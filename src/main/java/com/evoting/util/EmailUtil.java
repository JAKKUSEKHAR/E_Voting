package com.evoting.util;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

public class EmailUtil {

    public static void sendEmail(String toEmail, String subject, String messageText) {

        final String fromEmail = "jakkusekhar@gmail.com";       // your Gmail
        final String password = "ywnvaxtjmmpbvafe";     // 16-digit app password

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(fromEmail));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            msg.setSubject(subject);
            msg.setText(messageText);

            Transport.send(msg);

            System.out.println("Email Sent Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void sendEmailWithAttachment(String toEmail, String subject, String messageText, String filePath) {

        final String fromEmail = "jakkusekhar@gmail.com";
        final String password = "ywnvaxtjmmpbvafe";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(fromEmail));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            msg.setSubject(subject);

            // body text
            MimeBodyPart body = new MimeBodyPart();
            body.setText(messageText);

            // attachment
            MimeBodyPart attachment = new MimeBodyPart();
            attachment.attachFile(filePath);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(body);
            multipart.addBodyPart(attachment);

            msg.setContent(multipart);

            Transport.send(msg);

            System.out.println("Email with card sent successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
