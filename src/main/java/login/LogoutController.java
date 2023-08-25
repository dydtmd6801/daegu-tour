package login;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LogoutController {

    @GetMapping("/logout")
    public void logout(HttpSession session) {
        session.removeAttribute("AuthInfo");

    }
}
