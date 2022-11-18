package com.ttn.EcommerceProject.EcommerceProject.ServiceImpl;

import com.ttn.EcommerceProject.EcommerceProject.Service.EmailSenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

    private static Logger logger = LoggerFactory.getLogger(EmailSenderServiceImpl.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    @Async
    //mime message create an empty object to create a mime style message
    //mimeMessageHelper class support HTML,images,link attachments with mail
    //javaMail sender class used to send message
    public void send(String to, String emailTemplate) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(emailTemplate, true);
            helper.setTo(to);
            helper.setSubject("Confirm your E-mail");
            helper.setFrom("lalitkalpasi44@gmail.com");
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            logger.error("Failed to send email!", e);
            throw new IllegalStateException("Failed to send email!");
        }
    }
}