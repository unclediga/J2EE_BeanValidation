package ru.unclediga.custom.validator;

import ru.unclediga.custom.Emp;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ChronoOrderEmpValidator implements ConstraintValidator<ChronoOrderEmp, Emp> {

    @Override
    public void initialize(ChronoOrderEmp chronoOrderEmp) {

    }

    @Override
    public boolean isValid(Emp emp, ConstraintValidatorContext constraintValidatorContext) {
        return emp.getFireDate() == null || emp.getHireDate().before(emp.getFireDate());
    }
}
