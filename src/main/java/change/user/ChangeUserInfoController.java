package change.user;

import change.user.info.ChangeUserInfoDto;
import change.user.info.ChangeUserInfoService;
import change.user.password.ChangeUserPasswordDto;
import login.AuthInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import regist.RegistDto;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

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

    @GetMapping("/edit")
    public String userInfoEdit() {
        return "redirect:/index";
    }

    @PostMapping("/edit")
    public String userInfoEdit(@RequestParam String userId, Model model) {
        ChangeUserInfoDto changeUserInfoDto = new ChangeUserInfoDto();
        model.addAttribute("userInfo", changeUserInfoService.getUserInfo(userId));
        model.addAttribute("changeUserInfoDto", changeUserInfoDto);
        return "/user/edit";
    }

    @GetMapping("/update")
    public String update() {
        return "redirect:/index";
    }

    @PostMapping("/update")
    public void update(ChangeUserInfoDto changeUserInfoDto, HttpServletResponse response) throws IOException {
        changeUserInfoService.updateInfo(changeUserInfoDto);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('개인정보가 수정되었습니다.');");
        out.println("location.href='/userInfo';</script>");
        out.close();
    }

    @GetMapping("/changePwd")
    public String ChangePassword(ChangeUserPasswordDto changeUserPasswordDto, HttpSession session) {
        if (session.getAttribute("AuthInfo") == null) {
            return "redirect:/index";
        }
        return "/user/changePwd";
    }

    @PostMapping("/changePwd")
    public String changePwd(ChangeUserPasswordDto changeUserPasswordDto, HttpSession session) {
        AuthInfo authInfo = (AuthInfo) session.getAttribute("AuthInfo");
        try {
            RegistDto userInfo = changeUserInfoService.getUserInfo(authInfo.getUserId());
            if (!userInfo.getPassword().equals(changeUserPasswordDto.getCurrentPassword())) {
                return "/user/changePwd";
            }
            if (!changeUserPasswordDto.getNewPassword().equals(changeUserPasswordDto.getNewConfirmPassword())) {
                return "user/changePwd";
            }
            changeUserInfoService.updatePassword(changeUserPasswordDto.getNewPassword(), authInfo.getUserId());
            return "redirect:/userInfo";
        } catch (NullPointerException npe) {
            return "redirect:/index";
        }
    }
}
