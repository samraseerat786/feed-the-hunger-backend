package com.EmailSender.newEmailSender;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail
{

    public static void main(String[] args)
    {
//        //authentication info
////        final String username = "yourUsername@email.com";
////        final String password = "password";
//
//        final String username = "charity.application501@gmail.com";
//        final String password = "samra2753";
//        String fromEmail = "charity.application501@gmail.com";
//        String toEmail = "samraseerat786@gmail.com";
//
//        Properties properties = new Properties();
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
//        properties.put("mail.smtp.host", "smtp.gmail.com");
//        properties.put("mail.smtp.port", "587");
//
//        Session session = Session.getInstance(properties, new javax.mail.Authenticator()
//        {
//            protected PasswordAuthentication getPasswordAuthentication()
//            {
//                return new PasswordAuthentication(username, password);
//            }
//        });
//        //Start our mail message
//        MimeMessage msg = new MimeMessage(session);
//        try
//        {
//            msg.setFrom(new InternetAddress(fromEmail));
//            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
//            msg.setSubject("Subject Line");
//
//            Multipart emailContent = new MimeMultipart();
//
//            //Text body part
//            MimeBodyPart textBodyPart = new MimeBodyPart();
//            textBodyPart.setText("My multipart text");
//
//            //Attachment body part.
////            MimeBodyPart pdfAttachment = new MimeBodyPart();
////            pdfAttachment.attachFile("/home/parallels/Documents/docs/javamail.pdf");
//
//            //Attach body parts
//            emailContent.addBodyPart(textBodyPart);
////            emailContent.addBodyPart(pdfAttachment);
//
//            //Attach multipart to message
//            msg.setContent(emailContent);
//
//            Transport.send(msg);
//            System.out.println("Sent message");
//        } catch (MessagingException e)
//        {
//            e.printStackTrace();
//        }

        ServiceEmail serviceEmail = new ServiceEmail();
        System.out.println(serviceEmail.sendEmail("samraseerat786@gmail.com"));

    }

}