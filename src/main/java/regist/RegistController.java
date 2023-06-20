package regist;

import exception.DuplicateMemberException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/step3")
    public String step3(RegistDto registDto, Model model, Errors errors) {
        new RegistValidator().validate(registDto, errors);
        if(errors.hasErrors()) {
            return "/regist/step2";
        }
        try {
            if(!registDto.getPassword().equals(registDto.getConfirmPassword())){
                errors.rejectValue("confirmPassword", "notMatchPassword");
                return "/regist/step2";
            }
            registService.join(registDto);
            model.addAttribute("registDto", registDto);
            return "/regist/step3";
        } catch (DuplicateMemberException e) {
            errors.rejectValue("userId","duplicateUserId");
            return "/regist/step2";
        }
    }
}
