package login;

import com.github.scribejava.core.model.OAuth2AccessToken;
import exception.MemberNotFoundException;
import exception.NotMatchPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import regist.RegistDto;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/login")
public class LoginController {

    private LoginService loginService;

    private NaverLoginBO naverLoginBO;
    private String apiResult = null;

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @Autowired
    private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
        this.naverLoginBO = naverLoginBO;
    }

    @GetMapping
    public String showLogin(LoginDto loginDto, HttpSession session, Model model) {
        if(session.getAttribute("AuthInfo") == null) {
            String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
            model.addAttribute("url", naverAuthUrl);
            return "login/login";
        }
        return "../../index";
    }

    @PostMapping
    public String login(LoginDto loginDto, Errors errors, HttpSession session, Model model) {
        String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
        model.addAttribute("url", naverAuthUrl);
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

    @RequestMapping(value="/callback", method = { RequestMethod.GET, RequestMethod.POST })
    public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session) throws IOException {
        OAuth2AccessToken oauthToken;

        oauthToken = naverLoginBO.getAccessToken(session, code, state);

        apiResult = naverLoginBO.getUserProfile(oauthToken);

        model.addAttribute("result", apiResult);

        return "redirect:/index";
    }
}
