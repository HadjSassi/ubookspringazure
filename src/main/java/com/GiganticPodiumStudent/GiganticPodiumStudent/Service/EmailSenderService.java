package com.GiganticPodiumStudent.GiganticPodiumStudent.Service;


import com.GiganticPodiumStudent.GiganticPodiumStudent.model.ConfirmationToken;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.Document;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.User;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    @Async
    public void activationAccount(User user, ConfirmationToken confirmationToken) {
        try {
            MimeMessage message = this.mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(
                    message,MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
            Map<String,Object> model =new HashMap<>();
            model.put("nomUser",user.getNomUser());
            model.put("link", "http://localhost:8081/user/confirmation?token="+confirmationToken.getConfirmationToken());
            Configuration configurer = new Configuration(Configuration.VERSION_2_3_28);
            configurer.setClassForTemplateLoading(this.getClass(),"/");
            Template template = configurer.getTemplate("templates/ActivationCompte.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            mimeMessageHelper.setFrom("hadjsassiscompany@gmail.com");
            mimeMessageHelper.setTo(user.getMailUser());
            mimeMessageHelper.setText(html,true);
            mimeMessageHelper.setSubject("UBooK Account Confirmation");
            mailSender.send(message);
        }catch (Exception e1) {
            System.out.println(e1);
        }
    }

    public void sendMail(String toEmail, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(
                    mimeMessage,MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
            Map<String,Object> model =new HashMap<>();
            model.put("mailUser","mahdi，hello world template email ");
            Configuration configurer = new Configuration(Configuration.VERSION_2_3_28);
            configurer.setClassForTemplateLoading(this.getClass(),"/");
            Template template = configurer.getTemplate("templates/EmailTemplate.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

        message.setFrom("hadjsassiscompany@gmail.com");
        message.setTo(toEmail);
        message.setText(html);
        message.setSubject(subject);

        mailSender.send(message);
        System.out.println("Mail sent successfully !");
        } catch (IOException | TemplateException | MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendEmail(String toEmail, String subject, String body) {
        try {
            MimeMessage message = this.mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(
                    message,MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
            Map<String,Object> model =new HashMap<>();
            model.put("mailUser","mahdi，hello world template email ");
            Configuration configurer = new Configuration(Configuration.VERSION_2_3_28);
            configurer.setClassForTemplateLoading(this.getClass(),"/");
            Template template = configurer.getTemplate("templates/EmailTemplate.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            mimeMessageHelper.setFrom("hadjsassiscompany@gmail.com");
            mimeMessageHelper.setTo(toEmail);
            mimeMessageHelper.setText(html,true);
            mimeMessageHelper.setSubject(subject);
            mailSender.send(message);
        }catch (Exception e1) {
            System.out.println(e1);
        }
    }

    @Async
    public void sendEmail(SimpleMailMessage email) {
        mailSender.send(email);
    }


    @Async
    public void DocumentVeracityTrue(User user, Document document) {
        try {
            MimeMessage message = this.mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(
                    message,MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
            Map<String,Object> model =new HashMap<>();
            model.put("nomDoc",document.getNomDocument());
            model.put("nomUser",user.getNomUser());
            model.put("link", "http://localhost:4200/#/documents/view/"+document.getIdDocument());
            Configuration configurer = new Configuration(Configuration.VERSION_2_3_28);
            configurer.setClassForTemplateLoading(this.getClass(),"/");
            Template template = configurer.getTemplate("templates/DocumentVeracityTrue.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            mimeMessageHelper.setFrom("hadjsassiscompany@gmail.com");
            mimeMessageHelper.setTo(user.getMailUser());
            mimeMessageHelper.setText(html,true);
            mimeMessageHelper.setSubject("UBooK Uploading New Document");
            mailSender.send(message);
        }catch (Exception e1) {
            System.out.println(e1);
        }
    }

    @Async
    public void DocumentVeracityFalse(User user, Document document, String subjecting, String authoring, String yearing) {
        try {
            MimeMessage message = this.mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(
                    message,MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
            Map<String,Object> model =new HashMap<>();
            model.put("nomDoc",document.getNomDocument());
            model.put("nomUser",user.getNomUser());
            model.put("auhtor",authoring);
            model.put("subject",subjecting);
            model.put("year",yearing);
            model.put("link", "http://localhost:4200/#/documents/view/"+document.getIdDocument());
            Configuration configurer = new Configuration(Configuration.VERSION_2_3_28);
            configurer.setClassForTemplateLoading(this.getClass(),"/");
            Template template = configurer.getTemplate("templates/DocumentVeracityFalse.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            mimeMessageHelper.setFrom("hadjsassiscompany@gmail.com");
            mimeMessageHelper.setTo(user.getMailUser());
            mimeMessageHelper.setText(html,true);
            mimeMessageHelper.setSubject("UBooK Uploading New Document");
            mailSender.send(message);
        }catch (Exception e1) {
            System.out.println(e1);
        }


    }


    @Async
    public void ForgetPassword(User user, ConfirmationToken confirmationToken) {
        try {
            MimeMessage message = this.mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(
                    message,MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
            Map<String,Object> model =new HashMap<>();
            model.put("nomUser",user.getNomUser());
            model.put("link", "http://localhost:8081/user/forgetpwd?token="+confirmationToken.getConfirmationToken());
            Configuration configurer = new Configuration(Configuration.VERSION_2_3_28);
            configurer.setClassForTemplateLoading(this.getClass(),"/");
            Template template = configurer.getTemplate("templates/ForgetPwd.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            mimeMessageHelper.setFrom("hadjsassiscompany@gmail.com");
            mimeMessageHelper.setTo(user.getMailUser());
            mimeMessageHelper.setText(html,true);
            mimeMessageHelper.setSubject("UBooK Forget Password");
            mailSender.send(message);
        }catch (Exception e1) {
            System.out.println(e1);
        }


    }
}
