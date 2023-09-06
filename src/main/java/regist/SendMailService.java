package regist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Random;

@Component
public class SendMailService {

    @Autowired
    private JavaMailSenderImpl mailSender;
    private int authNumber;

    @Value("${email.account}")
    private String emailAccount;

    public void setRandomNumber() {
        Random random = new Random();
        int checkNum = random.nextInt(888888) + 111111;
        System.out.println("인증번호 : " + checkNum);
        authNumber = checkNum;
    }

    public String sendEmail(String email) {
        setRandomNumber();
        String setForm = emailAccount;
        String toMail = email;
        String title = "회원가입을 위한 인증메일 입니다."; // 이메일 제목
        String content = "홈페이지를 방문해주셔서 감사합니다." +
                "<br><br>" + "인증번호는 " + authNumber + "입니다." +
                "<br>" + "해당 인증번호를 인증번호 확인란에 입력해주세요."; //이메일 내용 삽임 (html 형식으로)
        mailSend(setForm, toMail, title, content);
        return Integer.toString(authNumber);
    }

    public void mailSend(String setForm, String toMail, String title, String content) {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(setForm);
            helper.setTo(toMail);
            helper.setSubject(title);
            helper.setText(content, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
