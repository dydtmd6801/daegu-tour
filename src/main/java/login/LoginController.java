package login;

import exception.MemberNotFoundException;
import exception.NotMatchPasswordException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import regist.RegistDto;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    private LoginService loginService;

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public String showLogin(LoginDto loginDto, HttpSession session) {
        if(session.getAttribute("AuthInfo") == null) {
            return "login/login";
        }
        return "../../index";
    }

    @PostMapping
    public String login(LoginDto loginDto, Errors errors, HttpSession session) {
        new LoginValidator().validate(loginDto, errors);
        if(errors.hasErrors()) {
            return "login/login";
        }
        try {
            RegistDto memberInfo = loginService.Login(loginDto);
            AuthInfo authInfo = new AuthInfo(memberInfo.getUserId(), memberInfo.getName(), memberInfo.getPhoneNumber());
            session.setAttribute("AuthInfo", authInfo);
            return "../../index";
        } catch (MemberNotFoundException e) {
            errors.rejectValue("userId", "memberNotFound");
            return "login/login";
        } catch (NotMatchPasswordException e) {
            errors.rejectValue("userPassword","notMatchIdPassword");
            return "login/login";
        }
    }

}
