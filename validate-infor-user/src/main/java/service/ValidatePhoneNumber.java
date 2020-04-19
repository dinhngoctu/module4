package service;

import model.PhoneNumber;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ValidatePhoneNumber implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return PhoneNumber.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PhoneNumber phoneNumber = (PhoneNumber) target;
        String number = String.valueOf(phoneNumber.getNumber());
        ValidationUtils.rejectIfEmpty(errors, "number", "number.empty");
        if (number.length()>11 || number.length()<10){
            errors.rejectValue("number", "number.length","do dai so khong hop lệ");
        }
        if (!number.startsWith("0")){
            errors.rejectValue("number", "number.startsWith","bắt đầu bởi số không ");
        }
        if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("number", "number.matches","không hợp lệ");
        }
    }
    }