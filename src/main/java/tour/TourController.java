package tour;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tour")
public class TourController {

    @GetMapping
    public String showDefault() {
        return "redirect:/tour/list";
    }

    @GetMapping("/list")
    public String list() {
        return "/tour/list";
    }
}
