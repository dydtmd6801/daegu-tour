package change.user.info;

import login.AuthInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import regist.RegistDto;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/userInfo")
public class ChangeUserInfoController {

    private ChangeUserInfoService changeUserInfoService;

    public ChangeUserInfoController(ChangeUserInfoService changeUserInfoService) {
        this.changeUserInfoService = changeUserInfoService;
    }

    @GetMapping
    public String userInfo(ChangeUserInfoDto changeUserInfoDto, HttpSession session, Model model) {
        try {
            AuthInfo authInfo = (AuthInfo) session.getAttribute("AuthInfo");
            authInfo.getUserId();
            return "/user/info";
        } catch (NullPointerException npe) {
            model.addAttribute("checkSession", "N");
            return "redirect:/index";
        }
    }

    @PostMapping
    public String userInfo(ChangeUserInfoDto changeUserInfoDto, Model model, HttpSession session) {
        try {
            AuthInfo authInfo = (AuthInfo) session.getAttribute("AuthInfo");
            RegistDto userInfo = changeUserInfoService.authByPassword(authInfo.getUserId(), changeUserInfoDto.getPassword());
            model.addAttribute("userInfo", userInfo);
            return "/user/info";
        } catch (NullPointerException npe) {
            return "/user/info";
        }
    }
}
