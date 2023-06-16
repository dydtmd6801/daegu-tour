package regist;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/regist")
public class RegistController {

    @GetMapping
    public String showRegist() {
        return "redirect:/regist/step1";
    }

    @GetMapping("/step1")
    public String step1() {
        return "regist/step1";
    }

    @PostMapping("/step2")
    public String step2(@RequestParam (value="agree", defaultValue = "false") Boolean agree) {
        if(!agree) {
            return "redirect:/regist/step1";
        }
        return "/regist/step2";
    }
}
