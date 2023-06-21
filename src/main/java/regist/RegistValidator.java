package regist;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class RegistValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return RegistDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId","required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password","required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword","required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name","required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber","required");
    }
}
