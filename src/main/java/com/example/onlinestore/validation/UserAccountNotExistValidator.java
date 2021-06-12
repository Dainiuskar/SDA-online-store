package com.example.onlinestore.validation;

import com.example.onlinestore.model.dto.UserAccountDTO;
import com.example.onlinestore.repo.UserAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserAccountNotExistValidator
        implements ConstraintValidator<UserAccountNotExist, Object> {

    @Autowired
    UserAccountRepo userAccountRepo;

    @Override
    public void initialize(UserAccountNotExist constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {
        UserAccountDTO userAccountDTO = (UserAccountDTO) obj;
        return !userAccountRepo.existsByLoginIgnoreCase(userAccountDTO.getLogin());
    }
}
