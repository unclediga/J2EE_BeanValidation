package ru.unclediga.custom;

import ru.unclediga.custom.validator.ChronoOrder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ChronoOrder
public class Dept {
    @EntityId
    String dept_id;
    String name;
    Date openDate;
    Date closeDate;
    List<Emp> emps;

    public Dept(String dept_id, String name, Date openDate, Date closeDate, List<Emp> emps) {
        this.dept_id = dept_id;
        this.name = name;
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.emps = new ArrayList<>(emps);
    }

    public void addEmp(Emp emp) {
        emps.add(emp);
    }

    public String getDept_id() {
        return dept_id;
    }

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dept_id='" + dept_id + '\'' +
                ", name='" + name + '\'' +
                ", openDate=" + openDate +
                ", closeDate=" + closeDate +
                ", emps=" + emps +
                '}';
    }
}
