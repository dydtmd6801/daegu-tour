package change.user;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangeUserInfoValidator implements Validator {

    private static final String phoneNumberRegExp = "^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$";
    private Pattern phoneNumberPattern;

    public ChangeUserInfoValidator() {
        phoneNumberPattern = Pattern.compile(phoneNumberRegExp);
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return ChangeUserInfoDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ChangeUserInfoDto changeUserInfoDto = (ChangeUserInfoDto) target;
        Matcher matcher = phoneNumberPattern.matcher(changeUserInfoDto.getPhoneNumber());
        if (!matcher.matches()) {
            errors.rejectValue("phoneNumber","bad");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"phoneNumber","required");
    }
}
