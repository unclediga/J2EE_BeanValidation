package ru.unclediga.custom.validator;

import ru.unclediga.custom.Dept;
import ru.unclediga.custom.Emp;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.UnexpectedTypeException;

public class ChronoOrderValidator implements ConstraintValidator<ChronoOrder, Object> {
    @Override
    public void initialize(ChronoOrder chronoOrder) {

    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {
        if (obj.getClass().equals(Dept.class)) {
            Dept dept = (Dept) obj;
            return dept.getCloseDate() == null || dept.getOpenDate().before(dept.getCloseDate());
        } else if (obj.getClass().equals(Emp.class)) {
            Emp emp = (Emp) obj;
            return emp.getFireDate() == null || emp.getHireDate().before(emp.getFireDate());
        }
        throw new UnexpectedTypeException();
    }
}
