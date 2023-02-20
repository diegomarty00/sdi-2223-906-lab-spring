package com.uniovi.notaneitor.validators;
import com.uniovi.notaneitor.entities.Professor;
import com.uniovi.notaneitor.entities.User;
import com.uniovi.notaneitor.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;

import java.util.regex.Pattern;

@Component
public class ProfessorValidator implements Validator {
    @Autowired
    private UsersService usersService;
    @Override
    public boolean supports(Class<?> aClass) {
        return Professor.class.equals(aClass);
    }
    @Override
    public void validate(Object target, Errors errors) {
        Professor professor = (Professor) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dni", "Error.empty");
        if (professor.getDni().length() != 9) {
            errors.rejectValue("dni", "Error.edit.dni.format");}
        if( professor.getDni().length() == 9 && !Pattern.matches("[a-zA-Z]", ""+professor.getDni().charAt(8))){
            errors.rejectValue("dni", "Error.edit.dni.format");}
        if (usersService.getUserByDni(professor.getDni()) != null) {
            errors.rejectValue("dni", "Error.edit.dni.duplicate");}
        if (professor.getName().length() < 5 || professor.getName().length() > 24) {
            errors.rejectValue("name", "Error.edit.name.length");}
        if (professor.getSurname().length() < 5 || professor.getSurname().length() > 24) {
            errors.rejectValue("surname", "Error.edit.surname.length");}
    }
}