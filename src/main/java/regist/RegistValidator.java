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
        ValidationUtils.rejectIfEmpty(errors, "userId","required");
        ValidationUtils.rejectIfEmpty(errors, "password","required");
        ValidationUtils.rejectIfEmpty(errors, "confirmPassword","required");
        ValidationUtils.rejectIfEmpty(errors, "name","required");
        ValidationUtils.rejectIfEmpty(errors, "phoneNumber","required");
    }
}
