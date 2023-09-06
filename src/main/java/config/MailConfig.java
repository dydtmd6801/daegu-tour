package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@PropertySource("classpath:emailConfig.properties")
public class MailConfig {

    @Value("${email.account}")
    private String emailAccount;

    @Value("${email.password}")
    private String emailPassword;

    @Bean
    public JavaMailSenderImpl javaMailSender() {
        Properties mailProperties = new Properties();
        mailProperties.put("mail.transport.protocol", "smtp");
        mailProperties.put("mail.smtp.auth", "true");
        mailProperties.put("mail.smtp.starttls.enable", "true");
        mailProperties.put("mail.debug", "true");
        mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mailProperties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        mailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setJavaMailProperties(mailProperties);
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername(emailAccount);
        mailSender.setPassword(emailPassword);
        mailSender.setDefaultEncoding("utf-8");
        System.out.println("account : " + emailAccount + "  , password : " + emailPassword );
        return mailSender;
    }
}
