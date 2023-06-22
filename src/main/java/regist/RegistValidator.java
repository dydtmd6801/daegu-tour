package regist;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistValidator implements Validator {

    private static final String userIdRegExp = "^[a-zA-Z0-9]*$";
    private static final String passwordRegExp = "^(?=.*?[A-Za-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$";
    private static final String phoneNumberRegExp = "^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$";
    private Pattern userIdPattern;
    private Pattern passwordPattern;
    private Pattern phoneNumberPattern;

    public RegistValidator() {
        userIdPattern = Pattern.compile(userIdRegExp);
        passwordPattern = Pattern.compile(passwordRegExp);
        phoneNumberPattern = Pattern.compile(phoneNumberRegExp);
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return RegistDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Matcher matcher;
        RegistDto registDto = (RegistDto) target;
        if(registDto.getUserId() == null || registDto.getUserId().trim().isEmpty()) {
            errors.rejectValue("userId","required");
        } else {
            matcher = userIdPattern.matcher(registDto.getUserId());
            if(!matcher.matches()) {
                errors.rejectValue("userId","bad");
            }
        }
        if(registDto.getPassword() == null || registDto.getPassword().trim().isEmpty()) {
            errors.rejectValue("password","required");
        } else {
            matcher = passwordPattern.matcher(registDto.getPassword());
            if(!matcher.matches()) {
                errors.rejectValue("password","bad");
            }
        }
        if(registDto.getPhoneNumber() == null || registDto.getPhoneNumber().trim().isEmpty()) {
            errors.rejectValue("phoneNumber","required");
        } else {
            matcher = phoneNumberPattern.matcher(registDto.getPhoneNumber());
            if(!matcher.matches()) {
                errors.rejectValue("phoneNumber","bad");
            }
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword","required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name","required");
    }
}
