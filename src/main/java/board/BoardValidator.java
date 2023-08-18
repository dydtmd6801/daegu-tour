package board;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class BoardValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return BoardDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"title","required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"content", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password", "required");
    }
}
