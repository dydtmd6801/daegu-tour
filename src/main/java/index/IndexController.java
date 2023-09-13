package index;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/index")
public class IndexController {

    @GetMapping
    @PostMapping
    public String index(@RequestParam(required = false) String checkSession, Model model) {
        model.addAttribute("checkSession", checkSession);
        return "../../index";
    }
}
