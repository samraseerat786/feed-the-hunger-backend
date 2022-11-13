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
        ServiceEmail serviceEmail = new ServiceEmail();
        System.out.println(serviceEmail.sendEmail("samraseerat786@gmail.com"));
    }

}
