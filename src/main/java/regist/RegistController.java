package regist;

import exception.DuplicateMemberException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/regist")
public class RegistController {

    private RegistService registService;

    public void setRegistService(RegistService registService) {
        this.registService = registService;
    }

    @GetMapping
    public String showRegist() {
        return "redirect:/regist/step1";
    }

    @GetMapping("/step1")
    public String step1() {
        return "regist/step1";
    }

    @GetMapping("/step2")
    public String step2(RegistDto registDto) {
        return "redirect:/regist/step1";
    }

    @PostMapping("/step2")
    public String step2(@RequestParam (value="agree", defaultValue = "false") Boolean agree, RegistDto registDto) {
        if(!agree) {
            return "redirect:/regist/step1";
        }
        return "/regist/step2";
    }

    @GetMapping("/step3")
    public String step3() {
        return "redirect:/regist/step1";
    }

    @PostMapping("/step3")
    public String step3(RegistDto registDto, Model model, Errors errors, HttpSession session) {
        new RegistValidator().validate(registDto, errors);
        if(errors.hasErrors()) {
            return "/regist/step2";
        }
        try {
            Map<String, String> map = (Map<String, String>) session.getAttribute("duplicate");
            for(Map.Entry<String, String> state : map.entrySet()) {
                if(!state.getKey().equals("no")) {
                    errors.rejectValue("userId", "duplicateUserId");
                    session.removeAttribute("duplicate");
                    return "/regist/step2";
                }
                if(!state.getValue().equals(registDto.getUserId())) {
                    errors.rejectValue("userId", "checkDuplication");
                    return "/regist/step2";
                }
            }
        } catch (NullPointerException e) {
            errors.rejectValue("userId", "checkDuplication");
            return "/regist/step2";
        }
        if(!registDto.getPassword().equals(registDto.getConfirmPassword())){
            errors.rejectValue("confirmPassword", "notMatchPassword");
            return "/regist/step2";
        }
        registService.join(registDto);
        model.addAttribute("registDto", registDto);
        return "/regist/step3";
    }

    @ResponseBody
    @PostMapping("/checkId")
    public String checkId(HttpServletRequest request, HttpSession session) {
        String id = request.getParameter("id");
        HashMap<String, String> map = new HashMap<>();
        if(id.isEmpty() || id.isBlank() || id.indexOf(' ') >= 0) {
            map.put("other",id);
            session.setAttribute("duplicate", map);
            return "other";
        }
        try {
            registService.checkDuplication(id);
            map.put("no",id);
            session.setAttribute("duplicate",map);
            return "success";
        } catch (DuplicateMemberException e) {
            map.put("yes",id);
            session.setAttribute("duplicate",map);
            return "fail";
        }
    }
}
