package login;

import exception.MemberNotFoundException;
import exception.NotMatchPasswordException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import regist.RegistDto;

@Controller
@RequestMapping("/login")
public class LoginController {

    private LoginService loginService;

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public String showLogin(LoginDto loginDto) {
        return "login/login";
    }

    @PostMapping
    public String login(LoginDto loginDto, Errors errors) {
        try {
            RegistDto memberInfo = loginService.Login(loginDto);
            //세션 생성
            return "../../index";
        } catch (MemberNotFoundException e) {
            errors.rejectValue("userId", "memberNotFound");
            return "login/login";
        } catch (NotMatchPasswordException e) {
            errors.rejectValue("userId","notMatchIdPassword");
            return "login/login";
        }
    }

}
