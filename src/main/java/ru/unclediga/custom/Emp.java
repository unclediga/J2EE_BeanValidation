package ru.unclediga.custom;

import ru.unclediga.custom.validator.ChronoOrder;
import ru.unclediga.custom.validator.ChronoOrderEmp;

import java.util.Date;

@ChronoOrderEmp
@ChronoOrder
public class Emp {
    @EntityId(numberSize = 5)
    String emp_id;
    @NotEmptyAndBlank
    String name;
    Date hireDate;
    Date fireDate;
    String phone;

    public String getPhone() {
        return phone;
    }

    public Emp(String emp_id, String name, Date hireDate, Date fireDate, String phone) {
        this.emp_id = emp_id;
        this.name = name;
        this.hireDate = hireDate;
        this.fireDate = fireDate;
        this.phone = phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getFireDate() {
        return fireDate;
    }

    public void setFireDate(Date fireDate) {
        this.fireDate = fireDate;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "emp_id='" + emp_id + '\'' +
                ", name='" + name + '\'' +
                ", hireDate=" + hireDate +
                ", fireDate=" + fireDate +
                ", phone='" + phone + '\'' +
                '}';
    }
}
